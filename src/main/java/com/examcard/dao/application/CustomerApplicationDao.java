package com.examcard.dao.application;

import java.util.List;

public interface CustomerApplicationDao {

	public void insert(CustomerApplication customerApplication);
	public long update(CustomerApplication customerApplication);
	public long count(CustomerApplication customerApplication);
	public List<CustomerApplication> select(CustomerApplication customerApplication);
	public CustomerApplication selectById(String id);
	public CustomerApplication selectByIdForUpdate(String id);
	public long countForJudgement(CustomerApplication customerApplication);
	public List<CustomerApplication> selectForJudgement(CustomerApplication customerApplication);
}
