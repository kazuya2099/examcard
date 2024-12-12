package com.examcard.repository;

import com.examcard.repository.entity.SequenceEntity;

public interface SequenceRepository {
	public SequenceEntity selectSequence(String tableName);
	public int updateSequence(SequenceEntity sequence);
}
