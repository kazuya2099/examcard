package com.examcard.service;

import com.examcard.service.dto.ShinseiDto;

public interface RegistCustomerApplicationService {

	public void insert(ShinseiDto applicationDto);
	
	public ShinseiDto getApplication(String id);
}
