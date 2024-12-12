package com.examcard.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.dto.LoginInputDto;
import com.examcard.dto.LoginOutputDto;
import com.examcard.repository.UserRepository;
import com.examcard.repository.entity.UserEntity;
import com.examcard.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * ログイン処理を実行
	 */
	public LoginOutputDto execute(LoginInputDto inputDto) {
		UserEntity user = userRepository.selectUser(inputDto.getMailAddress());
		LoginOutputDto outputDto = new LoginOutputDto();
		BeanUtils.copyProperties(user, outputDto);
		return outputDto;
	}
}
