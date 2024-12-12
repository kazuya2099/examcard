package com.examcard.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examcard.component.common.MessageHelper;
import com.examcard.constant.ErrorCode;
import com.examcard.constant.ShinseiStatus;
import com.examcard.dto.ShinseiDto;
import com.examcard.dto.ShinseiUpdateDto;
import com.examcard.exception.BusinessException;
import com.examcard.service.ShinseiUpdateService;

/**
 * 顧客審査変更申請
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/update01")
public class ShinseiUpdateController {

	@Autowired
	private ShinseiUpdateService applicationUpdate01Service;
	
	@Autowired
	private MessageHelper messageHelper;

	@GetMapping(value = "/input")
	public String input(@RequestParam("id") String id, ShinseiUpdateDto applicationUpdate01Form, Model model) {
		ShinseiDto applicationDto = applicationUpdate01Service.getApplication(id);
		BeanUtils.copyProperties(applicationDto, applicationUpdate01Form);
		model.addAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "/application/update01/input";
	}

	@PostMapping(value = "/input")
	public String validateInput(@Validated ShinseiUpdateDto applicationUpdate01Form, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new BusinessException(ErrorCode.W400001.getCode());
		}
		redirectAttributes.addFlashAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "redirect:/application/update01/confirm";
	}
	
	@PostMapping(value = "/input", params = {"back"})
	public String back(ShinseiUpdateDto applicationUpdate01Form, Model model) {
		model.addAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "application/update01/input";
	}

	@GetMapping(value = "/confirm")
	public String confirm(@Validated ShinseiUpdateDto applicationUpdate01Form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			throw new BusinessException(messageHelper.getMessage("error.bad.request"));
		}
		ShinseiDto applicationDto = new ShinseiDto();
		BeanUtils.copyProperties(applicationUpdate01Form, applicationDto);
		model.addAttribute("applicationDto", applicationDto);
		model.addAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "application/update01/confirm";
	}
	
	@PostMapping(value = "/confirm")
	public String update(@Validated ShinseiUpdateDto applicationUpdate01Form, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new BusinessException(messageHelper.getMessage("error.bad.request"));
		}
		ShinseiDto applicationDto = new ShinseiDto();
		applicationDto.setApplicationStatus(ShinseiStatus.APPLICATION.getCode());
		BeanUtils.copyProperties(applicationUpdate01Form, applicationDto);
		applicationUpdate01Service.update(applicationDto);
		return "redirect:/application/update01/complete";
	}
	
	@GetMapping(value = "/complete")
	public String complete() {
		return "application/update01/complete";
	}
}
