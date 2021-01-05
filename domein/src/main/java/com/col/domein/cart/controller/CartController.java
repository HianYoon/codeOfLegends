 package com.col.domein.cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.cart.model.service.CartService;
import com.col.domein.cart.model.vo.Cart;
import com.col.domein.member.model.vo.Member;
import com.col.domein.product.model.vo.ProductAll;

@Controller
@SessionAttributes({"cart","list","nomlist"})//cart 키로 attribute는 세션객체에 저장됨.


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

	
	//구매하기 
	@RequestMapping("/cart/orderToPay.do")
	public ModelAndView orderToPay(ModelAndView mv , Cart c,ProductAll p) {
		
		int pNo=c.getProductNo();//상품번호
		int mNo=c.getMemberKey();//멤버키
		int ok;
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
				mv.addObject("msg",ok>0?"등록성공":"등록실패");
			}
		 }
		List<Map> list=	service.selectProductCart(c.getMemberKey());
		mv.setViewName("Index");
		return mv;
	}
	//장바구니 추가
	@RequestMapping("/cart/cart.do")
	public ModelAndView cart( Cart c,ProductAll p,Member member,ModelAndView mv
			,HttpSession session){
		System.out.println(""+c);
		System.out.println(""+c);
		int pNo=c.getProductNo();//상품번호
		int mNo=c.getMemberKey();//멤버키
		int amount=c.getAmount();//상품갯수
		int ok;
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
			
		 }else{
			mv.setViewName("index");
			}

		
		 mv.addObject("cart",c);
		 mv.setViewName("redirect:/cart/list.do");
		 return mv;
	}

	//cart목록
	@RequestMapping("/cart/list.do")
	public ModelAndView productInsertCart(ModelAndView mv,HttpServletRequest request,Cart c) {
		System.out.println("list: memberKey"+c.getMemberKey());
		
		int memberKey=c.getMemberKey();
		TreeMap<String,Object> map=new TreeMap<String,Object>();
		int productNo=c.getProductNo();
		int amount=c.getAmount();
		System.out.println("list:"+productNo);
		if(memberKey !=0 && productNo != 0) {
			
			List<Map> cart=service.selectCartList(memberKey);
			
			
			
			System.out.println("cart"+cart);
			List<Map> list=service.selectProductCart(memberKey);
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
			mv.setViewName("cart/cart");
		}
		
		else if(memberKey==0 && productNo != 0) {
			HttpSession session= request.getSession();
		
			ProductAll pro=service.selectNonproductList(productNo);
			if(productNo == pro.getProductNo() &&pro.getAmount()!=0) {
				pro.setAmount((pro.getAmount()+amount));
			}else {
				pro.setAmount(amount);
			}
			System.out.println(""+pro);
			ArrayList nomlist=new ArrayList();
			nomlist.add(pro);
			session.setAttribute("nomlist",nomlist);
			mv.setViewName("cart/cart");
		}else {
				 
				 mv.setViewName("cart/cart");
		
		}
		return mv;
	}
	//비회원 상품 지우기 
	@RequestMapping("/cart/nonDeleteBtn")
	public String removeNoMemberCart(HttpSession session, SessionStatus ss) {
		//SessionStatus객체를 이용해서 @SessionAttributes로 등록한값을 제거 할수있음
		//SessionStatus.isComplate() 세션이 살이있는지 확인 
		if(!ss.isComplete()) {
			ss.setComplete();//세션삭제하기 
		}
		if(session !=null) session.invalidate();
		return "redirect:/";
	}
	
	//선택상품지우기
	@RequestMapping("/cart/delete.do")
	public ModelAndView deleteCart(ModelAndView mv,int memberKey,int productNo) {
		int result=service.deleteCartOne(memberKey,productNo);
		mv.addObject("msg",result>0?"상품삭제성공":"삭제실패");
		mv.setViewName("cart/cart");
		return mv;
	}
	
	//매인화면으로 돌리기
	@RequestMapping("/cart/cartIndex.do")
	public String cartToIndex() {
		return "index";
	}

}
