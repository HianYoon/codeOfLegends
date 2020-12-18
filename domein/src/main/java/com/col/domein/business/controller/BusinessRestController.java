package com.col.domein.business.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.col.domein.business.model.service.BusinessService;

@RestController
@RequestMapping("/rest/business")
public class BusinessRestController {
	
	@Autowired
	private BusinessService bs;
	
	@PostMapping(value="/signup/business/no")
	public Map<String,String> businessNoValidator(String data) throws IOException {
		Map<String, String> result = new HashMap<String, String>();
		result.put("businessName", "");
		result.put("businessTel", "");
		result.put("businessAddress", "");
		String param = "<map id='ATTABZAA001R08'><pubcUserNo/><mobYn>N</mobYn><inqrTrgtClCd>1</inqrTrgtClCd><txprDscmNo>" + 
				data+ 
				"</txprDscmNo><dongCode>05</dongCode><psbSearch>Y</psbSearch><map id='userReqInfoVO'/></map>";
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		RestTemplate rest = new RestTemplate();
		rest.setMessageConverters(messageConverters);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/xml; charset=UTF-8");
		HttpEntity<String> request = new HttpEntity<String>(param, headers);
		ResponseEntity<String> response = rest.postForEntity("https://teht.hometax.go.kr/wqAction.do?actionId=ATTABZAA001R08&screenId=UTEABAAA13&popupYn=false&realScreenId=", request, String.class);
		
//		사업자 번호 활성화 상태 시 로직
		String successMsg = "The business registration number is registered";
		if(response.getBody().contains(successMsg)) {
			
//			1.db에서 이미 등록된 번호가 아닌지 체크
			
			boolean isEmptyBusinessNo = bs.isEmptyBusinessNo(data);
			
//			2.JSOUP을 이용해 정보 긁어오기
			if(isEmptyBusinessNo) {
				
				String url = "http://bizno.net/article/"+data;
				Document doc = Jsoup.connect(url).get();
				
				String businessName = doc.select(".title .titles h4").text();
				String businessTel = "";
				String businessAddress = ""; 
				
				Elements ths = doc.select(".table_guide01 th");
				for(Element th : ths) {
					String thText = th.text();
					
					
					if(thText.equals("전화번호")) {
						businessTel = th.parent().child(1).text();
					}
					if(thText.equals("회사주소")) {
						businessAddress=th.parent().child(1).text();
					}
				}
				
				result.put("businessName", businessName);
				result.put("businessTel", businessTel);
				result.put("businessAddress", businessAddress);
				
			}
		} 
			
		return result;
	}
}
