package com.col.domein.product.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Attachement {
	private int productNo;//상품 넘버
	private int product_image_No;//이미지 넘버
	private String origin_File_name;//찐 파일 이름
	private String renamed_File_name;//저장된 이름
	

}
