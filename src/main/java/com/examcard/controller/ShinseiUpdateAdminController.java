package com.examcard.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examcard.component.common.CodeList;
import com.examcard.controller.form.ShinseiUpdateAdminForm;
import com.examcard.service.ShinseiUpdateAdminService;
import com.examcard.service.dto.ShinseiDto;

import jakarta.validation.Valid;

/**
 * 顧客審査変更申請
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/update02")
public class ShinseiUpdateAdminController {

	@Autowired
	private CodeList codeList;

	@Autowired
	private ShinseiUpdateAdminService applicationUpdate02Service;

	@GetMapping(value = "/input")
	public String input(@RequestParam String id, ShinseiUpdateAdminForm applicationUpdate02Form, Model model) {
		ShinseiDto applicationDto = applicationUpdate02Service.getApplication(id);
		applicationUpdate02Form.setId(id);
		applicationUpdate02Form.setApplicationStatus(applicationDto.getApplicationStatus());
		applicationUpdate02Form.setApplicationComment(applicationDto.getApplicationComment());
		BeanUtils.copyProperties(applicationDto, applicationUpdate02Form);
		model.addAttribute("customerApplicationDto", applicationDto);
		model.addAttribute("applicationUpdate02Form", applicationUpdate02Form);
		model.addAttribute("applicationStatus", codeList.getApplicationStatus());
		return "application/update02/input";
	}

	@PostMapping(value = "/input")
	public String update(@Valid ShinseiUpdateAdminForm applicationUpdate02Form, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			ShinseiDto applicationDto = applicationUpdate02Service.getApplication(applicationUpdate02Form.getId());
			model.addAttribute("applicationDto", applicationDto);
			return "application/update02/input";
		}
		ShinseiDto updateDto = new ShinseiDto();
		BeanUtils.copyProperties(applicationUpdate02Form, updateDto);
		applicationUpdate02Service.update(updateDto);
		redirectAttributes.addFlashAttribute("applicationUpdate02Form", applicationUpdate02Form);
		return "redirect:/application/update02/complete";
	}

	@GetMapping(value = "/complete")
	public String complete() {
		return "application/update02/complete";
	}
}
