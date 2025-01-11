package com.examcard.repository.entity;
<<<<<<<< HEAD:src/main/java/com/examcard/repository/entity/ShinseiSerchParamEntity.java

import java.io.Serializable;
========
>>>>>>>> aa7b932926e2b65ed5b5efc11b30a0f2a66287bd:src/main/java/com/examcard/repository/entity/CustomerApplicationSearchParam.java

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ShinseiSerchParamEntity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
	private String applicationStatus;
	private String applicationComment;
	private Integer start;
	private Integer end;
}
