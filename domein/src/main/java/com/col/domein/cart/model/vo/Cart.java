package com.col.domein.cart.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Cart {
	private int memberKey;
	private int productNo;
	private int amount;
	

}
