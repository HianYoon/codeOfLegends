package com.col.domein.product.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.product.model.service.ProductService;
import com.col.domein.product.model.vo.Attachement;
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

	//Product 등록
	
	@RequestMapping("/product/insert.do")
	public @ResponseBody ModelAndView insertProduct(Product p, ModelAndView mv,
			@RequestParam(value="upFile",
			required=false) MultipartFile[] upFile,
			HttpSession session) throws ParseException
			//@RequestParam(value="productionDate") Date productionDate,
			//@RequestParam(value="expiryDate")
			// Date expiryDate)
			 {
		
//		if((productionDate!=null&&expiryDate!=null )) {
//			p.setProductionDate(productionDate);
//			p.setExpiryDate(expiryDate);
//			 System.out.println(p.getExpiryDate());
//		}
//		
//		//파일이 없는 경우를 생각해서 RequestParam매개변수설정을 해준다.
//		//클라이언트가 바이너리파일로 보낸데이터를 데이터MultipartFile객체로 대입됨.
//		System.out.printf("productionDate","expiryDate")
//		System.out.println(expiryDate);
		
	
		p.setProductName(p.getProductName().trim());
		p.setOrigin(p.getOrigin().trim());
		p.setProductQuality(p.getProductQuality().trim());
		p.setMeasureUnit(p.getMeasureUnit().trim());
		
	


		
	
		System.out.println("객체도 ?"+p);
		System.out.println("널이야왜?"+upFile);
	
		
		
		
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
		 mv.addObject("loc","product/product");//productList로 보내기
		 mv.setViewName("common/msg");
		return mv;
	}
}