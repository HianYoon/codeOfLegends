package com.col.domein.auctionComment.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AuctionCommentLike {
	
	private int commentNo;
	private int actorKey;
	private int LikedDate;

}
