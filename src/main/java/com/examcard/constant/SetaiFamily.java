package com.examcard.constant;

public enum SetaiFamily {

	DOKUSHIN_BEKKYO("1", "独身（家族別居）"),
	DOKUSHIN_DOUKYO("2", "独身（家族同居）"),
	KIKON("3", "既婚");
	
	private String code;
	private String value;
	
	private SetaiFamily(String code, String value) {
		this.code = code;
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getValue() {
		return value;
	}
	
	public SetaiFamily from(String code) {
		for (SetaiFamily e : SetaiFamily.values()) {
			if (this.code.equals(e.code)) {
				return e;
			}
		}
		return null;
	}
}
