package com.col.domein.board.model.vo;

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
public class BoardKnowBattle {
	
	private int threadKey;
	private String title;
	private int writerKey;
	private Date writtenDate;
	private Date modifiedDate;
	private int readCount;
	private int threadStatusNo;

}
