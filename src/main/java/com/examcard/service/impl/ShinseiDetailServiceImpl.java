package com.examcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.service.ShinseiDetailService;
import com.examcard.service.dto.ShinseiDto;

@Service
@Transactional
public class ShinseiDetailServiceImpl implements ShinseiDetailService {

	@Autowired
	ShinseiCommonServiceImpl applicationCommonService;
	
	public ShinseiDto getApplication(String id) {
		return applicationCommonService.getApplication(id);
	}
}
