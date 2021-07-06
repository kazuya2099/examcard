package com.examcard.dao.common;

public interface SequenceDao {

	public Sequence selectSequence(String tableName);
	public int updateSequence(Sequence sequence);
}
