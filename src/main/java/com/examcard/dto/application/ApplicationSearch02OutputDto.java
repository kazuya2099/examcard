package com.examcard.dto.application;

import java.util.List;

import com.examcard.dto.customer.sales.ApplicationDto;

import lombok.Data;

@Data
public class ApplicationSearch02OutputDto {

	private Integer pageNo;
	private Integer pageCount;
	private Integer pageSize;
	private long searchCount;
	private String error;
	List<ApplicationDto> customerApplicationDtoList;
}
