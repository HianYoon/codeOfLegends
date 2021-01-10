package com.col.domein.order.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;
import com.col.domein.order.model.service.OrderService;
import com.col.domein.order.model.vo.Order;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@RestController
@RequestMapping("/rest/order")
public class OrderRestController {

	@Autowired
	private OrderService os;

	@Autowired
	private MemberService ms;

	@PostMapping("/authenticate")
	public int authenticateOrder(HttpSession session, String imp_uid, String merchant_uid, String receiverTel,
			@RequestParam(defaultValue = "0") String discount, @RequestParam(defaultValue = "") String receiverComment,
			String totalPrice) {
		Member m = (Member) session.getAttribute("signedInMember");

		int orderKey = -1;
		int amount = Integer.parseInt(totalPrice);
		String api_key = "9845619002442630";
		String api_secret = "4ikpSZKORdkvnfxsuWSICeLlnLWZSDcXVxnOw8CnlWTJcqcGn4o0jalGWiGOWTMSq9GWhjkDfdmsEy82";

		IamportClient client = new IamportClient(api_key, api_secret);
		IamportResponse<AccessToken> res = null;

		try {
			res = client.getAuth();
		} catch (IamportResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IamportResponse<Payment> payRes = null;

		try {
			payRes = client.paymentByImpUid(imp_uid);
		} catch (IamportResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Payment payment = payRes.getResponse();
		if (imp_uid.equals(payment.getImpUid()) && merchant_uid.equals(payment.getMerchantUid())
				&& amount == payment.getAmount().intValue()) {

//			서버저장 로직 쓸것!
			System.out.println(m.getMemberKey() + "님의 결제가 정상적으로 완료되었습니다!");
			Order order = new Order();
			order.setMerchantUid(merchant_uid);
			order.setBuyerKey(m.getMemberKey());
			order.setPaymentMethod(payment.getPayMethod());
			order.setApplyNum(payment.getApplyNum());
			order.setBuyerTel(payment.getBuyerTel());
			order.setReceiverTel(receiverTel);
			order.setDiscount(Integer.parseInt(discount));
			order.setReceiverComment(receiverComment);
			order.setReceiverName(payment.getBuyerName());
			order.setReceiverPostcode("" + payment.getBuyerPostcode());
			order.setReceiverAddr(payment.getBuyerAddr());
			
			orderKey = os.insertOrder(order);

		} else {
			return -1;
		}
		return orderKey;
	}

}
