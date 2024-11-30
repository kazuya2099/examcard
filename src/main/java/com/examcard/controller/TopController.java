package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examcard.component.authentication.UserDetailsImpl;
import com.examcard.service.TopService;
import com.examcard.service.dto.TopDto;
import com.examcard.service.dto.UserDto;

@Controller
@RequestMapping(value = "/top")
public class TopController {

	@Autowired
	private TopService topService;
	
	@GetMapping(value = {"", "/"})
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		UserDto userDto = userDetailsImpl.getUserDto();
		TopDto topDto = topService.getTopData();
		model.addAttribute("userDto", userDto);
		topDto.setFirstname(userDto.getFirstname());
		topDto.setLastname(userDto.getLastname());
		model.addAttribute("topDto", topDto);
		return "top/index";
	}
}