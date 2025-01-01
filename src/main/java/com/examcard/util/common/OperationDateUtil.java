package com.examcard.util.common;

import java.util.Date;

public abstract class OperationDateUtil {
	
	/** インスタンス生成防止 **/
	private OperationDateUtil() {}

	public static Date getDate() {
		return new Date();
	}
}
