package com.examcard.repository;

import com.examcard.repository.entity.UserEntity;

public interface UserRepository {
	public UserEntity selectUser(String mailAddress);
	public UserEntity selectUserById(String id);
}
