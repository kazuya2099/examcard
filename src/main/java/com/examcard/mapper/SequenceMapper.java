package com.examcard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.Sequence;

@Mapper
public interface SequenceMapper {
	public Sequence selectSequence(String tableName);
	public int updateSequence(Sequence sequence);
}
