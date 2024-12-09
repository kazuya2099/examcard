package com.examcard.service;

import com.examcard.service.dto.ShinseiSearchInputDto;
import com.examcard.service.dto.ShinseiSearchOutputDto;

public interface ShinseiSearchService {

	public ShinseiSearchOutputDto search(ShinseiSearchInputDto inputDto);
}
