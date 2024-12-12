package com.examcard.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examcard.mapper.CustomerApplicationMapper;
import com.examcard.repository.ShinseiRepository;
import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.repository.entity.ShinseiSerchParamEntity;

@Repository
public class ShinseiRepositoryImpl implements ShinseiRepository {
	
	@Autowired
	private CustomerApplicationMapper customerApplicationMapper;
	
	public long insert(ShinseiEntity shinseiEntity) {
		return customerApplicationMapper.insert(shinseiEntity);
	}
	
	public long update(ShinseiEntity shinseiEntity) {
		return customerApplicationMapper.update(shinseiEntity);
	}
	
	public long count(ShinseiEntity shinseiEntity) {
		return customerApplicationMapper.count(shinseiEntity);
	}
	
	public List<ShinseiEntity> select(ShinseiSerchParamEntity searchParam) {
		return customerApplicationMapper.select(searchParam);
	}
	
	public ShinseiEntity selectById(String id) {
		return customerApplicationMapper.selectById(id);
	}
	
	public ShinseiEntity selectByIdForUpdate(String id) {
		return customerApplicationMapper.selectByIdForUpdate(id);
	}
	
	public long countForJudgement(ShinseiEntity shinseiEntity) {
		return customerApplicationMapper.countForJudgement(shinseiEntity);
	}
	
	public List<ShinseiEntity> selectForJudgement(ShinseiSerchParamEntity searchParam) {
		return customerApplicationMapper.selectForJudgement(searchParam);
	}
}
