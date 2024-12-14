package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examcard.constant.ErrorCode;
import com.examcard.dto.LoginInputDto;
import com.examcard.dto.LoginOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.LoginService;

@RestController
public class LoginContoller {

	@Autowired
	private LoginService loginService;

	@GetMapping(value = {"/login"})
	public LoginOutputDto index(@RequestBody @Validated LoginInputDto inputDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new BusinessException(ErrorCode.W400000, result.getAllErrors(), this.getClass().getName());
		}
		LoginOutputDto outputDto = loginService.execute(inputDto);
		return outputDto;
	}
}
