package com.examcard.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginInputDto extends BaseDto {

	@NotNull
	@Size(min = 1, max = 30)
	private String mailAddress;

	@NotNull
	@Size(min = 1, max = 20)
	private String password;
}
