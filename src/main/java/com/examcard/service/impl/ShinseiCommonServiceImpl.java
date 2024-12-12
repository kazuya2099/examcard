package com.examcard.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.dto.ShinseiDto;
import com.examcard.repository.ShinseiRepository;
import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.service.ShinseiCommonService;

@Service
@Transactional
public class ShinseiCommonServiceImpl implements ShinseiCommonService {

	@Autowired
	private ShinseiRepository customerApplicationRepository;
	
	public ShinseiDto getApplication(String id) {
		ShinseiEntity customerApplication = customerApplicationRepository.selectById(id);
		ShinseiDto customerApplicationDto = new ShinseiDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		return customerApplicationDto;
	}
	
	public ShinseiDto getApplicationForUpdate(String id) {
		ShinseiEntity customerApplication = customerApplicationRepository.selectByIdForUpdate(id);
		ShinseiDto customerApplicationDto = new ShinseiDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		return customerApplicationDto;
	}
}
