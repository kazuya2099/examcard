package com.examcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.component.common.CodeList;
import com.examcard.dto.TopOutputDto;
import com.examcard.service.TopService;

@Service
public class TopServiceImpl implements TopService {

	@Autowired
	public CodeList codeList;
	
	public TopOutputDto getTopData() {
		TopOutputDto topOutputDto = new TopOutputDto();
		return topOutputDto;
	}
}
