package com.examcard.controller.logout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/logout")
@Controller
public class LogoutController {

	@GetMapping(value = {"/complete"})
	public String index(Model model) {
		return "logout/index";
	}
}
