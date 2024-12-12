package com.examcard.service;

import com.examcard.dto.ShinseiSearchInputDto;
import com.examcard.dto.ShinseiSearchOutputDto;

public interface ShinseiSearchService {

	public ShinseiSearchOutputDto search(ShinseiSearchInputDto inputDto);
}
