package com.examcard.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examcard.mapper.UserMapper;
import com.examcard.repository.UserRepository;
import com.examcard.repository.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserEntity selectUser(String mail, String password) {
		return userMapper.selectUser(mail, password);
	}
	
	public UserEntity selectUserById(String id) {
		return userMapper.selectUserById(id);
	}
}
