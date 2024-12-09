package com.examcard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.UserCard;

@Mapper
public interface UserCardMapper {
	public UserCard selectByUserId(String id);
}
