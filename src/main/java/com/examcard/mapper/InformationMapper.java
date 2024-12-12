package com.examcard.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.InformationEntity;

@Mapper
public interface InformationMapper {
	List<InformationEntity> selectByDate(Date systemDate);
}
