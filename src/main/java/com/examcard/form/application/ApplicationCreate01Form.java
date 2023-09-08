package com.examcard.form.application;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ApplicationCreate01Form {

	private String id;
	
	@NotBlank
	private String firstname;
	
	@NotBlank
	private String lastname;
	
	@NotBlank
	@Pattern(regexp = "\\p{InKatakana}+", message = "{validation.zenkaku.kana.message}")
	private String firstnameKana;
	
	@NotBlank
	@Pattern(regexp = "\\p{InKatakana}+", message = "{validation.zenkaku.kana.message}")
	private String lastnameKana;
	
	@NotBlank
	@Pattern(regexp = "^\\d{3}$", message = "{validation.hankaku.number.message}")
	private String zip1;
	
	@NotBlank
	@Pattern(regexp = "^\\d{4}$", message = "{validation.hankaku.number.message}")
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
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String tel1;
	
	@NotBlank
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String tel2;
	
	@NotBlank
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String tel3;
	
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String mobileTel1;
	
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String mobileTel2;
	
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String mobileTel3;
	
	@Email
	@Length(max=255)
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String setaiFamily;
	
	@NotBlank
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String setaiCount;
	
	@NotBlank
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String setaiStatus;
	
	@NotBlank
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String setaiYear;
	
	@NotBlank
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String setaiLoan;
	
	@NotNull
	@Digits(integer = 12, fraction = 0)
	private Long income;
	
	@NotNull
	@Digits(integer = 12, fraction = 0)
	private Long savings;
	
	@NotBlank
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String employmentStatus;
	
	@NotBlank
	@Length(max=30)
	private String companyName;
	
	@NotBlank
	@Length(max=3)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String companyZip1;
	
	@NotBlank
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String companyZip2;
	
	@NotBlank
	@Length(max=4)
	private String companyAddressPrefecture;
	
	@NotBlank
	@Length(max=80)
	private String companyAddressCity;
	
	@NotBlank
	@Length(max=80)
	private String companyAddressOoaza;
	
	@Length(max=80)
	private String companyAddressAza;
	
	@Length(max=80)
	private String companyAddressOther;
	
	@NotBlank
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String companyTel1;
	
	@NotBlank
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String companyTel2;
	
	@NotBlank
	@Length(max=4)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String companyTel3;
	
	@NotBlank
	@Length(max=20)
	private String companyDepartment;
	
	@Length(max=1)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String companyIndustryType;
	
	@NotBlank
	@Length(max=2)
	@Pattern(regexp = "^\\d*$", message = "{validation.hankaku.number.message}")
	private String companyWorkYears;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date updateDate;
}
