package com.examcard.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.examcard.form.login.LoginForm;

@Controller
@SessionAttributes("userDto")
public class LoginContoller {

	@GetMapping(value = {"/login"})
	public String index(Model model, LoginForm loginForm) {
		model.addAttribute(loginForm);
		return "login/index";
	}

	@PostMapping({"/login/error"})
	public String error(Model model, LoginForm loginForm) {
		model.addAttribute(loginForm);
		return "login/error";
	}
}
