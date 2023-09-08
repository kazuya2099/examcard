package com.examcard.repository.common;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SequenceRepository {
	public Sequence selectSequence(String tableName);
	public int updateSequence(Sequence sequence);
}
