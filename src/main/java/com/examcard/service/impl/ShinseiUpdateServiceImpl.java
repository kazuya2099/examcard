package com.examcard.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.MessageHelper;
import com.examcard.dto.ShinseiDto;
import com.examcard.exception.BusinessException;
import com.examcard.repository.ShinseiRepository;
import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.service.ShinseiUpdateService;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class ShinseiUpdateServiceImpl implements ShinseiUpdateService {

	@Autowired
	ShinseiCommonServiceImpl applicationCommonService;
	
	@Autowired
	private ShinseiRepository customerApplicationRepository;
	
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
		ShinseiEntity customerApplication = new ShinseiEntity();
		BeanUtils.copyProperties(applicationDto, customerApplication);
		customerApplication.setUpdateDate(OperationDateUtil.getDate());
		customerApplicationRepository.update(customerApplication);
	}
}
