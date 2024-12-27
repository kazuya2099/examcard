package com.examcard.controller;

import org.jboss.logging.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examcard.constant.ErrorCode;
import com.examcard.controller.dto.ContollerIBaseDto;
import com.examcard.exception.BusinessException;
import com.examcard.exception.SystemException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * コントローラーアドバイス.
 * 
 * @author Masanao Hamada
 */
@ControllerAdvice
public class GlobalControllerAdvice {

	Logger logger = Logger.getLogger(GlobalControllerAdvice.class);
	
	/**
	 * 業務エラーハンドラ
	 * 
	 * @param e 業務エラー例外クラス
	 * @return 業務エラーレスポンスエンティティ
	 * @throws JsonProcessingException
	 */
	@ExceptionHandler({ BusinessException.class })
	public ResponseEntity<String> handleBusinessException(BusinessException e) {
		return getResponseEnity(e.getStatus(), e.getContollerIBaseDto());
	}

	/**
	 * システムエラーハンドラ
	 * 
	 * @param e システムエラー例外クラス
	 * @return システムエラーレスポンスエンティティ
	 * @throws JsonProcessingException
	 */
	@ExceptionHandler({ SystemException.class })
	public ResponseEntity<String> handleSystemException(SystemException e) {
		return getResponseEnity(e.getStatus(), e.getContollerIBaseDto());
	}

	/**
	 * システムエラーハンドラ（SystemException以外の例外）
	 * 
	 * @param e システムエラー例外クラス
	 * @return システムエラーレスポンスエンティティ
	 * @throws JsonProcessingException
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleException(Exception e) {
		ContollerIBaseDto contollerIBaseDto = new ContollerIBaseDto();
		contollerIBaseDto.setCode(ErrorCode.E500000.getCode());
		contollerIBaseDto.setMessage(ErrorCode.E500000.getMessage());
		return getResponseEnity(ErrorCode.E500000.getStatus(), contollerIBaseDto);
	}

	/**
	 * エラーハンドラのレスポンスエンティティを生成
	 * 
	 * @param status
	 * @param baseDto
	 * @return レスポンスエンティティ
	 * @throws JsonProcessingException
	 */
	private ResponseEntity<String> getResponseEnity(int status, ContollerIBaseDto contollerIBaseDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = objectMapper.writeValueAsString(contollerIBaseDto);
		} catch (JsonProcessingException e) {
			logger.error(e);
			jsonString = "{\"code\":\"500000\", \"message\": \"システムエラー\"}";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(jsonString, headers,
				HttpStatusCode.valueOf(status));
		return entity;
	}
}
