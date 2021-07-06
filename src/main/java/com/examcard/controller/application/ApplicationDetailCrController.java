package com.examcard.controller.application;

import javax.validation.Valid;

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
import com.examcard.form.application.ApplicationSearchCrForm;
import com.examcard.service.application.ApplicationDetailCrService;

@Controller
@RequestMapping(value = "/application/detail-cr")
public class ApplicationDetailCrController {

	@Autowired
	private ApplicationDetailCrService service;
	
	@GetMapping(value = "/index")
	public String detailCustomer(@RequestParam String id, ApplicationSearchCrForm applicationSearchCrForm, Model model) {
		ApplicationDto applicationDto = service.getApplication(id);
		applicationSearchCrForm.setId(id);
		applicationSearchCrForm.setApplicationStatus(applicationDto.getApplicationStatus());
		applicationSearchCrForm.setApplicationComment(applicationDto.getApplicationComment());
		model.addAttribute("customerApplicationDto", applicationDto);
		model.addAttribute("applicationSearchCrForm", applicationSearchCrForm);
		return "application/detail-cr/index";
	}
	
	@PostMapping(value = "/judge")
	public String judge(@Valid ApplicationSearchCrForm applicationSearchCrForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "application/detail-cr/judge";
		}
		redirectAttributes.addFlashAttribute("applicationSearchCrForm", applicationSearchCrForm);
		return "redirect:/application/detail-cr/complete";
	}
}
