package com.examcard.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginContollerOutputDto extends ContollerBaseDto {

	private String id;
	private String sei;
	private String mei;
	private String seiKana;
	private String meiKana;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String mail;
	private String tel;
}
