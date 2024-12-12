package com.examcard.service;

import com.examcard.dto.LoginInputDto;
import com.examcard.dto.LoginOutputDto;

public interface LoginService {

	public LoginOutputDto execute(LoginInputDto inputDto);
}
