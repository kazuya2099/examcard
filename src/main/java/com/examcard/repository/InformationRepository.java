package com.examcard.repository;

import java.util.Date;
import java.util.List;

import com.examcard.repository.entity.Information;

public interface InformationRepository {
	List<Information> selectByDate(Date systemDate);
}
