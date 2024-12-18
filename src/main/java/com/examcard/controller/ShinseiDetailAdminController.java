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

import com.examcard.controller.form.ShinseiSearchAdminForm;
import com.examcard.service.ShinseiDetailAdminService;
import com.examcard.service.dto.ShinseiDto;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/application/detail02")
public class ShinseiDetailAdminController {

	@Autowired
	private ShinseiDetailAdminService applicationDetail02Service;
	
	@GetMapping(value = "/index")
	public String detailCustomer(@RequestParam String id, ShinseiSearchAdminForm applicationSearch02Form, Model model) {
		ShinseiDto applicationDto = applicationDetail02Service.getApplication(id);
		applicationSearch02Form.setId(id);
		applicationSearch02Form.setApplicationStatus(applicationDto.getApplicationStatus());
		applicationSearch02Form.setApplicationComment(applicationDto.getApplicationComment());
		model.addAttribute("customerApplicationDto", applicationDto);
		model.addAttribute("applicationSearch02Form", applicationSearch02Form);
		return "application/detail02/index";
	}
	
	@PostMapping(value = "/judge")
	public String judge(@Valid ShinseiSearchAdminForm applicationSearch02Form, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "application/detail02/judge";
		}
		redirectAttributes.addFlashAttribute("applicationSearch02Form", applicationSearch02Form);
		return "redirect:/application/detail02/complete";
	}
}
