package com.col.domein.product.model.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	private int ProductNo;
	private String productName;//상품명
	private String productQuality;//등급 ,레벨
	private String Origin;//원산지
	private int productQuantity;//개수또는 단위의 수(1 or 10:kg)
	private String measureUnit;//단위
	private int price;//가격
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date productionDate;//생산일
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiryDate;//유통기한
	private int articleNo;
	private int productStatusNo;
	

}
