package com.examcard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.UserCardEntity;

@Mapper
public interface UserCardMapper {
	public UserCardEntity selectByUserId(String id);
}
