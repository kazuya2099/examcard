package com.examcard.service.dto;

import lombok.Data;

/**
 * DTO基底クラス.
 * 
 * @author Masanao Hamada
 */
@Data
public class BaseDto {
	/* 削除フラグ */
	private String deleteFlag;
	/* 作成者 */
	private String createUser;
	/* 作成日時 */
	private String createTimestamp;
	/* 更新者 */
	private String updateUser;
	/* 更新日時 */
	private String updateTimestamp;
	/* 削除者 */
	private String deleteUser;
	/* 削除日時 */
	private String deleteTimestamp;
}
