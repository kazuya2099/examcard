package com.examcard.repository.impl;

import org.springframework.stereotype.Repository;

import com.examcard.mapper.UserMapper;
import com.examcard.repository.UserRepository;
import com.examcard.repository.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private UserMapper userMapper;

	public UserRepositoryImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserEntity selectUser(String mail, String password) {
		return userMapper.selectUser(mail, password);
	}

	public UserEntity selectUserById(String id) {
		return userMapper.selectUserById(id);
	}
}
