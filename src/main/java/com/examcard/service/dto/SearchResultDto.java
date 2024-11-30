package com.examcard.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class SearchResultDto {
	private long searchCount;
	List<ApplicationDto> customerApplicationDtoList;
}
