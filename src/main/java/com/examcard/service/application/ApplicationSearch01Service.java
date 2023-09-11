package com.examcard.service.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.CodeList;
import com.examcard.component.common.MessageHelper;
import com.examcard.dto.application.ApplicationSearch01InputDto;
import com.examcard.dto.application.ApplicationSearch01OutputDto;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.entity.CustomerApplication;
import com.examcard.exception.BusinessException;
import com.examcard.repository.application.CustomerApplicationRepository;
import com.examcard.repository.application.CustomerApplicationSearchParam;

@Service
@Transactional
public class ApplicationSearch01Service {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	@Autowired
	private MessageHelper messageHelper;

	@Value("${rows.per.page}")
	private int ROWS_PER_PAGE;

	@Value("${pagenation.size}")
	private int PAGENATION_SIZE;

	@Value("${customer.application.search.max.count}")
	private int SEARCH_MAX_COUNT;

	public ApplicationSearch01OutputDto search(ApplicationSearch01InputDto inputDto) {
		long searchCount = count(inputDto);
		int pageNo = (inputDto.getPageNo() == null || inputDto.getPageNo() < 1) ? 1 : inputDto.getPageNo();
		int pageCount = (int) searchCount / ROWS_PER_PAGE;
		
		if (searchCount > SEARCH_MAX_COUNT) {
			throw new BusinessException(messageHelper.getMessage(
					"business.error.search.max.count", new String[] {String.valueOf(SEARCH_MAX_COUNT)}));
		}
		
		CustomerApplicationSearchParam customerApplicationSearchParam = new CustomerApplicationSearchParam();
		BeanUtils.copyProperties(inputDto, customerApplicationSearchParam);
		customerApplicationSearchParam.setStart((pageNo - 1) * PAGENATION_SIZE);
		customerApplicationSearchParam.setEnd(PAGENATION_SIZE);
		List<CustomerApplication> customerApplications = customerApplicationRepository.select(customerApplicationSearchParam);
		List<ApplicationDto> customerApplicationDtoList = customerApplications.stream().map(customerApplication -> {
			ApplicationDto applicationDto = new ApplicationDto();
			BeanUtils.copyProperties(customerApplication, applicationDto);
			codeList.setCodeName(applicationDto);
			return applicationDto;
		}).collect(Collectors.toList());
			
		ApplicationSearch01OutputDto outputDto = new ApplicationSearch01OutputDto();
		outputDto.setPageNo(pageNo);
		outputDto.setPageCount(pageCount);
		outputDto.setPageSize(PAGENATION_SIZE);
		outputDto.setSearchCount(searchCount);
		outputDto.setCustomerApplicationDtoList(customerApplicationDtoList);
		return outputDto;
	}

	private long count(ApplicationSearch01InputDto inputDto) {
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(inputDto, customerApplication);
		return customerApplicationRepository.count(customerApplication);
	}
}
