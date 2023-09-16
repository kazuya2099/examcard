package com.examcard.repository.common;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.entity.Information;

@Mapper
public interface InformationRepository {
	List<Information> selectByDate(Date systemDate);
}
