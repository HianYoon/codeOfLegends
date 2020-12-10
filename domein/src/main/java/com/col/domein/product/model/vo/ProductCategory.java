package com.col.domein.product.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory {
	private int ProductCategory;//카테고리 넘버
	private int productNo;//product_no

}
