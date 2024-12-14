package com.examcard.dto;

import com.examcard.constant.ErrorCode;

import lombok.Data;

@Data
public class BaseDto {
	
	/** レスポンスの結果を返す */
	private String code;
	/** レスポンスのメッセージを返す */
	private String message;
	
	public BaseDto() {
		this.setCode(ErrorCode.I200000.getCode());
		this.setMessage(ErrorCode.I200000.getMessage());
	}
}
