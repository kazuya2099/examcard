package com.examcard.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class ExamCardControllerAdvice {

	@InitBinder
	public void initbinder(WebDataBinder binder){
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
