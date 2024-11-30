package com.examcard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.examcard.entity.CustomerApplication;
import com.examcard.exception.BusinessException;
import com.examcard.repository.application.CustomerApplicationRepository;
import com.examcard.repository.application.CustomerApplicationSearchParam;
import com.examcard.service.dto.ApplicationDto;
import com.examcard.service.dto.SearchDto;
import com.examcard.service.dto.SearchResultDto;

@Service
public class SearchCustomerApplicationService {

	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	@Autowired
	private MessageSource messageSource;

	@Value("${rows.per.page}")
	private int ROWS_PER_PAGE;

	@Value("${pagenation.size}")
	private int PAGENATION_SIZE;

	@Value("${customer.application.search.max.count}")
	private int SEARCH_MAX_COUNT;

	public SearchResultDto search(SearchDto searchDto) {
		long searchCount = count(searchDto);
		int pageNo = (searchDto.getPageNo() == null || searchDto.getPageNo() < 1) ? 1 : 
			searchDto.getPageNo();
		int pageCount = (int) searchCount / ROWS_PER_PAGE;
		searchDto.setPageNo(pageNo);
		searchDto.setPageCount(pageCount);
		
		if (searchCount > SEARCH_MAX_COUNT) {
			throw new BusinessException(messageSource.getMessage(
					"business.error.search.max.count", new String[] {String.valueOf(SEARCH_MAX_COUNT)}, null));
		}
		
		CustomerApplicationSearchParam customerApplicationSearchParam = new CustomerApplicationSearchParam();
		BeanUtils.copyProperties(searchDto, customerApplicationSearchParam);
		customerApplicationSearchParam.setStart((pageNo - 1) * PAGENATION_SIZE);
		customerApplicationSearchParam.setEnd(PAGENATION_SIZE);
		List<CustomerApplication> customerApplications = 
				customerApplicationRepository.select(customerApplicationSearchParam);
		List<ApplicationDto> customerApplicationDtoList = new ArrayList<>();
		customerApplications.stream().map(customerApplication -> {
			ApplicationDto applicationDto = new ApplicationDto();
			BeanUtils.copyProperties(customerApplication, applicationDto);
			return applicationDto;
		}).collect(Collectors.toList());
		SearchResultDto searchResultDto = new SearchResultDto();
		searchResultDto.setSearchCount(searchCount);
		searchResultDto.setCustomerApplicationDtoList(customerApplicationDtoList);
		return searchResultDto;
	}

	private long count(SearchDto searchDto) {
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(searchDto, customerApplication);
		return customerApplicationRepository.count(customerApplication);
	}
}
