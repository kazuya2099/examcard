package com.examcard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.User;

@Mapper
public interface UserMapper {
	public List<User> selectUser(String mailAddress);
	public User selectUserById(String id);
}
