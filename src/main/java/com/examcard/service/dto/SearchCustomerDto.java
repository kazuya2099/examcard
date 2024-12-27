package com.examcard.service.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SearchCustomerDto extends BaseDto implements Serializable {

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
	
	private String address1;
	
	@Length(max=80)
	private String address2;
	
	@Length(max=80)
	private String address3;
	
	@Length(max=80)
	private String address4;
	
	@Length(max=12)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String tel;
	
	@Email
	@Length(max=255)
	private String email;

	private Integer pageNo;
	
	private Integer pageCount;
	
	private Integer pageSize;
}
