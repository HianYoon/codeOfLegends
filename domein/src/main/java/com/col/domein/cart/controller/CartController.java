 package com.col.domein.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.cart.model.service.CartService;
import com.col.domein.cart.model.vo.Cart;
import com.col.domein.member.model.vo.Member;
import com.col.domein.product.model.vo.ProductAll;
@Controller
@SessionAttributes({"cart","list"})//cart 키로 attribute는 세션객체에 저장됨.

//@SessionAttributes 파라미터로 지정된 이름과 같은 이름이 @ModelAttribute에 지정되어잇을경우
//메소드가 반환되는 값은 세션에 저장된다
//2.@sessionAttributes의 파라미터와 같은 이름이 @ModelAttribute에 잇을경우 세션에 있는 객체를 가져온후
//클라이언트로 전송받은 값을 설정한다.
//3.@sessionAttribute가 잇을경우 파라미터로 지정된 이름으로 등록된 세션정보를 읽어와서 변수에 할당된다.
//4.SessionStatus는 컨트롤러 메소드의 파라미터로 사용할수있는 스프링 내장타입이다.
//현재 컨트롤러의 @SessionAttributes에 의해 저장된 오브젝트를 제거할수있다.
public class CartController {
	
	@Autowired
	private CartService service;
	@Autowired
	private Member m;
	@RequestMapping("/cart/cart.do")
	public ModelAndView cart( Cart c,ProductAll p,ModelAndView mv
			){
		System.out.println(""+c);
		System.out.println(""+p);
		//비회원시 장바구니클릭시
		//session.id값 생성
		String loc="";
		int memberNum;
		if(c.getMemberKey()==0) {
			for(int i=1; i<=1;i++) {
				 memberNum= (int)(Math.random()*1000000000+1);//랜덤값으로 임시멤버키부여
				System.out.println("임시번호:"+memberNum);
				c.setMemberKey(memberNum);
				System.out.println("c"+c);
				//service.insertProductCart(c);
				//cart란 아이디로 c객체에 담은 정보를 저장.
				//cart는 @SessionAttributes설정을 통해 세션객체에 담기게 된다.
				
				//상품을 담을 객체를 선언해준다.
				List<Map> list=new ArrayList<Map>();
						list=service.selectCartOne(c.getProductNo());
						System.out.println("list:"+list);//상품이 담겨야한다.담겨진다.listmap으로 담겨진다.
				mv.addObject("list",list);
				mv.addObject("cart",c);	
				mv.addObject("msg","비회원장바구니");
				mv.addObject("loc","/");
			mv.setViewName("cart/cart");
			}
		}
        //@ModelAttribute는 sumit된 form의 내용을 저장해서 전달받거나, 다시 뷰로 넘겨서 출력하기 위해 사용되는 오브젝트 이다.

        //도메인 오브젝트나 DTO의 프로퍼티에 요청 파라미터를 바인딩해서 한번에 받으면 @ModelAttribute 라고 볼 수 있다.

        //@ModelAttribute는 컨트롤러가 리턴하는 모델에 파라미터로 전달한 오브젝트를 자동으로 추가해준다.
		return mv;
	}
	@RequestMapping("/cart/insert.do")
	public ModelAndView productInsertCart(ModelAndView mv,int memberNum ) {
		Map<String,Object> map=new HashMap<>();
		//hashmap은 map<key,value>로 이뤄져잇고
		//key값은 중복이 불가능하고 value는 중복이 가능하다.
		//value에 null값도 사용이 가능하다.
		//전달할 정보가 많을경우에는 HashMap<>을 사용하는것이 좋다.
		//장바구니에 담을 값들이 많기때문에 여기선 HashMap<>를 사용한다.

//		mv.addObject("");
		mv.setViewName("cart/cart");
		return mv;
	}
}
