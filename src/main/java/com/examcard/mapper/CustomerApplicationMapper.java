package com.examcard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.repository.entity.ShinseiSerchParamEntity;

@Mapper
public interface CustomerApplicationMapper {
	public long insert(ShinseiEntity customerApplication);
	public long update(ShinseiEntity customerApplication);
	public long count(ShinseiEntity customerApplication);
	public List<ShinseiEntity> select(ShinseiSerchParamEntity searchParam);
	public ShinseiEntity selectById(String id);
	public ShinseiEntity selectByIdForUpdate(String id);
	public long countForJudgement(ShinseiEntity customerApplication);
	public List<ShinseiEntity> selectForJudgement(ShinseiSerchParamEntity searchParam);
}
