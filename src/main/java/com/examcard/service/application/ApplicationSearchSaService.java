package com.examcard.service.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.examcard.component.common.MessageResolver;
import com.examcard.dao.application.CustomerApplication;
import com.examcard.dao.application.CustomerApplicationDao;
import com.examcard.dto.application.ApplicationSearchSaInputDto;
import com.examcard.dto.application.ApplicationSearchSaOutputDto;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.BusinessException;

@Service
public class ApplicationSearchSaService extends AbstractApplicationService {

	@Autowired
	private CustomerApplicationDao customerApplicationDao;
	
	@Autowired
	private MessageResolver messageResolver;

	@Value("${rows.per.page}")
	private int ROWS_PER_PAGE;

	@Value("${pagenation.size}")
	private int PAGENATION_SIZE;

	@Value("${customer.application.search.max.count}")
	private int SEARCH_MAX_COUNT;

	public ApplicationSearchSaOutputDto search(ApplicationSearchSaInputDto inputDto) {
		long searchCount = count(inputDto);
		int pageNo = (inputDto.getPageNo() == null || inputDto.getPageNo() < 1) ? 1 : inputDto.getPageNo();
		int pageCount = (int) searchCount / ROWS_PER_PAGE;
		
		if (searchCount > SEARCH_MAX_COUNT) {
			throw new BusinessException(messageResolver.getMessage(
					"business.error.search.max.count", new String[] {String.valueOf(SEARCH_MAX_COUNT)}));
		}
		
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(inputDto, customerApplication);
		customerApplication.setStart((pageNo - 1) * PAGENATION_SIZE);
		customerApplication.setEnd(PAGENATION_SIZE);
		customerApplication.setPageCount(pageCount);
		List<CustomerApplication> customerApplications = customerApplicationDao.select(customerApplication);
		List<ApplicationDto> customerApplicationDtos = new ArrayList<>();
		
		for (CustomerApplication e : customerApplications) {
			ApplicationDto dto = new ApplicationDto();
			BeanUtils.copyProperties(e, dto);
			setCodeName(dto);
			customerApplicationDtos.add(dto);
		}
			
		ApplicationSearchSaOutputDto outputDto = new ApplicationSearchSaOutputDto();
		outputDto.setPageNo(pageNo);
		outputDto.setPageCount(pageCount);
		outputDto.setPageSize(PAGENATION_SIZE);
		outputDto.setSearchCount(searchCount);
		outputDto.setCustomerApplicationDtos(customerApplicationDtos);
		return outputDto;
	}

	private long count(ApplicationSearchSaInputDto inputDto) {
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(inputDto, customerApplication);
		return customerApplicationDao.count(customerApplication);
	}
}
