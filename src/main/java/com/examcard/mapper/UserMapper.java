package com.examcard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.examcard.repository.entity.UserEntity;

/**
 * ユーザーマスタマッパークラス
 */
@Mapper
public interface UserMapper {

	/**
	 * メールアドレスで検索
	 * 
	 * @param mailAddress
	 * @return
	 */
	public UserEntity selectUser(@Param("mail") String mail, @Param("password") String password);

	/**
	 * IDで検索
	 * 
	 * @param id
	 * @return
	 */
	public UserEntity selectUserById(@Param("id") String id);
}
