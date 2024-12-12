package com.examcard.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.examcard.mapper.UserMapper;
import com.examcard.repository.UserRepository;
import com.examcard.repository.entity.UserEntity;

public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserEntity selectUser(String mailAddress) {
		return userMapper.selectUser(mailAddress);
	}
	
	public UserEntity selectUserById(String id) {
		return userMapper.selectUserById(id);
	}
}
