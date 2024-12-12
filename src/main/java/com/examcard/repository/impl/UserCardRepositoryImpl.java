package com.examcard.repository.impl;

import org.springframework.stereotype.Repository;

import com.examcard.mapper.UserCardMapper;
import com.examcard.repository.UserCardRepository;
import com.examcard.repository.entity.UserCardEntity;

@Repository
public class UserCardRepositoryImpl implements UserCardRepository {
	private UserCardMapper userCardMapper;
	
	public UserCardEntity selectByUserId(String userId) {
		return userCardMapper.selectByUserId(userId);
	}
}
