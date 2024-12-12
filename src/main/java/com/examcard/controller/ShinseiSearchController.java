package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examcard.component.common.CodeList;
import com.examcard.constant.ErrorCode;
import com.examcard.dto.ShinseiSearchInputDto;
import com.examcard.dto.ShinseiSearchOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.ShinseiSearchService;

import jakarta.validation.Valid;

/**
 * 顧客審査申請検索
 *
 * @author mhama
 */
@RestController
@RequestMapping(value = "/shinsei/search")
public class ShinseiSearchController {

	@Autowired
	private CodeList codeList;

	@Autowired
	private ShinseiSearchService shinseiSearchService;

	@GetMapping(value = "/execute")
	public ShinseiSearchOutputDto search(@Valid ShinseiSearchInputDto inputDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new BusinessException(ErrorCode.W400001.getCode());
		}
		ShinseiSearchOutputDto outputDto = shinseiSearchService.search(inputDto);
		outputDto.setApplicationStatus(codeList.getApplicationStatus());
		outputDto.setPageCount(outputDto.getPageCount());
		outputDto.setPageSize(outputDto.getPageSize());
		return outputDto;
	}
}
