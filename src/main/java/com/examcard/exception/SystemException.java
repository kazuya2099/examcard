package com.examcard.exception;

import org.jboss.logging.Logger;

import com.examcard.constant.ErrorCode;

public class SystemException extends RuntimeException {


	Logger logger = Logger.getLogger(SystemException.class);
	
	/**
	 * エラーコード
	 */
	private String code;
	
	/**
	 * エラーメッセージ
	 */
	private String message;

	public SystemException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.message = message;
		logger.error(message, cause);
	}

	public SystemException(String code, String message, String className) {
		super(message);
		this.code = code;
		this.message = message;
		logger.error(String.format("エラーコード = %s: エラーメッセージ = %s: クラス = %s", this.code, this.message, className));
	}

	public SystemException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getMessage(), cause);
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
		logger.error(String.format("エラーコード = %s: エラーメッセージ = %s", this.code, this.message, cause));
	}
	
	public SystemException(ErrorCode errorCode, String className) {
		super(errorCode.getMessage());
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
		logger.error(String.format("エラーコード = %s: エラーメッセージ = %s: クラス = %s", this.code, this.message, className));
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
