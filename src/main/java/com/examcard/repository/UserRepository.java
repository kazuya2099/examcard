package com.examcard.repository;

import com.examcard.repository.entity.UserEntity;

/**
 * ユーザーマスタ検索インターフェース
 */
public interface UserRepository {
	
	/**
	 * メールアドレスで検索
	 * 
	 * @param mailAddress
	 * @return
	 */
	public UserEntity selectUser(String mail, String password);
	
	/**
	 * IDで検索
	 * 
	 * @param id
	 * @return
	 */
	public UserEntity selectUserById(String id);
}
