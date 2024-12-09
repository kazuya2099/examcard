package com.examcard.service;

import com.examcard.service.dto.ShinseiDto;

public interface EditCustomerApplicationService {

	public void update(ShinseiDto applicationDto);
	
	public ShinseiDto getCustomerApplication(String id);
}
