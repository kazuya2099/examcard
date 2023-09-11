package com.examcard.controller.user;

import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.component.common.CodeList;
import com.examcard.dto.common.UserDto;
import com.examcard.form.user.UserForm;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	public CodeList codeDefinition;

	@GetMapping(value = {"", "/", "/index"})
	public String index(Model model) {
		UserDto userDto = AuthenticationUtil.getUserDto();
		model.addAttribute("userDto", userDto);
		return "user/index";
	}

	@GetMapping(value = "/edit")
	public String editUserBaseInfo(UserForm userForm, Model model) {
		UserDto userDto = AuthenticationUtil.getUserDto();
		BeanUtils.copyProperties(userDto, userForm);

		Set<Entry<String, String>> setaiFamilySet = codeDefinition.getCodeSet("setaiFamily");
		Set<Entry<String, String>> setaiStatusSet = codeDefinition.getCodeSet("setaiStatus");
		Set<Entry<String, String>> setaiLoanSet = codeDefinition.getCodeSet("setaiLoan");
		Set<Entry<String, String>> employmentStatusSet = codeDefinition.getCodeSet("employmentStatus");
		Set<Entry<String, String>> companyIndustryTypeSet = codeDefinition.getCodeSet("companyIndustryType");
		model.addAttribute("setaiFamilySet", setaiFamilySet);
		model.addAttribute("setaiStatusSet", setaiStatusSet);
		model.addAttribute("setaiLoanSet", setaiLoanSet);
		model.addAttribute("employmentStatusSet", employmentStatusSet);
		model.addAttribute("companyIndustryTypeSet", companyIndustryTypeSet);

		return "user/editUserBaseInfo";
	}

	@PostMapping(value = "/edit")
	public String confirmUserBaseInfo(@Validated UserForm userForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/editUserBaseInfo";
		}
		model.addAttribute("userForm", userForm);
		return "user/confirmUserBaseInfo";
	}
}
