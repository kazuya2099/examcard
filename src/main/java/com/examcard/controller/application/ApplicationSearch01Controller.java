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

import com.examcard.component.common.CodeList;
import com.examcard.constant.CodeMapKey;
import com.examcard.dto.application.ApplicationSearch01InputDto;
import com.examcard.dto.application.ApplicationSearch01OutputDto;
import com.examcard.form.application.ApplicationSearch01Form;
import com.examcard.service.application.ApplicationSearch01Service;

import jakarta.validation.Valid;

/**
 * 顧客審査申請検索
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/search01")
@SessionAttributes(value = "applicationSearch01Form", types = {ApplicationSearch01Form.class})
public class ApplicationSearch01Controller {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private ApplicationSearch01Service applicationSearch01Service;
	
	@ModelAttribute(name = "applicationSearch01Form")
	public ApplicationSearch01Form getApplicationSearch01Form() {
		return new ApplicationSearch01Form();
	}
	
	@GetMapping(value = {"", "/"})
	public String init(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/application/search01/index";
	}

	@GetMapping(value = {"/index"})
	public String index(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		ApplicationSearch01OutputDto outputDto = new ApplicationSearch01OutputDto();
		outputDto.setApplicationStatus(codeList.getCodeMap(CodeMapKey.APPLICATION_STATUS));
		model.addAttribute("applicationSearch01Form", new ApplicationSearch01Form());
		model.addAttribute("outputDto", outputDto);
		return "application/search01/index";
	}
	
	@GetMapping(value = "/search")
	public String search(@Valid ApplicationSearch01Form applicationSearch01Form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			ApplicationSearch01OutputDto outputDto = new ApplicationSearch01OutputDto();
			outputDto.setApplicationStatus(codeList.getCodeMap(CodeMapKey.APPLICATION_STATUS));
			model.addAttribute("outputDto", outputDto);
			return "application/search01/index";
		}

		ApplicationSearch01InputDto inputDto = new ApplicationSearch01InputDto();
		BeanUtils.copyProperties(applicationSearch01Form, inputDto);
		
		ApplicationSearch01OutputDto outputDto = applicationSearch01Service.search(inputDto);
		outputDto.setApplicationStatus(codeList.getCodeMap(CodeMapKey.APPLICATION_STATUS));
		applicationSearch01Form.setPageCount(outputDto.getPageCount());
		applicationSearch01Form.setPageSize(outputDto.getPageSize());
		
		model.addAttribute("outputDto", outputDto);
		return "application/search01/index";
	}
}
