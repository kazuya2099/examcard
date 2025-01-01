package com.examcard.exception;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.ObjectError;

import com.examcard.constant.ErrorCode;
import com.examcard.controller.dto.ContollerIBaseDto;

/**
 * 業務エラー例外クラス.
 * 
 * @author Masanao Hamada
 */
public class BusinessException extends RuntimeException {

	Logger logger = Logger.getLogger(BusinessException.class);

	/** DTO基底クラス */
	private ContollerIBaseDto contollerIBaseDto = new ContollerIBaseDto();
	
	/** Httpステータスコード */
	private int status = 0;

	/** メッセージソース */
	private ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

	{
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
	}

	/**
	 * コンストラクタ
	 * 
	 * @param errorCode エラーコード
	 * @param className クラス名
	 */
	public BusinessException(ErrorCode errorCode, String className) {
		super(errorCode.getMessage());
		this.status = errorCode.getStatus();
		this.contollerIBaseDto.setCode(errorCode.getCode());
		this.contollerIBaseDto.setMessage(errorCode.getMessage());
		logger.warn(String.format("エラーコード = %s, エラーメッセージ = %s, クラス = %s", errorCode.getCode(), errorCode.getMessage(),
				className));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param status Httpステータスコード
	 * @param code エラーコード
	 * @param message エラーメッセージ
	 * @param className クラス名
	 */
	public BusinessException(int status, String code, String message, String className) {
		super(message);
		this.status = status;
		this.contollerIBaseDto.setCode(code);
		this.contollerIBaseDto.setMessage(message);
		logger.warn(String.format("エラーコード = %s, エラーメッセージ = %s, クラス = %s", code, message, className));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param status Httpステータスコード
	 * @param code エラーコード
	 * @param message エラーメッセージ
	 * @param cause 例外
	 */
	public BusinessException(int status, String code, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.contollerIBaseDto.setCode(code);
		this.contollerIBaseDto.setMessage(message);
		logger.warn(String.format("エラーコード = %s, エラーメッセージ = %s", code, message));
	}

	/**
	 * コンストラクタ(バリデーションエラー)
	 * 
	 * @param errorCode エラーコード
	 * @param className クラス名
	 */
	public BusinessException(ErrorCode errorCode, List<ObjectError> errors, String className) {
		super(errorCode.getMessage());
		this.status = errorCode.getStatus();
		String validationErrorMessage = errors.stream().map(e -> messageSource.getMessage(e, Locale.getDefault()))
				.collect(Collectors.joining(", "));
		this.contollerIBaseDto.setCode(errorCode.getCode());
		this.contollerIBaseDto.setMessage(validationErrorMessage);
		logger.warn(
				String.format("エラーコード = %s, エラーメッセージ = %s, クラス = %s", errorCode.getCode(), validationErrorMessage,
						className));
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ContollerIBaseDto getContollerIBaseDto() {
		return contollerIBaseDto;
	}

	public void setContollerIBaseDto(ContollerIBaseDto contollerIBaseDto) {
		this.contollerIBaseDto = contollerIBaseDto;
	}
}