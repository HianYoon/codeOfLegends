package com.col.domein.auction.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class AuctionStatus {
	private int auctionStatusNo;
	private int statusDesc;

}
