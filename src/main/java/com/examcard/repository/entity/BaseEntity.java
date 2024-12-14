package com.examcard.repository.entity;

import lombok.Data;

@Data
public abstract class BaseEntity {
	private String deleteFlag;
	private String createUser;
	private String createTimestamp;
	private String updateUser;
	private String updateTimestamp;
	private String deleteUser;
	private String deleteTimestamp;
}
