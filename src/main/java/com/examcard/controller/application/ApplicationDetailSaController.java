package com.examcard.controller.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.service.application.ApplicationDetailSaService;

@Controller
@RequestMapping(value = "/application/detail-sa")
public class ApplicationDetailSaController {

	@Autowired
	private ApplicationDetailSaService service;
	
	@GetMapping(value = "/index")
	public String detailCustomer(@RequestParam("id") String id, Model model) {
		ApplicationDto applicationDto = service.getApplication(id);
		model.addAttribute("applicationDto", applicationDto);
		return "application/detail-sa/index";
	}
}
