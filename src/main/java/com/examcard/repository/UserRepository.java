package com.examcard.repository;

import java.util.List;

import com.examcard.repository.entity.User;

public interface UserRepository {
	public List<User> selectUser(String mailAddress);
	public User selectUserById(String id);
}
