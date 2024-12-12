package com.examcard.service;

import com.examcard.dto.ShinseiDto;

public interface ShinseiCommonService {

	public ShinseiDto getApplication(String id);
	
	public ShinseiDto getApplicationForUpdate(String id);
}
