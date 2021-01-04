package com.col.domein.productcomment.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class BDSreviewLike {
	
	private int reviewNo;
	private int actorKey;
	private Date likedDate;
	
	
}
