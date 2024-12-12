package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examcard.dto.LoginInputDto;
import com.examcard.dto.LoginOutputDto;
import com.examcard.service.LoginService;

@RestController
public class LoginContoller {

	@Autowired
	private LoginService loginService;

	@GetMapping(value = {"/login"})
	public LoginOutputDto index(LoginInputDto inputDto) {
		LoginOutputDto outputDto = loginService.execute(inputDto);
		return outputDto;
	}
}
