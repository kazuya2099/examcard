package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examcard.dto.ShinseiDto;
import com.examcard.service.ShinseiDetailService;

@Controller
@RequestMapping(value = "/application/detail01")
public class ShinseiDetailController {

	@Autowired
	private ShinseiDetailService applicationDetail01Service;
	
	@GetMapping(value = "/index")
	public String detailCustomer(@RequestParam("id") String id, Model model) {
		ShinseiDto applicationDto = applicationDetail01Service.getApplication(id);
		model.addAttribute("applicationDto", applicationDto);
		return "application/detail01/index";
	}
}
