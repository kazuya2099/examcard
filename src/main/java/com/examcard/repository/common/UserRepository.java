package com.examcard.repository.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.entity.User;

@Mapper
public interface UserRepository {
	public List<User> selectUser(String mailAddress);
	public User selectUserById(String id);
}
