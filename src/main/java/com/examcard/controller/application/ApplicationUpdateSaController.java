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

import com.examcard.component.common.MessageResolver;
import com.examcard.constant.ApplicationStatus;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.BusinessException;
import com.examcard.form.application.ApplicationUpdateSaForm;
import com.examcard.service.application.AbstractApplicationService;
import com.examcard.service.application.ApplicationUpdateSaService;

/**
 * 顧客審査変更申請
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/update-sa")
public class ApplicationUpdateSaController extends AbstractApplicationService {

	@Autowired
	private ApplicationUpdateSaService service;
	
	@Autowired
	private MessageResolver messageResolver;

	@GetMapping(value = "/input")
	public String input(@RequestParam("id") String id, ApplicationUpdateSaForm applicationUpdateSaForm, Model model) {
		ApplicationDto applicationDto = service.getApplication(id);
		BeanUtils.copyProperties(applicationDto, applicationUpdateSaForm);
		model.addAttribute("applicationUpdateSaForm", applicationUpdateSaForm);
		return "/application/update-sa/input";
	}

	@PostMapping(value = "/input")
	public String validateInput(@Validated ApplicationUpdateSaForm applicationUpdateSaForm, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "application/update-sa/input";
		}
		redirectAttributes.addFlashAttribute("applicationUpdateSaForm", applicationUpdateSaForm);
		return "redirect:/application/update-sa/confirm";
	}
	
	@PostMapping(value = "/input", params = {"back"})
	public String back(ApplicationUpdateSaForm applicationUpdateSaForm, Model model) {
		model.addAttribute("applicationUpdateSaForm", applicationUpdateSaForm);
		return "application/update-sa/input";
	}

	@GetMapping(value = "/confirm")
	public String confirm(@Validated ApplicationUpdateSaForm applicationUpdateSaForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			throw new BusinessException(messageResolver.getMessage("error.bad.request"));
		}
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationUpdateSaForm, applicationDto);
		service.setCodeName(applicationDto);
		
		model.addAttribute("applicationDto", applicationDto);
		model.addAttribute("applicationUpdateSaForm", applicationUpdateSaForm);
		return "application/update-sa/confirm";
	}
	
	@PostMapping(value = "/confirm")
	public String update(@Validated ApplicationUpdateSaForm applicationUpdateSaForm, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new BusinessException(messageResolver.getMessage("error.bad.request"));
		}
		ApplicationDto applicationDto = new ApplicationDto();
		applicationDto.setApplicationStatus(ApplicationStatus.APPLICATION.getCode());
		BeanUtils.copyProperties(applicationUpdateSaForm, applicationDto);
		service.update(applicationDto);
		return "redirect:/application/update-sa/complete";
	}
	
	@GetMapping(value = "/complete")
	public String complete() {
		return "application/update-sa/complete";
	}
}
