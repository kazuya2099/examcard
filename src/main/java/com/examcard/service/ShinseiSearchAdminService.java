package com.examcard.service;

import com.examcard.dto.ShinseiSearchAdminInputDto;
import com.examcard.dto.ShinseiSearchAdminOutputDto;

public interface ShinseiSearchAdminService {

	public ShinseiSearchAdminOutputDto search(ShinseiSearchAdminInputDto inputDto);
}
