package com.col.domein.product.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Component
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Attachement {
	
	private int productNo;//상품 넘버
	private int productImageNo;//이미지 넘버
	private String originFileName;//찐 파일 이름
	private String renamedFileName;//저장된 이름


}
