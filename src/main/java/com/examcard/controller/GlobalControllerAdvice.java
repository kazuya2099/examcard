package com.examcard.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examcard.exception.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler({ BusinessException.class })
	public ResponseEntity<String> handleException(BusinessException e) throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseEntity<String> entity = new ResponseEntity<String>(objectMapper.writeValueAsString(e.getBaseDto()), headers,
				HttpStatusCode.valueOf(e.getStatus()));
		return entity;
	}
}
