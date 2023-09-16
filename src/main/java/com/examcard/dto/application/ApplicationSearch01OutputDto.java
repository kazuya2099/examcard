package com.examcard.dto.application;

import java.util.List;
import java.util.Map;

import com.examcard.dto.customer.sales.ApplicationDto;

import lombok.Data;

@Data
public class ApplicationSearch01OutputDto {
	
	private Integer pageNo;
	private Integer pageCount;
	private Integer pageSize;
	private long searchCount;
	private String error;
	private Map<String, String> applicationStatus;
	private Map<String, String> setaiFamily;
	private Map<String, String> setaiStatus;
	private Map<String, String> setaiLoan;
	private Map<String, String> employmentStatus;
	private Map<String, String> companyIndustryType;
	private List<ApplicationDto> customerApplicationDtoList;
}
