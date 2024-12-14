package com.examcard.repository.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class InformationEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
