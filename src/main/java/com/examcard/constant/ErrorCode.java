package com.examcard.constant;

public enum ErrorCode {

	W400001("400001", "リクエストデータバリデーションエラーです。");

	private String code;
	private String message;
	
	private ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
