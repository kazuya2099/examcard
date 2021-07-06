package com.examcard.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.examcard.form.login.LoginForm;

@Controller
@SessionAttributes("userDto")
public class LoginContoller {

	@RequestMapping(value = {"", "/", "login", "/login"})
	public String index(Model model, LoginForm loginForm) {
		model.addAttribute(loginForm);
		return "login/index";
	}

	@RequestMapping(value = {"/login/error"})
	public String error(Model model, LoginForm loginForm) {
		model.addAttribute(loginForm);
		return "login/error";
	}
}
