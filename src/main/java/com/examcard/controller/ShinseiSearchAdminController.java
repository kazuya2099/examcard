package com.examcard.controller;

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

import com.examcard.controller.form.ShinseiSearchAdminForm;
import com.examcard.service.ShinseiSearchAdminService;
import com.examcard.service.dto.ShinseiSearchAdminInputDto;
import com.examcard.service.dto.ShinseiSearchAdminOutputDto;

import jakarta.validation.Valid;

/**
 * 顧客審査判定
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/search02")
@SessionAttributes(value = "ApplicationSearch02Form", types = {ShinseiSearchAdminForm.class})
public class ShinseiSearchAdminController {

	@Autowired
	private ShinseiSearchAdminService applicationSearch02Service;
	
	@ModelAttribute(name = "applicationSearch02Form")
	public ShinseiSearchAdminForm getApplicationSearch02Form() {
		return new ShinseiSearchAdminForm();
	}
	
	@GetMapping(value = {"", "/"})
	public String init(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/application/search02/index";
	}

	@GetMapping(value = {"/index"})
	public String index(Model model) {
		model.addAttribute("applicationSearch02Form", new ShinseiSearchAdminForm());
		return "application/search02/index";
	}
	
	@GetMapping(value = "/search")
	public String search(@Valid ShinseiSearchAdminForm applicationSearch02Form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "application/search02/index";
		}
		ShinseiSearchAdminInputDto inputDto = new ShinseiSearchAdminInputDto();
		BeanUtils.copyProperties(applicationSearch02Form, inputDto);
		ShinseiSearchAdminOutputDto outputDto = applicationSearch02Service.search(inputDto);
		applicationSearch02Form.setPageCount(outputDto.getPageCount());
		applicationSearch02Form.setPageSize(outputDto.getPageSize());
		
		model.addAttribute("outputDto", outputDto);
		return "application/search02/index";
	}
}
