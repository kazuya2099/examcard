package com.examcard.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.dto.ShinseiDto;
import com.examcard.exception.BusinessException;
import com.examcard.repository.ShinseiRepository;
import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.service.EditCustomerApplicationService;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class EditCustomerApplicationServiceImpl implements EditCustomerApplicationService {

	@Autowired
	private ShinseiRepository shinseiRepository;
	
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
		ShinseiEntity shinseiEntity = new ShinseiEntity();
		BeanUtils.copyProperties(applicationDto, shinseiEntity);
		shinseiEntity.setUpdateDate(OperationDateUtil.getDate());
		shinseiRepository.update(shinseiEntity);
	}
	
	public ShinseiDto getCustomerApplication(String id) {
		return applicationCommonService.getApplication(id);
	}
}
