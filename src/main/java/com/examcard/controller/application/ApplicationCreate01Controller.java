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

import com.examcard.component.common.CodeList;
import com.examcard.component.common.MessageHelper;
import com.examcard.constant.CodeMapKey;
import com.examcard.dto.application.ApplicationSearch01OutputDto;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.SystemException;
import com.examcard.form.application.ApplicationCreate01Form;
import com.examcard.service.application.ApplicationCreate01Service;

/**
 * 顧客審査申請新規作成　入力画面
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/create01")
public class ApplicationCreate01Controller {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private ApplicationCreate01Service applicationCreate01Service;
	
	@Autowired
	private MessageHelper message;
	
	@GetMapping(value = {"/input"})
	public String input(ApplicationCreate01Form form, Model model) {
		ApplicationSearch01OutputDto outputDto = new ApplicationSearch01OutputDto();
		outputDto.setCompanyIndustryType(codeList.getCodeMap(CodeMapKey.COMPANY_INDUSTRY_TYPE));
		outputDto.setSetaiFamily(codeList.getCodeMap(CodeMapKey.SETAI_FAMILY));
		outputDto.setSetaiStatus(codeList.getCodeMap(CodeMapKey.SETAI_STATUS));
		outputDto.setSetaiLoan(codeList.getCodeMap(CodeMapKey.SETAI_LOAN));
		outputDto.setEmploymentStatus(codeList.getCodeMap(CodeMapKey.EMPLOYMENT_STATUS));
		outputDto.setApplicationStatus(codeList.getCodeMap(CodeMapKey.APPLICATION_STATUS));
		model.addAttribute("form", form);
		model.addAttribute("outputDto", outputDto);
		return "application/create01/input";
	}

	@PostMapping(value = {"/input"})
	public String validateInput(@Validated ApplicationCreate01Form applicationCreateSaForm, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
			return "application/create01/input";
		}
		redirectAttributes.addFlashAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "redirect:/application/create01/confirm";
	}
	
	@PostMapping(value = {"/input"}, params = {"back"})
	public String back(ApplicationCreate01Form applicationCreateSaForm, Model model) {
		model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "application/create01/input";
	}
	
	@GetMapping(value = {"/confirm"})
	public String confirm(@Validated ApplicationCreate01Form applicationCreateSaForm, BindingResult result, Model model) {
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationCreateSaForm, applicationDto);
		applicationCreate01Service.setCodeName(applicationDto);
		model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		model.addAttribute("customerApplicationDto", applicationDto);
		return "application/create01/confirm";
	}
	
	@PostMapping(value = {"/confirm"})
	public String insert(@Validated ApplicationCreate01Form applicationCreateSaForm, 
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new SystemException("400", message.getMessage("system.error.bad.request"));
		}
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationCreateSaForm, applicationDto);
		applicationCreate01Service.insert(applicationDto);
		redirectAttributes.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "redirect:/application/create01/complete";
	}

	@RequestMapping(value = "/complete")
	public String complete(Model model) {
		return "application/create01/complete";
	}
}
