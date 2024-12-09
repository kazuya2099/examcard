package com.examcard.repository.impl;

import java.util.List;

import com.examcard.repository.entity.User;

public interface UserRepositoryImpl {
	public List<User> selectUser(String mailAddress);
	public User selectUserById(String id);
}
