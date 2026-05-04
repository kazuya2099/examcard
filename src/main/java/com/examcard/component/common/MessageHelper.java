package com.examcard.component.common;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

	private MessageSource messageSource;

	public MessageHelper(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@SuppressWarnings("null")
	public String getMessage(String code) {
		return messageSource.getMessage(code, null, null);
	}

	@SuppressWarnings("null")
	public String getMessage(String code, String[] args) {
		return messageSource.getMessage(code, args, null);
	}
}
