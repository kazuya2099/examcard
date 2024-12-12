package com.examcard.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examcard.component.common.CodeList;
import com.examcard.constant.ErrorCode;
import com.examcard.dto.ShinseiDto;
import com.examcard.dto.ShinseiUpdateAdminDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.ShinseiUpdateAdminService;

import jakarta.validation.Valid;

/**
 * 顧客審査変更申請
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/update02")
public class ShinseiUpdateAdminController {

	@Autowired
	private CodeList codeList;

	@Autowired
	private ShinseiUpdateAdminService shinseiUpdateAdminService;

	@GetMapping(value = "/input")
	public String input(@RequestParam String id, ShinseiUpdateAdminDto inputDto, Model model) {
		ShinseiDto applicationDto = shinseiUpdateAdminService.getApplication(id);
		inputDto.setId(id);
		inputDto.setApplicationStatus(applicationDto.getApplicationStatus());
		inputDto.setApplicationComment(applicationDto.getApplicationComment());
		BeanUtils.copyProperties(applicationDto, inputDto);
		model.addAttribute("customerApplicationDto", applicationDto);
		model.addAttribute("applicationUpdate02Form", inputDto);
		model.addAttribute("applicationStatus", codeList.getApplicationStatus());
		return "application/update02/input";
	}

	@PostMapping(value = "/input")
	public String update(@Valid ShinseiUpdateAdminDto inputDto, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new BusinessException(ErrorCode.W400001.getCode());
		}
		ShinseiDto updateDto = new ShinseiDto();
		BeanUtils.copyProperties(inputDto, updateDto);
		shinseiUpdateAdminService.update(updateDto);
		return "redirect:/application/update02/complete";
	}
}
