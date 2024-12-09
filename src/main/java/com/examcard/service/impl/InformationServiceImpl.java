package com.examcard.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.repository.InformationRepository;
import com.examcard.repository.entity.Information;
import com.examcard.service.InformationService;
import com.examcard.service.dto.InformationDto;

@Service
public class InformationServiceImpl implements InformationService {

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
