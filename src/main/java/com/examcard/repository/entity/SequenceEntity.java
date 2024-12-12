package com.examcard.repository.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SequenceEntity {

	private String tableName;
	private Integer id;
	private String paddingChar;
	private Integer length;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private Date deleteDate;
	private String deleteUser;
	private String deleteFlag;
}
