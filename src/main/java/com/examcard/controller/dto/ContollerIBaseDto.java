package com.examcard.controller.dto;

import com.examcard.constant.ErrorCode;

import lombok.Data;

/**
 * DTO基底クラス.
 * 
 * @author Masanao Hamada
 */
@Data
public class ContollerIBaseDto {
	
	/** レスポンスの結果を返す */
	private String code;
	
	/** レスポンスのメッセージを返す */
	private String message;
	
	/**
	 * コンストラクタ.
	 */
	public ContollerIBaseDto() {
		this.setCode(ErrorCode.I200000.getCode());
		this.setMessage(ErrorCode.I200000.getMessage());
	}
}
