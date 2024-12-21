package com.examcard.service.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.constant.ErrorCode;
import com.examcard.dto.LoginInputDto;
import com.examcard.dto.LoginOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.repository.UserRepository;
import com.examcard.repository.entity.UserEntity;
import com.examcard.service.LoginService;

/**
 * ログインサービス 実装クラス.
 * 
 * @author Masanao Hamada
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * ログインサービス実行メソッド.
	 * 
	 * @param inputDto ログインインプットDTO
	 * @return ログインアウトプットDTO
	 */
	public LoginOutputDto execute(LoginInputDto inputDto) {
		UserEntity userEntity = userRepository.selectUser(inputDto.getMail(), inputDto.getPassword());
		if (ObjectUtils.isEmpty(userEntity)) {
			throw new BusinessException(ErrorCode.W400100, this.getClass().getName());
		}
		LoginOutputDto outputDto = new LoginOutputDto();
		BeanUtils.copyProperties(userEntity, outputDto);
		return outputDto;
	}
}
