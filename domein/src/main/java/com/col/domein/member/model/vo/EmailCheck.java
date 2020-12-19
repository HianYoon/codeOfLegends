package com.col.domein.member.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailCheck {
	
	private int memberKey;
	private String confirmationKey;
	private int dateDif;
	private int tryCount;
}
