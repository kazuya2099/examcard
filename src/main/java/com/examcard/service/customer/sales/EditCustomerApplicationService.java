package com.examcard.service.customer.sales;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.dto.common.UserDto;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.entity.CustomerApplication;
import com.examcard.exception.BusinessException;
import com.examcard.repository.application.CustomerApplicationRepository;
import com.examcard.service.customer.AbstractCustomerService;
import com.examcard.service.customer.CommonCustomerService;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class EditCustomerApplicationService extends AbstractCustomerService {

	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	@Autowired
	private CommonCustomerService commonCustomerService;

	@Autowired
	private MessageSource messageSource;
	
	public void update(ApplicationDto applicationDto) {
		ApplicationDto dto = commonCustomerService.getApplication(applicationDto.getId());
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
	
	public ApplicationDto getCustomerApplication(String id) {
		return commonCustomerService.getApplication(id);
	}
}
