package com.examcard.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examcard.mapper.SequenceMapper;
import com.examcard.repository.SequenceRepository;
import com.examcard.repository.entity.Sequence;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository {
	
	@Autowired
	private SequenceMapper sequenceMapper;
	
	public Sequence selectSequence(String tableName) {
		return sequenceMapper.selectSequence(tableName);
	}
	
	public int updateSequence(Sequence sequence) {
		return sequenceMapper.updateSequence(sequence);
	}
}
