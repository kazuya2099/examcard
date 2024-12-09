package com.examcard.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.exception.BusinessException;
import com.examcard.repository.CustomerApplicationRepository;
import com.examcard.repository.entity.CustomerApplication;
import com.examcard.service.EditCustomerApplicationService;
import com.examcard.service.dto.ShinseiDto;
import com.examcard.service.dto.UserDto;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class EditCustomerApplicationServiceImpl implements EditCustomerApplicationService {

	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	@Autowired
	private ShinseiCommonServiceImpl applicationCommonService;

	@Autowired
	private MessageSource messageSource;
	
	public void update(ShinseiDto applicationDto) {
		ShinseiDto dto = applicationCommonService.getApplication(applicationDto.getId());
		Date updateDate = dto.getUpdateDate();
		Date beforeUpdateDate = applicationDto.getUpdateDate();
		if (updateDate.compareTo(beforeUpdateDate) != 0) {
			throw new BusinessException(messageSource.getMessage("error.lockerror", null, null));
		}
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(applicationDto, customerApplication);
		UserDto userDto = AuthenticationUtil.getUserDto();
		customerApplication.setUpdateDate(OperationDateUtil.getDate());
		customerApplication.setUpdateUser(userDto.getId());
		customerApplicationRepository.update(customerApplication);
	}
	
	public ShinseiDto getCustomerApplication(String id) {
		return applicationCommonService.getApplication(id);
	}
}
