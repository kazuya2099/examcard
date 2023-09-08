package com.examcard.controller.application;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.examcard.dto.application.ApplicationSearch02InputDto;
import com.examcard.dto.application.ApplicationSearch02OutputDto;
import com.examcard.form.application.ApplicationSearch02Form;
import com.examcard.service.application.ApplicationSearch02Service;

import jakarta.validation.Valid;

/**
 * 顧客審査判定
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/search02")
@SessionAttributes(value = "ApplicationSearch02Form", types = {ApplicationSearch02Form.class})
public class ApplicationSearch02Controller {

	@Autowired
	private ApplicationSearch02Service applicationSearch02Service;
	
	@ModelAttribute(name = "applicationSearch02Form")
	public ApplicationSearch02Form getApplicationSearch02Form() {
		return new ApplicationSearch02Form();
	}
	
	@GetMapping(value = {"", "/"})
	public String init(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/application/search02/index";
	}

	@GetMapping(value = {"/index"})
	public String index(Model model) {
		model.addAttribute("applicationSearch02Form", new ApplicationSearch02Form());
		return "application/search02/index";
	}
	
	@GetMapping(value = "/search")
	public String search(@Valid ApplicationSearch02Form applicationSearch02Form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "application/search02/index";
		}
		ApplicationSearch02InputDto inputDto = new ApplicationSearch02InputDto();
		BeanUtils.copyProperties(applicationSearch02Form, inputDto);
		ApplicationSearch02OutputDto outputDto = applicationSearch02Service.search(inputDto);
		applicationSearch02Form.setPageCount(outputDto.getPageCount());
		applicationSearch02Form.setPageSize(outputDto.getPageSize());
		
		model.addAttribute("outputDto", outputDto);
		return "application/search02/index";
	}
}
