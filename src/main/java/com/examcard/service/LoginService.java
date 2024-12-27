package com.examcard.service;

import com.examcard.service.dto.LoginInputDto;
import com.examcard.service.dto.LoginOutputDto;

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
