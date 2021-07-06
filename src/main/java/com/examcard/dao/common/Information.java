package com.examcard.dao.common;

import java.util.Date;

import lombok.Data;

@Data
public class Information {

	private long id;
	private String message;
	private Date startDate;
	private Date endDate;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private Date deleteDate;
	private String deleteUser;
	private String deleteFlag;
}
