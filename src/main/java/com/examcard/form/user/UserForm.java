package com.examcard.form.user;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserForm {
	private String id;
	private String firstname;
	private String lastname;
	private String lastnameKana;
	private String firstnameKana;
	@NotBlank
	@Length(max=3)
	private String zip1;
	@NotBlank
	@Length(max=4)
	private String zip2;
	@NotBlank
	@Length(max=4)
	private String addressPrefecture;
	@NotBlank
	@Length(max=80)
	private String addressCity;
	@NotBlank
	@Length(max=80)
	private String addressOoaza;
	@Length(max=80)
	private String addressAza;
	@Length(max=80)
	private String addressOther;
	@NotBlank
	@Length(max=4)
	private String tel1;
	@NotBlank
	@Length(max=4)
	private String tel2;
	@NotBlank
	@Length(max=4)
	private String tel3;
	@Length(max=4)
	private String mobileTel1;
	@Length(max=4)
	private String mobileTel2;
	@Length(max=4)
	private String mobileTel3;
	@Email
	@Length(max=255)
	private String email;
	private String setaiFamily;
	private String setaiCount;
	private String setaiStatus;
	private String setaiYear;
	private String setaiLoan;
	private BigDecimal income;
	private BigDecimal savings;
	private String employmentStatus;
	private String companyName;
	private String companyZip1;
	private String companyZip2;
	private String companyAddressPrefecture;
	private String companyAddressCity;
	private String companyAddressOoaza;
	private String companyAddressAza;
	private String companyAddressOther;
	private String companyTel1;
	private String companyTel2;
	private String companyTel3;
	private String companyDepartment;
	private String companyIndustryType;
	private String companyWorkYears;
}
