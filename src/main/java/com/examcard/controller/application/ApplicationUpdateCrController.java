package com.examcard.controller.application;

import javax.validation.Valid;

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

import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.form.application.ApplicationUpdateCrForm;
import com.examcard.service.application.ApplicationUpdateCrService;

/**
 * 顧客審査変更申請
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/update-cr")
public class ApplicationUpdateCrController {

	@Autowired
	private ApplicationUpdateCrService service;
	
	@GetMapping(value = "/input")
	public String input(@RequestParam String id, ApplicationUpdateCrForm applicationUpdateCrForm, Model model) {
		ApplicationDto applicationDto = service.getApplication(id);
		applicationUpdateCrForm.setId(id);
		applicationUpdateCrForm.setApplicationStatus(applicationDto.getApplicationStatus());
		applicationUpdateCrForm.setApplicationComment(applicationDto.getApplicationComment());
		BeanUtils.copyProperties(applicationDto, applicationUpdateCrForm);
		model.addAttribute("customerApplicationDto", applicationDto);
		model.addAttribute("applicationUpdateCrForm", applicationUpdateCrForm);
		return "application/update-cr/input";
	}
	
	@PostMapping(value = "/input")
	public String update(@Valid ApplicationUpdateCrForm applicationUpdateCrForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			ApplicationDto applicationDto = service.getApplication(applicationUpdateCrForm.getId());
			model.addAttribute("applicationDto", applicationDto);
			return "application/update-cr/input";
		}
		ApplicationDto updateDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationUpdateCrForm, updateDto);
		service.update(updateDto);
		redirectAttributes.addFlashAttribute("applicationUpdateCrForm", applicationUpdateCrForm);
		return "redirect:/application/update-cr/complete";
	}
	
	@GetMapping(value = "/complete")
	public String complete() {
		return "application/update-cr/complete";
	}
}
