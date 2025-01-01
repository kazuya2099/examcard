package com.examcard.component.common;

import jakarta.annotation.Nullable;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

	private MessageSource messageSource;
	
	public MessageHelper(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Nullable
	public String getMessage(String code) {
		return messageSource.getMessage(code, null, null);
	}
	
	@Nullable
	public String getMessage(String code, String[] args) {
		return messageSource.getMessage(code, args, null);
	}
}
