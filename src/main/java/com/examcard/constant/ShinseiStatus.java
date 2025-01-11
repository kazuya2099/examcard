package com.examcard.constant;

public enum ShinseiStatus {

	APPLICATION("1"), REMAND("2"), APPROVAL("3"), CANCEL("4"), REJECTION("9");

	private String code;

	ShinseiStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static ShinseiStatus from(String code) {
		for (ShinseiStatus e : values()) {
			if (code.equals(e.getCode())) {
				return e;
			}
		}
		return null;
	}
}
