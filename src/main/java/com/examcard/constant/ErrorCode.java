package com.examcard.constant;

/**
 * エラーコード定義
 */
public enum ErrorCode {

	I200000(200, "200000", ""),
	W400000(400, "400000", "不正なリクエストです。"),
	W400001(400, "400001", "リクエストデータバリデーションエラーです。"),
	W400100(400, "400100", "ユーザーマスタに該当するデータが存在しません。"),
	E500000(500, "500000", "システムエラー");

	private int status;
	private String code;
	private String message;
	
	private ErrorCode(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
