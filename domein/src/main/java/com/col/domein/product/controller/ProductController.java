package com.col.domein.product.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.common.pageBar.PageBarFactory;
import com.col.domein.product.model.service.ProductService;
import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;




@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	
	//메인에서 product.jsp로 페이지 전환
	@RequestMapping("/product/into.do")
	public String product() {
		return "product/product";
	}
	
	//BoardSaleContent등록
	@RequestMapping("/boardSaleContent/insert.do")
	public ModelAndView insertBoardSaleContent(BoardProductSaleContent bp,ModelAndView mv,int businessKey) {
		
		System.out.println(""+bp);
		businessKey=1;
		bp.setBusinessKey(businessKey);
		
		bp.setTitle(bp.getTitle().trim());
		bp.setSaleContent(bp.getSaleContent());
		
		int result=service.insertBoardSContent(bp);
		mv.addObject("msg",result>0?"입력성공":"입력실패");
		mv.addObject("boardContent",bp);
		mv.addObject("loc","/product/into.do");
		mv.setViewName("common/msg");
		return mv;
		
	}

	//Product 등록
	
	@RequestMapping("/product/insert.do")
	public ModelAndView insertProduct(Product p, ModelAndView mv,int articleNo,
			@RequestParam(value="upFile",
			required=false) MultipartFile[] upFile,
			HttpSession session) {
		System.out.println(""+p);
	
		p.setProductName(p.getProductName().trim());
		p.setOrigin(p.getOrigin().trim());
		p.setProductQuality(p.getProductQuality().trim());
		p.setMeasureUnit(p.getMeasureUnit().trim());
		p.setArticleNo(articleNo);
		System.out.println("객체도 ?"+p);
		System.out.println("널이야왜?"+upFile);
		System.out.println("0이니?"+p.getProductNo());
		if(p.getRemaningQuantity()==0) {
			p.setRemaningQuantity(p.getProductQuantity());
		
		}
		
		System.out.println(""+p.getRemaningQuantity());
		
		//upload실제 경로를 가져와야하는데 없으니깐 만들어준다.
		String path=session.getServletContext().getRealPath("/resources/upload/product");
		File dir=new File(path);
		if(!dir.exists()) 
			dir.mkdirs();//mkdirs()<-폴더를 생성을해라
		//2.제너를 선언을해준다.
		List<Attachement> files=new ArrayList();
		//다중파일 업로드하기 MultipartFile객체의 transferTo()메소드 이용 파일을 저장
		//rename처리해줘야함 ->file명을 재정의 하는것
		for(MultipartFile f :upFile) {
			if(!f.isEmpty()) {
				//파일명 생성하기
				String originalName=f.getOriginalFilename();
				String ext=originalName.substring(originalName.lastIndexOf(".")+1);
				
				//리네임 규칙
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
				int rndValue=(int)(Math.random()*10000);
				String reName=sdf.format(System.currentTimeMillis())+"_"+rndValue+"."+ext;
				try {
					f.transferTo(new File(path+"/"+reName));
				}catch(IOException e) {
					e.printStackTrace();
				}
				//1.파일 attachment 빌더어노테이션을 설정해주고   --has a관계.
			 Attachement a=Attachement.builder().originFileName(originalName)
					 .renamedFileName(reName).build();
			 files.add(a);
				}
			}
			
			
			int result=service.insertProductFileList(p,files);
			mv.addObject("msg",result>0?"입력성공":"입력실패");
			mv.addObject("loc","/product/into.do");//productList로 보내기
			mv.setViewName("common/msg");
			
		
		return mv;
	}
	//productList 목록
	@RequestMapping("/product/productList.do")
	public ModelAndView selectProduct(ModelAndView mv,
			@RequestParam(value="cPage",defaultValue="1")int cPage,
			@RequestParam(value="numPerpage",defaultValue="10")int numPerpage) {
		
		mv.addObject("board",service.selectProductList(cPage,numPerpage));//순서가 바뀔시에 cPage,numPerpage 페이지넘버당 1개씩나오는 현상이 발생
		//페이징 처리
		int totalData=service.selectCount();
		mv.addObject("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "productList.do"));
		mv.addObject("totalData",totalData);
		mv.setViewName("product/product");
		return mv;
		
	}
	//productDetail 데이터 불러오기
	@RequestMapping("/product/productView.do")
	public ModelAndView selectproductDetail(ModelAndView mv,int productNo) {
		
		mv.addObject("product",service.selectProductDetail(productNo));
		mv.setViewName("product/productDetail");
		return mv;
	}
	
}
