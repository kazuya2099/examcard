package com.examcard.dto.customer.sales;

import java.util.List;

import lombok.Data;

@Data
public class SearchResultDto {
	private long searchCount;
	List<ApplicationDto> customerApplicationDtoList;
}
