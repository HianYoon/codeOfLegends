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
	public ModelAndView insertBoardSaleContent(BoardProductSaleContent bp,ModelAndView mv) {
		
		System.out.println(""+bp);
		
		bp.setTitle(bp.getTitle().trim());
		bp.setSaleContent(bp.getSaleContent());
		
		int result=service.insertBoardSContent(bp);
		mv.addObject("msg",result>0?"입력성공":"입력실패");
		mv.addObject("loc","/product/into.do");
		mv.setViewName("common/msg");
		return mv;
		
	}

	//Product 등록
	
	@RequestMapping("/product/insert.do")
	public ModelAndView insertProduct(Product p, ModelAndView mv,
			@RequestParam(value="upFile",
			required=false) MultipartFile[] upFile,
			HttpSession session) {
		System.out.println(""+p);
	
		p.setProductName(p.getProductName().trim());
		p.setOrigin(p.getOrigin().trim());
		p.setProductQuality(p.getProductQuality().trim());
		p.setMeasureUnit(p.getMeasureUnit().trim());
		System.out.println("객체도 ?"+p);
		System.out.println("널이야왜?"+upFile);
		if(p.getRemainingQuantity()==0) {
			p.setRemainingQuantity(p.getProductQuantity());
		
		}
		
		System.out.println(""+p.getRemainingQuantity());
		
		//upload실제 경로를 가져와야하는데 없으니깐 만들어준다.
		String path=session.getServletContext().getRealPath("/resources/upload/product");
		File dir=new File(path);
		if(!dir.exists()) dir.mkdirs(); //dir.exists()존재하지않으면 dir.mkdirs()생성하라.
		//제너럴 선언해라
		List<Attachement> files=new ArrayList<Attachement>();
		//다중 파일 업로드하기  MultipartFile객체의 transferTo()메소드 이용파일을 저장
		//renamed해줘야함 -> 파일명을 재정의하는것
		for(MultipartFile f: upFile) {
			if(!f.isEmpty()) {
				//파일명 생성하기
				String origianlName=f.getOriginalFilename();
				String ext=origianlName.substring(origianlName.lastIndexOf(".")+1);
				
				//리네임 규칙
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
				
				int rndValue=(int)(Math.random()*10000);
				String reName=sdf.format(System.currentTimeMillis())+"_"+rndValue+"."+ext;
				try {
					f.transferTo(new File(path+"/"+reName));
				}catch(IOException e) {
					e.printStackTrace();
				}
				//1.attachment 빌더 오노테이션을 설정해주고 has a 관계
				Attachement a=Attachement.builder().origin_File_name(origianlName)
						.renamed_File_name(reName).build();
				files.add(a);
			}
		}
		
		
		int result=service.insertProductFileList(p,files);
		 mv.addObject("msg",result>0?"입력성공":"입력실패");
		 mv.addObject("loc","/product/into.do");//productList로 보내기
		 mv.setViewName("common/msg");
		return mv;
	}
}