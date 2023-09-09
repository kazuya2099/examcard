package com.examcard.service.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.dto.common.InformationDto;
import com.examcard.entity.Information;
import com.examcard.repository.common.InformationRepository;

@Service
public class InformationService {

	@Autowired
	private InformationRepository informationRepository;

	public List<InformationDto> getInformation() {
		List<Information> informationList = informationRepository.selectByDate(new Date());
		List<InformationDto> informationDtoList = new ArrayList<>();
		for (Information information : informationList) {
			InformationDto informationDto = new InformationDto();
			BeanUtils.copyProperties(information, informationDto);
			informationDtoList.add(informationDto);
		}
		return informationDtoList;
	}
}
