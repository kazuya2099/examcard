package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examcard.constant.ErrorCode;
import com.examcard.dto.ShinseiSearchAdminInputDto;
import com.examcard.dto.ShinseiSearchAdminOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.ShinseiSearchAdminService;

import jakarta.validation.Valid;

/**
 * 顧客審査判定
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/shinsei/search")
public class ShinseiSearchAdminController {

	@Autowired
	private ShinseiSearchAdminService shinseiSearchAdminService;
	
	@GetMapping(value = "/search")
	public ShinseiSearchAdminOutputDto search(@Valid ShinseiSearchAdminInputDto inputDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new BusinessException(ErrorCode.W400001.getCode());
		}
		ShinseiSearchAdminOutputDto outputDto = shinseiSearchAdminService.search(inputDto);
		return outputDto;
	}
}
