package com.examcard.service.dto;

import lombok.Data;

@Data
public class ApplicationSearch01InputDto {
	
	private String id;
	private String firstname;
	private String lastname;
	private String lastnameKana;
	private String firstnameKana;
	private String zip1;
	private String zip2;
	private String addressPrefecture;
	private String addressCity;
	private String addressOoaza;
	private String addressAza;
	private String addressOther;
	private String tel1;
	private String tel2;
	private String tel3;
	private String mobileTel1;
	private String mobileTel2;
	private String mobileTel3;
	private String email;
	private String setaiFamily;
	private String setaiCount;
	private String setaiStatus;
	private String setaiYear;
	private String setaiLoan;
	private Long income;
	private Long savings;
	private String employmentStatus;
	private String applicationStatus;
	private Integer pageNo;
}
