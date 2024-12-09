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

import com.examcard.component.common.CodeList;
import com.examcard.controller.form.ShinseiSearchForm;
import com.examcard.service.ShinseiSearchService;
import com.examcard.service.dto.ShinseiSearchInputDto;
import com.examcard.service.dto.ShinseiSearchOutputDto;

import jakarta.validation.Valid;

/**
 * 顧客審査申請検索
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/search01")
@SessionAttributes(value = "applicationSearch01Form", types = { ShinseiSearchForm.class })
public class ShinseiSearchController {

	@Autowired
	private CodeList codeList;

	@Autowired
	private ShinseiSearchService applicationSearch01Service;

	@ModelAttribute(name = "applicationSearch01Form")
	public ShinseiSearchForm getApplicationSearch01Form() {
		return new ShinseiSearchForm();
	}

	@GetMapping(value = { "", "/" })
	public String init(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/application/search01/index";
	}

	@GetMapping(value = { "/index" })
	public String index(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		ShinseiSearchOutputDto outputDto = new ShinseiSearchOutputDto();
		outputDto.setApplicationStatus(codeList.getApplicationStatus());
		model.addAttribute("applicationSearch01Form", new ShinseiSearchForm());
		model.addAttribute("outputDto", outputDto);
		return "application/search01/index";
	}

	@GetMapping(value = "/search")
	public String search(@Valid ShinseiSearchForm applicationSearch01Form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			ShinseiSearchOutputDto outputDto = new ShinseiSearchOutputDto();
			outputDto.setApplicationStatus(codeList.getApplicationStatus());
			model.addAttribute("outputDto", outputDto);
			return "application/search01/index";
		}

		ShinseiSearchInputDto inputDto = new ShinseiSearchInputDto();
		BeanUtils.copyProperties(applicationSearch01Form, inputDto);

		ShinseiSearchOutputDto outputDto = applicationSearch01Service.search(inputDto);
		outputDto.setApplicationStatus(codeList.getApplicationStatus());
		applicationSearch01Form.setPageCount(outputDto.getPageCount());
		applicationSearch01Form.setPageSize(outputDto.getPageSize());

		model.addAttribute("outputDto", outputDto);
		return "application/search01/index";
	}
}
