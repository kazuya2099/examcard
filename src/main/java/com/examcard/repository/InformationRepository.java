package com.examcard.repository;

import java.util.Date;
import java.util.List;

import com.examcard.repository.entity.InformationEntity;

public interface InformationRepository {
	List<InformationEntity> selectByDate(Date systemDate);
}
