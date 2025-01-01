package com.examcard.controller.dto;

import java.io.Serializable;

import com.examcard.constant.ErrorCode;

import lombok.Data;

/**
 * DTO基底クラス.
 * 
 * @author Masanao Hamada
 */
@Data
public class ContollerBaseDto implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	/** レスポンスの結果を返す */
	private String code;
	
	/** レスポンスのメッセージを返す */
	private String message;
	
	/**
	 * コンストラクタ.
	 */
	public ContollerBaseDto() {
		this.setCode(ErrorCode.I200000.getCode());
		this.setMessage(ErrorCode.I200000.getMessage());
	}
}
