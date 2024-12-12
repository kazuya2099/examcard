package com.examcard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	/**
	 * メールアドレスで検索
	 * @param mailAddress
	 * @return
	 */
	public UserEntity selectUser(String mailAddress);
	
	/**
	 * IDで検索
	 * @param id
	 * @return
	 */
	public UserEntity selectUserById(String id);
}
