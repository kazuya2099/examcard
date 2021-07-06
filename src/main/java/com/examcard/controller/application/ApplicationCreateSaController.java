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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examcard.component.common.MessageResolver;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.SystemException;
import com.examcard.form.application.ApplicationCreateSaForm;
import com.examcard.service.application.ApplicationCreateSaService;

/**
 * 顧客審査申請新規作成　入力画面
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/create-sa")
public class ApplicationCreateSaController {

	@Autowired
	private ApplicationCreateSaService service;
	
	@Autowired
	private MessageResolver messageResolver;
	
	@GetMapping(value = {"/input"})
	public String input(ApplicationCreateSaForm form, Model model) {
		model.addAttribute("form", form);
		return "application/create-sa/input";
	}

	@PostMapping(value = {"/input"})
	public String validateInput(@Validated ApplicationCreateSaForm applicationCreateSaForm, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
			return "application/create-sa/input";
		}
		redirectAttributes.addFlashAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "redirect:/application/create-sa/confirm";
	}
	
	@PostMapping(value = {"/input"}, params = {"back"})
	public String back(ApplicationCreateSaForm applicationCreateSaForm, Model model) {
		model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "application/create-sa/input";
	}
	
	@GetMapping(value = {"/confirm"})
	public String confirm(@Validated ApplicationCreateSaForm applicationCreateSaForm, BindingResult result, Model model) {
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationCreateSaForm, applicationDto);
		service.setCodeName(applicationDto);
		model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		model.addAttribute("customerApplicationDto", applicationDto);
		return "application/create-sa/confirm";
	}
	
	@PostMapping(value = {"/confirm"})
	public String insert(@Validated ApplicationCreateSaForm applicationCreateSaForm, 
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new SystemException("400", messageResolver.getMessage("system.error.bad.request"));
		}
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationCreateSaForm, applicationDto);
		service.insert(applicationDto);
		redirectAttributes.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "redirect:/application/create-sa/complete";
	}

	@RequestMapping(value = "/complete")
	public String complete(Model model) {
		return "application/create-sa/complete";
	}
}
