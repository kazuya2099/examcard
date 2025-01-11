package com.examcard.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ログインインプットDTO
 * 
 * @author Masanao Hamada
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginContollerInputDto extends ContollerBaseDto {

	@NotNull
	@Size(min = 1, max = 30)
	private String mail;

	@NotNull
	@Size(min = 1, max = 20)
	private String password;
}
