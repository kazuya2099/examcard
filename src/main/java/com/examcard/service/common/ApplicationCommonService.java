package com.examcard.service.common;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.CodeList;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.entity.CustomerApplication;
import com.examcard.repository.application.CustomerApplicationRepository;

@Service
@Transactional
public class ApplicationCommonService {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	public ApplicationDto getApplication(String id) {
		CustomerApplication customerApplication = customerApplicationRepository.selectById(id);
		ApplicationDto customerApplicationDto = new ApplicationDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		codeList.setCodeName(customerApplicationDto);
		return customerApplicationDto;
	}
	
	public ApplicationDto getApplicationForUpdate(String id) {
		CustomerApplication customerApplication = customerApplicationRepository.selectByIdForUpdate(id);
		ApplicationDto customerApplicationDto = new ApplicationDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		codeList.setCodeName(customerApplicationDto);
		return customerApplicationDto;
	}
}
