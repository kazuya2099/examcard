package com.examcard.controller.top;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.dto.common.InformationDto;
import com.examcard.dto.common.UserDto;
import com.examcard.dto.top.TopDto;
import com.examcard.service.common.InformationService;

@Controller
@RequestMapping(value = "/top")
public class TopController {

	private Logger logger = LoggerFactory.getLogger(TopController.class);

	// @Autowired
	// private TopService topService;

	@Autowired
	private InformationService informationService;

	@RequestMapping(value = {"", "/"})
	public String index(Model model) {
		UserDto userDto = AuthenticationUtil.getUserDto();

		model.addAttribute("userDto", userDto);
		TopDto topDto = new TopDto();
		topDto.setFirstname(userDto.getFirstname());
		topDto.setLastname(userDto.getLastname());

		List<InformationDto> informationDtos = informationService.getInformation();
		if (informationDtos.get(0) != null) {
			String topInformation = informationDtos.get(0).getMessage();
			topInformation = topInformation.replace("\r\n", "<br>");
			topDto.setInformation(topInformation);
		}

		logger.debug("informationDtos : " + informationDtos.get(0));
		model.addAttribute("topDto", topDto);
		return "top/index";
	}

}