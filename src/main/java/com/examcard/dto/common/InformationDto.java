package com.examcard.dto.common;

import java.util.Date;

import lombok.Data;

@Data
public class InformationDto {

	private long id;
	private String message;
	private Date startDate;
	private Date endDate;
}
