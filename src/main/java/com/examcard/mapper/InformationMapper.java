package com.examcard.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.Information;

@Mapper
public interface InformationMapper {
	List<Information> selectByDate(Date systemDate);
}
