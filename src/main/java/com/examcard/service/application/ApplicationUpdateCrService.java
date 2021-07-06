package com.examcard.service.application;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.component.common.MessageResolver;
import com.examcard.dao.application.CustomerApplication;
import com.examcard.dao.application.CustomerApplicationDao;
import com.examcard.dto.common.UserDto;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.BusinessException;
import com.examcard.util.common.OperationDateUtil;

@Service
public class ApplicationUpdateCrService extends AbstractApplicationService {

	@Autowired
	private CustomerApplicationDao customerApplicationDao;
	
	@Autowired
	private MessageResolver messageResolver;
	
	public void update(ApplicationDto applicationDto) {
		ApplicationDto before = getApplicationForUpdate(applicationDto.getId());
		Date beforeUpdateDate = before.getUpdateDate();
		Date updateDate = applicationDto.getUpdateDate();
		if (updateDate.compareTo(beforeUpdateDate) != 0) {
			throw new BusinessException(messageResolver.getMessage("business.error.lockerror"));
		}
		CustomerApplication customerApplication = new CustomerApplication();
		BeanUtils.copyProperties(applicationDto, customerApplication);
		UserDto userDto = AuthenticationUtil.getUserDto();
		customerApplication.setUpdateDate(OperationDateUtil.getDate());
		customerApplication.setUpdateUser(userDto.getId());
		customerApplicationDao.update(customerApplication);
	}
}
