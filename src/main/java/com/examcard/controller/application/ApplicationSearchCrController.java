package com.examcard.controller.application;

import javax.validation.Valid;

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

import com.examcard.dto.application.ApplicationSearchCrInputDto;
import com.examcard.dto.application.ApplicationSearchCrOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.form.application.ApplicationSearchCrForm;
import com.examcard.service.application.ApplicationSearchCrService;

/**
 * 顧客審査判定
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/search-cr")
@SessionAttributes(value = "applicationSearchCrForm", types = {ApplicationSearchCrForm.class})
public class ApplicationSearchCrController {

	@Autowired
	private ApplicationSearchCrService service;
	
	@ModelAttribute(name = "applicationSearchCrForm")
	public ApplicationSearchCrForm getApplicationSearchCrForm() {
		return new ApplicationSearchCrForm();
	}
	
	@GetMapping(value = {"", "/"})
	public String init(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/application/search-cr/index";
	}

	@GetMapping(value = {"/index"})
	public String index(Model model) {
		model.addAttribute("applicationSearchCrForm", new ApplicationSearchCrForm());
		return "application/search-cr/index";
	}
	
	@GetMapping(value = "/search")
	public String search(@Valid ApplicationSearchCrForm applicationSearchCrForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "application/search-cr/index";
		}
		ApplicationSearchCrInputDto inputDto = new ApplicationSearchCrInputDto();
		BeanUtils.copyProperties(applicationSearchCrForm, inputDto);
		
		ApplicationSearchCrOutputDto outputDto = new ApplicationSearchCrOutputDto();
		try {
			outputDto = service.search(inputDto);
			applicationSearchCrForm.setPageCount(outputDto.getPageCount());
			applicationSearchCrForm.setPageSize(outputDto.getPageSize());
		} catch (BusinessException e) {
			outputDto.setError(e.getMessage());
		}
		
		model.addAttribute("outputDto", outputDto);
		return "application/search-cr/index";
	}
}
