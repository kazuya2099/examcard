package com.examcard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.SequenceEntity;

@Mapper
public interface SequenceMapper {
	public SequenceEntity selectSequence(String tableName);
	public int updateSequence(SequenceEntity sequence);
}
