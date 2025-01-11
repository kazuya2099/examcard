package com.examcard.service.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ShinseiSearchAdminInputDto {

	private String id;

	@Length(max = 10)
	private String firstname;

	@Length(max = 10)
	private String lastname;

	@Length(max = 10)
	@Pattern(regexp = "[ァ-ヴー－]+", message = "{validation.zenkaku.kana.message}")
	private String lastnameKana;

	@Length(max = 10)
	@Pattern(regexp = "[ァ-ヴー－]+", message = "{validation.zenkaku.kana.message}")
	private String firstnameKana;

	@Length(max = 3)
	@Pattern(regexp = "[0-9]{3}", message = "{validation.hankaku.number.message}")
	private String zip1;

	@Length(max = 4)
	@Pattern(regexp = "[0-9]{4}", message = "{validation.hankaku.number.message}")
	private String zip2;

	private String addressPrefecture;

	@Length(max = 80)
	private String addressCity;

	@Length(max = 80)
	private String addressOoaza;

	@Length(max = 80)
	private String addressAza;

	@Length(max = 80)
	private String addressOther;

	@Length(max = 4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String tel1;

	@Length(max = 4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String tel2;

	@Length(max = 4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String tel3;

	@Length(max = 4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String mobileTel1;

	@Length(max = 4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String mobileTel2;

	@Length(max = 4)
	@Pattern(regexp = "[0-9]+", message = "{validation.hankaku.number.message}")
	private String mobileTel3;

	@Email
	@Length(max = 255)
	private String email;

	private String applicationStatus;

	private String applicationComment;

	private Integer pageNo;

	private Integer pageCount;

	private Integer pageSize;
}
