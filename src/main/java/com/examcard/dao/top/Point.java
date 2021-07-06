package com.examcard.dao.top;

import java.util.Date;

import lombok.Data;

@Data
public class Point {

	private Integer point;
	private Integer futurePoint;
	private String userId;
	private Date startDate;
	private Date expiredDate;
	private Date systemDate;;
}
