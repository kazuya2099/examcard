package com.examcard.repository.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UserCardEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cardName;
	private String cardNumber1;
	private String cardNumber2;
	private String cardNumber3;
	private String cardNumber4;
}
