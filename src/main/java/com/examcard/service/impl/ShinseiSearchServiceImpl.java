package com.examcard.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.MessageHelper;
import com.examcard.exception.BusinessException;
import com.examcard.repository.CustomerApplicationRepository;
import com.examcard.repository.entity.CustomerApplication;
import com.examcard.repository.entity.CustomerApplicationSearchParam;
import com.examcard.service.ShinseiSearchService;
import com.examcard.service.dto.ShinseiDto;
import com.examcard.service.dto.ShinseiSearchInputDto;
import com.examcard.service.dto.ShinseiSearchOutputDto;

@Service
@Transactional
public class ShinseiSearchServiceImpl implements ShinseiSearchService {

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

	public ShinseiSearchOutputDto search(ShinseiSearchInputDto inputDto) {
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
		List<ShinseiDto> customerApplicationDtoList = customerApplications.stream().map(customerApplication -> {
			ShinseiDto applicationDto = new ShinseiDto();
			BeanUtils.copyProperties(customerApplication, applicationDto);
			return applicationDto;
		}).collect(Collectors.toList());
			
		ShinseiSearchOutputDto outputDto = new ShinseiSearchOutputDto();
		outputDto.setPageNo(pageNo);
		outputDto.setPageCount(pageCount);
		outputDto.setPageSize(PAGENATION_SIZE);
		outputDto.setSearchCount(searchCount);
		outputDto.setCustomerApplicationDtoList(customerApplicationDtoList);
		return outputDto;
	}

	private long count(ShinseiSearchInputDto inputDto) {
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(inputDto, customerApplication);
		return customerApplicationRepository.count(customerApplication);
	}
}
