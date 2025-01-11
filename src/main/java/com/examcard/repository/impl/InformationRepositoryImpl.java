package com.examcard.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examcard.mapper.InformationMapper;
import com.examcard.repository.InformationRepository;
import com.examcard.repository.entity.Information;

@Repository
public class InformationRepositoryImpl implements InformationRepository {
	
	@Autowired
	private InformationMapper informationMapper;
	
	public List<Information> selectByDate(Date systemDate) {
		return informationMapper.selectByDate(systemDate);
	}
}
