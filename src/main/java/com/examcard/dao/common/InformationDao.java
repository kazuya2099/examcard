package com.examcard.dao.common;

import java.util.Date;
import java.util.List;

public interface InformationDao {

	List<Information> getInformation(Date systemDate);
}
