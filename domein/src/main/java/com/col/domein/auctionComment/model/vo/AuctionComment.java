package com.col.domein.auctionComment.model.vo;

import java.sql.Date;

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
public class AuctionComment {
	private int auctionCommentNo;
	private String commentContent;
	private int writerKey;
	private Date writerDate;
	private Date modifiedDate;
	private int articleStatusNo;
	private int refArticle;
	private int refComment;
	private String originalFileName;
	private String renamedFileName;

}
