package com.col.domein.auction.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AuctionOrderHistory {
	
	private int orderNo;
	private int bidKey;

}
