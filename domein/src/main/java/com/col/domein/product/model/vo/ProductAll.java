package com.col.domein.product.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class ProductAll  {
	
	private int articleNo;
	private String title;
	private int businessKey;
	private Date writtenDate;
	private Date modifiedDate;
	private String saleContent;
	private int orderCount;
	private int saleStatusNo;
	
	private int productNo;
	private String productName;//상품명
	private String productQuality;//등급 ,레벨
	private String origin;//원산지
	private int productQuantity;//개수또는 단위의 수(1 or 10:kg)
	private String measureUnit;//단위
	private int price;//가격
	private int remaningQuantity;//남은갯수
	private int productStatusNo;//품목
	
	private int productImageNo;//이미지 넘버
	private String originFileName;//찐 파일 이름
	private String renamedFileName;//저장된 이름
	private int amount;
	private int memberKey;
	
	

	

}
