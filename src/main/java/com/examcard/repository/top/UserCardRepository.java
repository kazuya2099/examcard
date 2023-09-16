package com.examcard.repository.top;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.entity.UserCard;

@Mapper
public interface UserCardRepository {
	UserCard selectByUserId(String userId);
}
