package com.examcard.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.val;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
