package com.examcard.service.top;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.component.common.CodeList;
import com.examcard.dto.common.InformationDto;
import com.examcard.dto.top.TopDto;
import com.examcard.service.common.InformationService;

@Service
public class TopService {

	@Autowired
	private InformationService informationService;
	
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
