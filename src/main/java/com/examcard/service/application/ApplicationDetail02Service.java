package com.examcard.service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.service.common.ApplicationCommonService;

@Service
@Transactional
public class ApplicationDetail02Service {
	
	@Autowired
	ApplicationCommonService applicationCommonService;
	
	public ApplicationDto getApplication(String id) {
		return applicationCommonService.getApplication(id);
	}
}
