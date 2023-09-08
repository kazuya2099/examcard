package com.examcard.service.customer.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.dto.customer.sales.SearchDto;
import com.examcard.dto.customer.sales.SearchResultDto;
import com.examcard.exception.BusinessException;
import com.examcard.repository.application.CustomerApplication;
import com.examcard.repository.application.CustomerApplicationRepository;
import com.examcard.service.customer.AbstractCustomerService;
import com.examcard.service.customer.CommonCustomerService;

@Service
public class SearchCustomerApplicationService extends AbstractCustomerService {

	@Autowired
	private CommonCustomerService commonCustomerService;

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
		
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(searchDto, customerApplication);
		customerApplication.setStart((pageNo - 1) * PAGENATION_SIZE);
		customerApplication.setEnd(PAGENATION_SIZE);
		customerApplication.setPageCount(pageCount);
		List<CustomerApplication> customerApplications = 
				customerApplicationRepository.select(customerApplication);
		List<ApplicationDto> customerApplicationDtos = new ArrayList<>();
		customerApplications.forEach(e -> {
			ApplicationDto dto = new ApplicationDto();
			BeanUtils.copyProperties(e, dto);
			commonCustomerService.setCodeName(dto);
			customerApplicationDtos.add(dto);
		});
		SearchResultDto searchResultDto = new SearchResultDto();
		searchResultDto.setSearchCount(searchCount);
		searchResultDto.setCustomerApplicationDtos(customerApplicationDtos);
		return searchResultDto;
	}

	private long count(SearchDto searchDto) {
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(searchDto, customerApplication);
		return customerApplicationRepository.count(customerApplication);
	}
}
