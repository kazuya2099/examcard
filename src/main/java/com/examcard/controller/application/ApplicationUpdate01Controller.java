package com.examcard.controller.application;

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

import com.examcard.component.common.CodeList;
import com.examcard.component.common.MessageHelper;
import com.examcard.constant.ApplicationStatus;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.BusinessException;
import com.examcard.form.application.ApplicationUpdate01Form;
import com.examcard.service.application.ApplicationUpdate01Service;

/**
 * 顧客審査変更申請
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/update01")
public class ApplicationUpdate01Controller {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private ApplicationUpdate01Service applicationUpdate01Service;
	
	@Autowired
	private MessageHelper messageHelper;

	@GetMapping(value = "/input")
	public String input(@RequestParam("id") String id, ApplicationUpdate01Form applicationUpdate01Form, Model model) {
		ApplicationDto applicationDto = applicationUpdate01Service.getApplication(id);
		BeanUtils.copyProperties(applicationDto, applicationUpdate01Form);
		model.addAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "/application/update01/input";
	}

	@PostMapping(value = "/input")
	public String validateInput(@Validated ApplicationUpdate01Form applicationUpdate01Form, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "application/update01/input";
		}
		redirectAttributes.addFlashAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "redirect:/application/update01/confirm";
	}
	
	@PostMapping(value = "/input", params = {"back"})
	public String back(ApplicationUpdate01Form applicationUpdate01Form, Model model) {
		model.addAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "application/update01/input";
	}

	@GetMapping(value = "/confirm")
	public String confirm(@Validated ApplicationUpdate01Form applicationUpdate01Form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			throw new BusinessException(messageHelper.getMessage("error.bad.request"));
		}
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationUpdate01Form, applicationDto);
		codeList.setCodeName(applicationDto);
		
		model.addAttribute("applicationDto", applicationDto);
		model.addAttribute("applicationUpdate01Form", applicationUpdate01Form);
		return "application/update01/confirm";
	}
	
	@PostMapping(value = "/confirm")
	public String update(@Validated ApplicationUpdate01Form applicationUpdate01Form, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new BusinessException(messageHelper.getMessage("error.bad.request"));
		}
		ApplicationDto applicationDto = new ApplicationDto();
		applicationDto.setApplicationStatus(ApplicationStatus.APPLICATION.getCode());
		BeanUtils.copyProperties(applicationUpdate01Form, applicationDto);
		applicationUpdate01Service.update(applicationDto);
		return "redirect:/application/update01/complete";
	}
	
	@GetMapping(value = "/complete")
	public String complete() {
		return "application/update01/complete";
	}
}
