package com.examcard.form.application;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ApplicationUpdateCrForm {

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
