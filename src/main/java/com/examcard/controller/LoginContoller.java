package com.examcard.controller;

import com.examcard.constant.ErrorCode;
import com.examcard.controller.dto.LoginContollerInputDto;
import com.examcard.controller.dto.LoginContollerOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.LoginService;
import com.examcard.service.dto.LoginInputDto;
import com.examcard.service.dto.LoginOutputDto;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ログインコントローラー.
 *
 * @author Masanao Hamada
 */
@RestController
public class LoginContoller {

  private LoginService loginService;

  LoginContoller(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping(value = {"/login"})
  public LoginContollerOutputDto index(
      @RequestBody @Validated LoginContollerInputDto loginContollerInputDto, BindingResult result) {
    if (result.hasErrors()) {
      throw new BusinessException(
          ErrorCode.W400000, result.getAllErrors(), this.getClass().getName());
    }
    LoginInputDto loginInputDto = getInputDto(loginContollerInputDto);
    LoginOutputDto loginOutputDto = loginService.execute(loginInputDto);
    return getControllerOutputDto(loginOutputDto);
  }

  /**
   * コントローラーのDTOとサービスのDTOの値の詰め替えを実施.
   *
   * @param loginContollerInputDto
   * @return
   */
  private LoginInputDto getInputDto(LoginContollerInputDto loginContollerInputDto) {
    LoginInputDto loginInputDto = new LoginInputDto();
    BeanUtils.copyProperties(loginContollerInputDto, loginInputDto);
    return loginInputDto;
  }

  /**
   * サービスのOutputDtoをコントローラーのDTOに詰め替えを実施.
   *
   * @param loginOutputDto
   * @return
   */
  private LoginContollerOutputDto getControllerOutputDto(LoginOutputDto loginOutputDto) {
    LoginContollerOutputDto loginContollerOutputDto = new LoginContollerOutputDto();
    BeanUtils.copyProperties(loginOutputDto, loginContollerOutputDto);
    return loginContollerOutputDto;
  }
}
