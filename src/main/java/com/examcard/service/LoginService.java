package com.examcard.service;

import com.examcard.dto.LoginInputDto;
import com.examcard.dto.LoginOutputDto;

/**
 * ログインサービス インターフェース.
 * 
 * @author Masanao Hamada
 */
public interface LoginService {

	/**
	 * ログインサービス実行メソッド.
	 * 
	 * @param inputDto ログインインプットDTO
	 * @return ログインアウトプットDTO
	 */
	public LoginOutputDto execute(LoginInputDto inputDto);
}
