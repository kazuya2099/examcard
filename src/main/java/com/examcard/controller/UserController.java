package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examcard.component.common.CodeList;
import com.examcard.dto.LoginOutputDto;
import com.examcard.dto.UserOutputDto;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	public CodeList codeDefinition;

	@GetMapping(value = { "", "/", "/index" })
	public UserOutputDto index(Model model) {
		UserOutputDto outputDto = new UserOutputDto();
		return outputDto;
	}

	@GetMapping(value = "/edit")
	public UserOutputDto editUserBaseInfo(LoginOutputDto userForm, Model model) {
		UserOutputDto outputDto = new UserOutputDto();

		//		Set<Entry<String, String>> setaiFamilySet = codeDefinition.getCodeSet("setaiFamily");
		//		Set<Entry<String, String>> setaiStatusSet = codeDefinition.getCodeSet("setaiStatus");
		//		Set<Entry<String, String>> setaiLoanSet = codeDefinition.getCodeSet("setaiLoan");
		//		Set<Entry<String, String>> employmentStatusSet = codeDefinition.getCodeSet("employmentStatus");
		//		Set<Entry<String, String>> companyIndustryTypeSet = codeDefinition.getCodeSet("companyIndustryType");
		//		model.addAttribute("setaiFamilySet", setaiFamilySet);
		//		model.addAttribute("setaiStatusSet", setaiStatusSet);
		//		model.addAttribute("setaiLoanSet", setaiLoanSet);
		//		model.addAttribute("employmentStatusSet", employmentStatusSet);
		//		model.addAttribute("companyIndustryTypeSet", companyIndustryTypeSet);

		return outputDto;
	}
}
