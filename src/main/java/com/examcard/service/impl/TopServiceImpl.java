package com.examcard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.component.common.CodeList;
import com.examcard.service.TopService;
import com.examcard.service.dto.InformationDto;
import com.examcard.service.dto.TopDto;

@Service
public class TopServiceImpl implements TopService {

	@Autowired
	private InformationServiceImpl informationService;
	
	@Autowired
	public CodeList codeList;
	
	public TopDto getTopData() {
		TopDto topDto = new TopDto();
		List<InformationDto> informationDtoList = informationService.getInformation();
		if (informationDtoList.size() > 0) {
			String topInformation = informationDtoList.get(0).getMessage();
			topInformation = topInformation.replace("\r\n", "<br>");
			topDto.setInformation(topInformation);
		}
		return topDto;
	}
}
