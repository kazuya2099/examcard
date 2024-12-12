package com.examcard.dto;

import lombok.Data;

@Data
public class BaseDto {
	/** レスポンスの結果を返す */
	private String code;
	/** レスポンスのメッセージを返す */
	private String message;
}
