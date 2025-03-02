package com.examcard.exception;

import org.jboss.logging.Logger;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.examcard.constant.ErrorCode;
import com.examcard.controller.dto.ContollerBaseDto;

/**
 * システムエラー例外クラス.
 * 
 * @author Masanao Hamada
 */
public class SystemException extends RuntimeException {

	private final Logger logger = Logger.getLogger(SystemException.class);

	/** DTO基底クラス */
	private ContollerBaseDto contollerBaseDto = new ContollerBaseDto();

	/** Httpステータスコード */
	private int status;

	/** メッセージソース */
	private transient ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

	public SystemException() {
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
	}

	/**
	 * コンストラクタ
	 * 
	 * @param status
	 * @param code
	 * @param message
	 * @param cause
	 */
	public SystemException(int status, String code, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.contollerBaseDto.setCode(code);
		this.contollerBaseDto.setMessage(message);
		logger.error(message, cause);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param status
	 * @param code
	 * @param message
	 * @param className
	 */
	public SystemException(int status, String code, String message, String className) {
		super(message);
		this.status = status;
		this.contollerBaseDto.setCode(code);
		this.contollerBaseDto.setMessage(message);
		logger.error(String.format("エラーコード = %s: エラーメッセージ = %s: クラス = %s", code, message, className));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param errorCode
	 * @param cause
	 */
	public SystemException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getMessage(), cause);
		this.status = errorCode.getStatus();
		this.contollerBaseDto.setCode(errorCode.getCode());
		this.contollerBaseDto.setMessage(errorCode.getMessage());
		logger.error(String.format("エラーコード = %s: エラーメッセージ = %s", errorCode.getCode(), errorCode.getMessage(), cause));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param errorCode
	 * @param className
	 */
	public SystemException(ErrorCode errorCode, String className) {
		super(errorCode.getMessage());
		this.status = errorCode.getStatus();
		this.contollerBaseDto.setCode(errorCode.getCode());
		this.contollerBaseDto.setMessage(errorCode.getMessage());
		logger.error(String.format("エラーコード = %s: エラーメッセージ = %s: クラス = %s", errorCode.getCode(), errorCode.getMessage(),
				className));
	}

	public ContollerBaseDto getContollerBaseDto() {
		return contollerBaseDto;
	}

	public int getStatus() {
		return status;
	}
}
