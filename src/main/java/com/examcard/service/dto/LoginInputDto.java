package com.examcard.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/* 
* ログインインプットDTO
 * 
 * @author Masanao Hamada
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginInputDto extends BaseDto {
	/* メールアドレス */
	private String mail;
	/* パスワード */
	private String password;
}
