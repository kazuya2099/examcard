package com.examcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examcard.dto.TopInputDto;
import com.examcard.dto.TopOutputDto;
import com.examcard.service.TopService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/top")
public class TopController {

	@Autowired
	private TopService topService;
	
	@GetMapping(value = {"", "/"})
	public TopOutputDto index(@Valid TopInputDto inputDto) {
		TopOutputDto outputDto = topService.getTopData();
		return outputDto;
	}
}