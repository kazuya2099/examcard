package com.examcard.dto.customer.sales;

import java.util.Date;

import lombok.Data;

@Data
public class UserCardDto {

	private String userId;
	private String cardId;
	private String cardName;
	private String brandId;
	private String brandName;
	private String cardNumber1;
	private String cardNumber2;
	private String cardNumber3;
	private String cardNumber4;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private Date deleteDate;
	private String deleteUser;
	private String deleteFlag;
}
