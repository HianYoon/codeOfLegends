 package com.col.domein.cart.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

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
	//장바구니 추가
	@RequestMapping("/cart/cart.do")
	public ModelAndView cart( Cart c,ProductAll p,Member member,ModelAndView mv
			){
		System.out.println(""+c);
		int pNo=c.getProductNo();//상품번호
		int mNo=c.getMemberKey();//멤버키
		int amount=c.getAmount();//상품갯수
		int ok;
		System.out.println(""+c);
		 if(mNo!=0 && pNo!=0) {
			int result=service.checkProductNo(pNo,mNo);//상품이 잇는지 없는지 확인
			if(result != 0) {
				//기존상품이 있으면 상품에 갯수만 더하기
				//update시에는 amount만 넣으면 안되고정보를 담은 객체를 담아보내야한다.
				 ok=service.updateCartProductAmount(c);
				 mv.addObject("msg",ok>0?"수정성공":"수정실패");
				mv.setViewName("redirect:/cart/list.do");
			}else {	
				//기존상품이 없으면
				ok=service.insertMemberCart(c);
				mv.addObject("msg",ok>0?"담기성공":"담기실패");
				mv.setViewName("redirect:/cart/list.do");
			}
			
		 }else {
				
			}
	//	}else if(mNo==0 && pNo!=0) {
	//	TreeMap<String, Object> nonMemberCart=new TreeMap<String, Object>();
		//	nonMemberCart.put("productNo",c.getProductNo());
		//	nonMemberCart.put("amount",c.getAmount());
		//	System.out.println(nonMemberCart);
		//	mv.addObject("cart",nonMemberCart);
			
		
		 mv.addObject("cart",c);
		 mv.setViewName("redirect:/cart/list.do");
		 return mv;
	}
	/*	TreeMap<Integer,Integer> cartValue=new TreeMap<Integer,Integer>();
		//boolean containsKey(Object key) : 해당 맵이 전달된 키를 포함하고 있는지를 확인함.
		if(cartValue!=null && cartValue.containsKey(pNo)) {
			cartValue.put(pNo,cartValue.get(pNo)+amount);
			
		}else if(cartValue!=null && !cartValue.containsKey(pNo)) {
				cartValue.put(pNo, amount);
				
		}
		else {
			cartValue=new TreeMap<Integer, Integer>();
			cartValue.put(pNo,amount);
		}
		
		int sum =0;
		ArrayList<Integer> removingKey=new ArrayList<Integer>();
		//key순으로 정렬을 하려면 TreeMap을 이용해야한다.
		for(int v : cartValue.keySet()) {//keyset 은 정렬된 상태로 가져온다.
			sum+=cartValue.get(v);
			if(cartValue.get(v)==0) {
				removingKey.add(v);
			}
		}
		for(int key:removingKey) {
			cartValue.remove(key);
		}*/
        //@ModelAttribute는 sumit된 form의 내용을 저장해서 전달받거나, 다시 뷰로 넘겨서 출력하기 위해 사용되는 오브젝트 이다.

        //도메인 오브젝트나 DTO의 프로퍼티에 요청 파라미터를 바인딩해서 한번에 받으면 @ModelAttribute 라고 볼 수 있다.

        //@ModelAttribute는 컨트롤러가 리턴하는 모델에 파라미터로 전달한 오브젝트를 자동으로 추가해준다.

	@RequestMapping("/cart/list.do")
	public ModelAndView productInsertCart(ModelAndView mv,HttpSession session,Cart c) {
		System.out.println("memberKey"+c.getMemberKey());
		int memberKey=c.getMemberKey();
		TreeMap<String,Object> map=new TreeMap<String,Object>();
		int productNo=c.getProductNo();
		System.out.println(""+productNo);
		List<Map> list=service.selectProductCart(productNo);
		List<Map> cart=service.selectCartList(memberKey);
		//Treemap은 map<key,value>로 이뤄져잇고
		//key값은 중복이 불가능하고 value는 중복이 가능하다.
		//value에 null값도 사용이 가능하다.
		//키값과 value가 순서대로 정렬되어지며  검색 기능에 성능이 매우좋다.
		//전달할 정보가 많을경우에는 HashMap<>을 사용하는것이 좋다.
		//장바구니에 담을 값들이 많기때문에 여기선 HashMap<>를 사용한다.
		map.put("list", list);//장바구니정보를 map에 담아 보냄
		map.put("count",list.size());//장바구니상품의 유무
		map.put("cart",cart);//cart 물품갯수를 알기위해서
		mv.addObject("map",map); //map 변수 저장

//		mv.addObject("");
		mv.setViewName("cart/cart");
		return mv;
	}
	//선택상품지우기
	@RequestMapping("/cart/delete.do")
	public ModelAndView deleteCart(ModelAndView mv,int memberKey) {
		int result=service.deleteCartOne(memberKey);
		return mv;
	}
}
