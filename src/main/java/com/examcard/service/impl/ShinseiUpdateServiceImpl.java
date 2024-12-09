package com.examcard.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.component.common.MessageHelper;
import com.examcard.exception.BusinessException;
import com.examcard.repository.CustomerApplicationRepository;
import com.examcard.repository.entity.CustomerApplication;
import com.examcard.service.ShinseiUpdateService;
import com.examcard.service.dto.ShinseiDto;
import com.examcard.service.dto.UserDto;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class ShinseiUpdateServiceImpl implements ShinseiUpdateService {

	@Autowired
	ShinseiCommonServiceImpl applicationCommonService;
	
	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	@Autowired
	private MessageHelper messageHelper;
	
	public ShinseiDto getApplication(String id) {
		return applicationCommonService.getApplication(id);
	}
	
	public void update(ShinseiDto applicationDto) {
		ShinseiDto before = applicationCommonService.getApplicationForUpdate(applicationDto.getId());
		Date beforeUpdateDate = before.getUpdateDate();
		Date updateDate = applicationDto.getUpdateDate();
		if (updateDate.compareTo(beforeUpdateDate) != 0) {
			throw new BusinessException(messageHelper.getMessage("business.error.lockerror"));
		}
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(applicationDto, customerApplication);
		UserDto userDto = AuthenticationUtil.getUserDto();
		customerApplication.setUpdateDate(OperationDateUtil.getDate());
		customerApplication.setUpdateUser(userDto.getId());
		customerApplicationRepository.update(customerApplication);
	}
}
