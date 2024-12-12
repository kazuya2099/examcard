package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examcard.component.common.MessageHelper;
import com.examcard.constant.ErrorCode;
import com.examcard.dto.ShinseiCreateInputDto;
import com.examcard.dto.ShinseiCreateOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.ShinseiCreateService;

/**
 * 顧客審査申請新規作成　入力画面
 *
 * @author mhama
 */
@RestController
@RequestMapping(value = "/shinsei/create")
public class ShinseiCreateController {

	@Autowired
	private ShinseiCreateService shinseiCreateService;

	@Autowired
	private MessageHelper message;

	@PostMapping(value = { "/id" })
	public ShinseiCreateOutputDto updateShinsei(@Validated ShinseiCreateInputDto inputDto,
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new BusinessException(ErrorCode.W400001.getCode());
		}
		ShinseiCreateOutputDto outputDto = shinseiCreateService.execute(inputDto);
		return outputDto;
	}
}
