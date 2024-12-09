package com.examcard.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.constant.ShinseiStatus;
import com.examcard.repository.CustomerApplicationRepository;
import com.examcard.repository.entity.CustomerApplication;
import com.examcard.service.RegistCustomerApplicationService;
import com.examcard.service.dto.ShinseiDto;
import com.examcard.service.dto.UserDto;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class RegistCustomerApplicationServiceImpl implements RegistCustomerApplicationService {

	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	@Autowired
	private SequenceServiceImpl sequenceService;
	
	@Autowired
	private ShinseiCommonServiceImpl applicationCommonService;

	public void insert(ShinseiDto applicationDto) {
		String id = sequenceService.getSequence("m_customer_apl");
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(applicationDto, customerApplication);
		UserDto userDto = AuthenticationUtil.getUserDto();
		customerApplication.setId(id);
		customerApplication.setCreateDate(OperationDateUtil.getDate());
		customerApplication.setCreateUser(userDto.getId());
		customerApplication.setUpdateDate(OperationDateUtil.getDate());
		customerApplication.setUpdateUser(userDto.getId());
		customerApplication.setApplicationStatus(ShinseiStatus.APPLICATION.getCode());
		customerApplicationRepository.insert(customerApplication);
	}
	
	public ShinseiDto getApplication(String id) {
		return applicationCommonService.getApplication(id);
	}
}
