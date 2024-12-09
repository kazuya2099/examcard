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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examcard.component.common.CodeList;
import com.examcard.component.common.MessageHelper;
import com.examcard.controller.form.ShinseiCreateForm;
import com.examcard.exception.SystemException;
import com.examcard.service.ShinseiCreateService;
import com.examcard.service.dto.ShinseiDto;
import com.examcard.service.dto.ShinseiSearchOutputDto;

/**
 * 顧客審査申請新規作成　入力画面
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/create01")
public class ShinseiCreateController {

	@Autowired
	private CodeList codeList;

	@Autowired
	private ShinseiCreateService applicationCreate01Service;

	@Autowired
	private MessageHelper message;

	@GetMapping(value = { "/input" })
	public String input(ShinseiCreateForm form, Model model) {
		ShinseiSearchOutputDto outputDto = new ShinseiSearchOutputDto();
		outputDto.setCompanyIndustryType(codeList.getCompanyIndustryType());
		outputDto.setSetaiFamily(codeList.getSetaiFamily());
		outputDto.setSetaiStatus(codeList.getSetaiStatus());
		outputDto.setSetaiLoan(codeList.getSetaiLoan());
		outputDto.setEmploymentStatus(codeList.getEmploymentStatus());
		outputDto.setApplicationStatus(codeList.getApplicationStatus());
		model.addAttribute("form", form);
		model.addAttribute("outputDto", outputDto);
		return "application/create01/input";
	}

	@PostMapping(value = { "/input" })
	public String validateInput(@Validated ShinseiCreateForm applicationCreateSaForm,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
			return "application/create01/input";
		}
		redirectAttributes.addFlashAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "redirect:/application/create01/confirm";
	}

	@PostMapping(value = { "/input" }, params = { "back" })
	public String back(ShinseiCreateForm applicationCreateSaForm, Model model) {
		model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "application/create01/input";
	}

	@GetMapping(value = { "/confirm" })
	public String confirm(@Validated ShinseiCreateForm applicationCreateSaForm, BindingResult result,
			Model model) {
		ShinseiDto applicationDto = new ShinseiDto();
		BeanUtils.copyProperties(applicationCreateSaForm, applicationDto);
		model.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		model.addAttribute("customerApplicationDto", applicationDto);
		return "application/create01/confirm";
	}

	@PostMapping(value = { "/confirm" })
	public String insert(@Validated ShinseiCreateForm applicationCreateSaForm,
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			throw new SystemException("400", message.getMessage("system.error.bad.request"));
		}
		ShinseiDto applicationDto = new ShinseiDto();
		BeanUtils.copyProperties(applicationCreateSaForm, applicationDto);
		applicationCreate01Service.insert(applicationDto);
		redirectAttributes.addAttribute("applicationCreateSaForm", applicationCreateSaForm);
		return "redirect:/application/create01/complete";
	}

	@PostMapping(value = "/complete")
	public String complete(Model model) {
		return "application/create01/complete";
	}
}
