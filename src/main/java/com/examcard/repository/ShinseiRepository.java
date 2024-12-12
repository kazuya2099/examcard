package com.examcard.repository;

import java.util.List;

import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.repository.entity.ShinseiSerchParamEntity;

public interface ShinseiRepository {
	public long insert(ShinseiEntity customerApplication);
	public long update(ShinseiEntity customerApplication);
	public long count(ShinseiEntity customerApplication);
	public List<ShinseiEntity> select(ShinseiSerchParamEntity searchParam);
	public ShinseiEntity selectById(String id);
	public ShinseiEntity selectByIdForUpdate(String id);
	public long countForJudgement(ShinseiEntity customerApplication);
	public List<ShinseiEntity> selectForJudgement(ShinseiSerchParamEntity searchParam);
}
