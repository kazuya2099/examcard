package com.examcard.service;

import com.examcard.service.dto.ShinseiDto;

public interface ShinseiCreateService {

	public void insert(ShinseiDto customerApplicationDto);
	
	public void update(ShinseiDto customerApplicationDto);
}
