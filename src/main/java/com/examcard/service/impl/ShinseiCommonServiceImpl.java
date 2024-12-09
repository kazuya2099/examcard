package com.examcard.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.repository.CustomerApplicationRepository;
import com.examcard.repository.entity.CustomerApplication;
import com.examcard.service.ShinseiCommonService;
import com.examcard.service.dto.ShinseiDto;

@Service
@Transactional
public class ShinseiCommonServiceImpl implements ShinseiCommonService {

	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	public ShinseiDto getApplication(String id) {
		CustomerApplication customerApplication = customerApplicationRepository.selectById(id);
		ShinseiDto customerApplicationDto = new ShinseiDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		return customerApplicationDto;
	}
	
	public ShinseiDto getApplicationForUpdate(String id) {
		CustomerApplication customerApplication = customerApplicationRepository.selectByIdForUpdate(id);
		ShinseiDto customerApplicationDto = new ShinseiDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		return customerApplicationDto;
	}
}
