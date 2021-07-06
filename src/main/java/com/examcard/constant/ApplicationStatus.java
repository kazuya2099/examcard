package com.examcard.constant;

public enum ApplicationStatus {

	APPLICATION("1"), REMAND("2"), APPROVAL("3"), CANCEL("4"), REJECTION("9");
	
	private String code;
	
	ApplicationStatus(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static ApplicationStatus from(String code) {
		for (ApplicationStatus e : values()) {
			if (code.equals(e.getCode())) {
				return e;
			}
		}
		return null;
	}
}
