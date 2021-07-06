package com.examcard.service.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.dao.common.Information;
import com.examcard.dao.common.InformationDao;
import com.examcard.dto.common.InformationDto;

@Service
public class InformationService {

	@Autowired
	private InformationDao informationDao;

	public List<InformationDto> getInformation() {
		List<Information> informations = informationDao.getInformation(new Date());
		List<InformationDto> informationDtos = new ArrayList<>();
		for (Information information : informations) {
			InformationDto informationDto = new InformationDto();
			BeanUtils.copyProperties(information, informationDto);
			informationDtos.add(informationDto);
		}
		return informationDtos;
	}
}
