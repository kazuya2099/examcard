package com.examcard.controller.form;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ShinseiUpdateAdminForm {

	@NotBlank
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String id;
	
	@NotBlank
	private String applicationStatus;

	@Length(max=255)
	private String applicationComment;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date updateDate;
}
