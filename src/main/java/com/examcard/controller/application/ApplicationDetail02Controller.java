package com.examcard.controller.application;

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
import com.examcard.form.application.ApplicationSearch02Form;
import com.examcard.service.application.ApplicationDetail02Service;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/application/detail02")
public class ApplicationDetail02Controller {

	@Autowired
	private ApplicationDetail02Service applicationDetail02Service;
	
	@GetMapping(value = "/index")
	public String detailCustomer(@RequestParam String id, ApplicationSearch02Form applicationSearch02Form, Model model) {
		ApplicationDto applicationDto = applicationDetail02Service.getApplication(id);
		applicationSearch02Form.setId(id);
		applicationSearch02Form.setApplicationStatus(applicationDto.getApplicationStatus());
		applicationSearch02Form.setApplicationComment(applicationDto.getApplicationComment());
		model.addAttribute("customerApplicationDto", applicationDto);
		model.addAttribute("applicationSearch02Form", applicationSearch02Form);
		return "application/detail02/index";
	}
	
	@PostMapping(value = "/judge")
	public String judge(@Valid ApplicationSearch02Form applicationSearch02Form, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "application/detail02/judge";
		}
		redirectAttributes.addFlashAttribute("applicationSearch02Form", applicationSearch02Form);
		return "redirect:/application/detail02/complete";
	}
}
