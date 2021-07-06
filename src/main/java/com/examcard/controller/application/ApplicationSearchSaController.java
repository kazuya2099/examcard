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

import com.examcard.dto.application.ApplicationSearchSaInputDto;
import com.examcard.dto.application.ApplicationSearchSaOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.form.application.ApplicationSearchSaForm;
import com.examcard.service.application.ApplicationSearchSaService;

/**
 * 顧客審査申請検索
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/search-sa")
@SessionAttributes(value = "applicationSearchSaForm", types = {ApplicationSearchSaForm.class})
public class ApplicationSearchSaController {

	@Autowired
	private ApplicationSearchSaService service;
	
	@ModelAttribute(name = "applicationSearchSaForm")
	public ApplicationSearchSaForm getApplicationSearchSaForm() {
		return new ApplicationSearchSaForm();
	}
	
	@GetMapping(value = {"", "/"})
	public String init(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/application/search-sa/index";
	}

	@GetMapping(value = {"/index"})
	public String index(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		model.addAttribute("applicationSearchSaForm", new ApplicationSearchSaForm());
		return "application/search-sa/index";
	}
	
	@GetMapping(value = "/search")
	public String search(@Valid ApplicationSearchSaForm applicationSearchSaForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "application/search-sa/index";
		}
		ApplicationSearchSaInputDto inputDto = new ApplicationSearchSaInputDto();
		BeanUtils.copyProperties(applicationSearchSaForm, inputDto);
		
		ApplicationSearchSaOutputDto outputDto = new ApplicationSearchSaOutputDto();
		try {
			outputDto = service.search(inputDto);
			applicationSearchSaForm.setPageCount(outputDto.getPageCount());
			applicationSearchSaForm.setPageSize(outputDto.getPageSize());
		} catch (BusinessException e) {
			outputDto.setError(e.getMessage());
		}
		
		model.addAttribute("outputDto", outputDto);
		return "application/search-sa/index";
	}
}
