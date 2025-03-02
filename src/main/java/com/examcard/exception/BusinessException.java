package com.examcard.exception;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.ObjectError;

import com.examcard.constant.ErrorCode;
import com.examcard.controller.dto.ContollerBaseDto;

/**
 * 業務エラー例外クラス.
 * 
 * @author Masanao Hamada
 */
public class BusinessException extends RuntimeException {

	private final Logger logger = Logger.getLogger(BusinessException.class);

	/** DTO基底クラス */
	private ContollerBaseDto contollerBaseDto = new ContollerBaseDto();

	/** Httpステータスコード */
	private int status;

	/** メッセージソース */
	private transient ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

	public BusinessException() {
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
		this.contollerBaseDto.setCode(errorCode.getCode());
		this.contollerBaseDto.setMessage(errorCode.getMessage());
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
		this.contollerBaseDto.setCode(code);
		this.contollerBaseDto.setMessage(message);
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
		this.contollerBaseDto.setCode(code);
		this.contollerBaseDto.setMessage(message);
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
		this.contollerBaseDto.setCode(errorCode.getCode());
		this.contollerBaseDto.setMessage(validationErrorMessage);
		logger.warn(
				String.format("エラーコード = %s, エラーメッセージ = %s, クラス = %s", errorCode.getCode(), validationErrorMessage,
						className));
	}

	public int getStatus() {
		return status;
	}

	public ContollerBaseDto getContollerBaseDto() {
		return contollerBaseDto;
	}
}