package com.examcard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.CustomerApplication;
import com.examcard.repository.entity.CustomerApplicationSearchParam;

@Mapper
public interface CustomerApplicationMapper {
	public void insert(CustomerApplication customerApplication);
	public long update(CustomerApplication customerApplication);
	public long count(CustomerApplication customerApplication);
	public List<CustomerApplication> select(CustomerApplicationSearchParam searchParam);
	public CustomerApplication selectById(String id);
	public CustomerApplication selectByIdForUpdate(String id);
	public long countForJudgement(CustomerApplication customerApplication);
	public List<CustomerApplication> selectForJudgement(CustomerApplicationSearchParam searchParam);
}
