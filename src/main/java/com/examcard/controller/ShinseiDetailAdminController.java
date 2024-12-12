package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examcard.constant.ErrorCode;
import com.examcard.dto.ShinseiDto;
import com.examcard.dto.ShinseiSearchAdminInputDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.ShinseiDetailAdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/shinsei/detail")
public class ShinseiDetailAdminController {

	@Autowired
	private ShinseiDetailAdminService applicationDetail02Service;
	
	@GetMapping(value = "/index")
	public String detailCustomer(@RequestParam String id, ShinseiSearchAdminInputDto inputDto, Model model) {
		ShinseiDto applicationDto = applicationDetail02Service.getApplication(id);
		inputDto.setId(id);
		inputDto.setApplicationStatus(applicationDto.getApplicationStatus());
		inputDto.setApplicationComment(applicationDto.getApplicationComment());
		model.addAttribute("customerApplicationDto", applicationDto);
		model.addAttribute("applicationSearch02Form", inputDto);
		return "application/detail02/index";
	}
	
	@PostMapping(value = "/judge")
	public String judge(@Valid ShinseiSearchAdminInputDto inputDto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new BusinessException(ErrorCode.W400001.getCode());
		}
		redirectAttributes.addFlashAttribute("applicationSearch02Form", inputDto);
		return "redirect:/application/detail02/complete";
	}
}
