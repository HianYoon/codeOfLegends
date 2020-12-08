package com.col.domein.product.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	private String product_Name;
	private String product_Quality;
	private String Origin;
	private int product_Quantity;
	private String measure_Unit;
	private int price;
	private Date production_Date;
	private Date expiry_Date;
	

}
