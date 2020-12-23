package com.col.domein.cart.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.cart.model.service.CartService;
import com.col.domein.cart.model.vo.Cart;
import com.col.domein.member.model.vo.Member;
@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	@Autowired
	private Member m;
	@RequestMapping("/cart/cart.do")
	public <MutipartFile> ModelAndView cart(ModelAndView mv,@ModelAttribute Cart c,HttpSession session
			){
		System.out.println(""+c);
        //@ModelAttribute는 sumit된 form의 내용을 저장해서 전달받거나, 다시 뷰로 넘겨서 출력하기 위해 사용되는 오브젝트 이다.

        //도메인 오브젝트나 DTO의 프로퍼티에 요청 파라미터를 바인딩해서 한번에 받으면 @ModelAttribute 라고 볼 수 있다.

        //@ModelAttribute는 컨트롤러가 리턴하는 모델에 파라미터로 전달한 오브젝트를 자동으로 추가해준다.
		//로그인 여부를 체크하기위해 세션에 저장된 memberkey확인
		
			//로그인하지않은상태이면  amount1개로 설정해서 저장.
		
		//int memberkey=(int)session.getAttribute("memberkey");
		if(c.getMemberKey()==0) {
			//로그인하지않은상태이면 로그인 화면으로 이동
			
			return mv;
		}
	
		service.insertProductCart(c);//장바구니테이블에 저장됨
		mv.addObject("");
		mv.setViewName("cart/cart");//장바구니 목록으로 이동

		return mv;
	}
	@RequestMapping("/cart/insert.do")
	public ModelAndView productInsertCart(ModelAndView mv) {
		Map<String,Object> map=new HashMap<>();
		//hashmap은 map<key,value>로 이뤄져잇고
		//key값은 중복이 불가능하고 value는 중복이 가능하다.
		//value에 null값도 사용이 가능하다.
		//전달할 정보가 많을경우에는 HashMap<>을 사용하는것이 좋다.
		//장바구니에 담을 값들이 많기때문에 여기선 HashMap<>를 사용한다.
//		System.out.println(memberkey);
//		int memberkey1=(int)session.getAttribute("signedInMember");
//		System.out.println(""+memberkey1);
//		if(memberkey1==(c.getMemberKey())&& memberkey1!=0) {
//			c.setMemberKey(memberkey1);
//			
//			
//			
//			System.out.println("양:"+c.getAmount());
//			System.out.println("멤버번호:"+c.getMemberKey());
//			System.out.println("상품번호"+c.getProductNo());
//			
//			int result=service.insertProductCart(c);
//			mv.addObject("cart");
//			mv.setViewName("/cart/insert.do");
//		mv.addObject("");
		mv.setViewName("cart/cart");
		return mv;
	}
}
