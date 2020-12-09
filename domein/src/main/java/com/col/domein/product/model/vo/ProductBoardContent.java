package com.col.domein.product.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductBoardContent {
	
	private int articleNo;
	private String title;
	private int business_key;//사업자 번호
	private Date written_Day;//등록일
	private Date modified_Date;//
	private String sale_content;//상세 설명
	private int order_count;//주문수량
	private int sale_status_no;//판매중 /품절.
}
