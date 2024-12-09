package com.examcard.service;

import com.examcard.service.dto.ShinseiSearchAdminInputDto;
import com.examcard.service.dto.ShinseiSearchAdminOutputDto;

public interface ShinseiSearchAdminService {

	public ShinseiSearchAdminOutputDto search(ShinseiSearchAdminInputDto inputDto);
}
