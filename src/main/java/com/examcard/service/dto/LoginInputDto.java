package com.examcard.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ログインインプットDTO
 * 
 * @author Masanao Hamada
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginInputDto extends BaseDto implements Serializable {
	/* メールアドレス */
	private String mail;
	/* パスワード */
	private String password;
}
