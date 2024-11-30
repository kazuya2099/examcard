package com.examcard.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.constant.ApplicationStatus;
import com.examcard.entity.CustomerApplication;
import com.examcard.repository.application.CustomerApplicationRepository;
import com.examcard.service.dto.ApplicationDto;
import com.examcard.service.dto.UserDto;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class ApplicationCreate01Service {

	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	@Autowired
	private SequenceService sequenceService;
	
	public void insert(ApplicationDto customerApplicationDto) {
		String id = sequenceService.getSequence("m_customer_apl");
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(customerApplicationDto, customerApplication);
		UserDto userDto = AuthenticationUtil.getUserDto();
		customerApplication.setId(id);
		customerApplication.setCreateDate(OperationDateUtil.getDate());
		customerApplication.setCreateUser(userDto.getId());
		customerApplication.setUpdateDate(OperationDateUtil.getDate());
		customerApplication.setUpdateUser(userDto.getId());
		customerApplication.setApplicationStatus(ApplicationStatus.APPLICATION.getCode());
		customerApplicationRepository.insert(customerApplication);
	}
	
	public void update(ApplicationDto customerApplicationDto) {
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(customerApplicationDto, customerApplication);
		UserDto userDto = AuthenticationUtil.getUserDto();
		customerApplication.setId(customerApplicationDto.getId());
		customerApplication.setUpdateDate(OperationDateUtil.getDate());
		customerApplication.setUpdateUser(userDto.getId());
		customerApplicationRepository.update(customerApplication);
	}
}
