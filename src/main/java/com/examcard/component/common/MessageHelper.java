package com.examcard.component.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String code) {
		return messageSource.getMessage(code, null, null);
	}
	
	public String getMessage(String code, String[] args) {
		return messageSource.getMessage(code, args, null);
	}
}
