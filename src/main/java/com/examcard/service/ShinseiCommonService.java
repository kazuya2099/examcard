package com.examcard.service;

import com.examcard.service.dto.ShinseiDto;

public interface ShinseiCommonService {

	public ShinseiDto getApplication(String id);
	
	public ShinseiDto getApplicationForUpdate(String id);
}
