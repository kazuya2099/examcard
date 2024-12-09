package com.examcard.service;

import com.examcard.service.dto.SearchDto;
import com.examcard.service.dto.SearchResultDto;

public interface SearchCustomerApplicationService {

	public SearchResultDto search(SearchDto searchDto);
}
