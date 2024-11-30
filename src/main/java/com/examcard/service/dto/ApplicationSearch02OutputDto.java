package com.examcard.service.dto;

import java.util.List;

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
