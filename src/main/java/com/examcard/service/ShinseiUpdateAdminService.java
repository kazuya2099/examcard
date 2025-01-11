package com.examcard.service;

import com.examcard.service.dto.ShinseiDto;

public interface ShinseiUpdateAdminService {
	
	public ShinseiDto getApplication(String id);
	
	public void update(ShinseiDto applicationDto);
}
