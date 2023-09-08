package com.examcard.repository.top;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCardRepository {
	UserCard selectByUserId(String userId);
}
