package com.examcard.service;

import com.examcard.dto.ShinseiCreateInputDto;
import com.examcard.dto.ShinseiCreateOutputDto;

public interface ShinseiCreateService {

	public ShinseiCreateOutputDto execute(ShinseiCreateInputDto inputDto);
}
