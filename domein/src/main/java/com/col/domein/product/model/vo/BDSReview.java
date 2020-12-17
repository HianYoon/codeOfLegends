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
public class BDSReview {
	private int reivewNo;
	private String reviewContent;
	private int writerKey;
	private Date writtenDate;
	private Date modifiedDate;
	private int refArticle;//bds articleNo
	private int refReview;
	private String rOriginalFileName;
	private String rRenamedFileName;
}
