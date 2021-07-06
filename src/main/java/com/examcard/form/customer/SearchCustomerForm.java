package com.examcard.form.customer;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SearchCustomerForm {
	private String id;
	@Length(max=10)
	private String firstname;
	@Length(max=10)
	private String lastname;
	@Length(max=10)
	@Pattern(regexp = "[ァ-ヴー－]+", message = "{validation.zenkaku.kana.message}")
	private String lastnameKana;
	@Length(max=10)
	@Pattern(regexp = "[ァ-ヴー－]+", message = "{validation.zenkaku.kana.message}")
	private String firstnameKana;
	@Length(max=3)
	@Pattern(regexp = "[0-9]{3}", message = "{validation.hankaku.number.message}")
	private String zip1;
	@Length(max=4)
	@Pattern(regexp = "[0-9]{4}", message = "{validation.hankaku.number.message}")
	private String zip2;
	private String addressPrefecture;
	@Length(max=80)
	private String addressCity;
	@Length(max=80)
	private String addressOoaza;
	@Length(max=80)
	private String addressAza;
	@Length(max=80)
	private String addressOther;
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String tel1;
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String tel2;
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String tel3;
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String mobileTel1;
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String mobileTel2;
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String mobileTel3;
	@Email
	@Length(max=255)
	private String email;
	private String setaiFamily;
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String setaiCount;
	private String setaiStatus;
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String setaiYear;
	private String setaiLoan;
	@Digits(integer = 12, fraction = 0)
	private Long income;
	@Digits(integer = 12, fraction = 0)
	private Long savings;
	private String employmentStatus;
	private String companyName;
	private String companyZip1;
	private String companyZip2;
	private String companyAddressPrefecture;
	private String companyAddressCity;
	private String companyAddressOoaza;
	private String companyAddressAza;
	private String companyAddressOther;
	
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String companyTel1;
	
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String companyTel2;
	
	@Length(max=4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String companyTel3;
	
	private String companyDepartment;
	private String companyIndustryType;
	private String companyWorkYears;
	private String applicationStatus;
	private Integer pageNo;
	private Integer pageCount;
	private Integer pageSize;
}
