package com.examcard.repository;

import com.examcard.repository.entity.Sequence;

public interface SequenceRepository {
	public Sequence selectSequence(String tableName);
	public int updateSequence(Sequence sequence);
}
