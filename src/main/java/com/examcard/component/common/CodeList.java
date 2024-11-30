package com.examcard.component.common;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class CodeList {

	@Getter
	private Map<String, String> setaiFamily;

	@Getter
	private Map<String, String> setaiStatus;

	@Getter
	private Map<String, String> setaiLoan;

	@Getter
	private Map<String, String> employmentStatus;

	@Getter
	private Map<String, String> companyIndustryType;

	@Getter
	private Map<String, String> applicationStatus;

	@Getter
	private Map<String, String> applicationStatusCr;

	public CodeList() {
		setaiFamily.put("", "");
		setaiFamily.put("1", "独身（家族別居）");
		setaiFamily.put("2", "独身（家族同居）");
		setaiFamily.put("3", "既婚");

		setaiStatus.put("", "");
		setaiStatus.put("1", "持家（自己所有）");
		setaiStatus.put("2", "持家（親族所有）");
		setaiStatus.put("3", "賃貸");

		setaiLoan.put("", "");
		setaiLoan.put("1", "あり");
		setaiLoan.put("2", "なし");

		employmentStatus.put("", "");
		employmentStatus.put("1", "会社員");
		employmentStatus.put("2", "自営業");

		companyIndustryType.put("", "");
		companyIndustryType.put("1", "情報通信業");
		companyIndustryType.put("2", "製造業");
		companyIndustryType.put("3", "建設");
		companyIndustryType.put("4", "飲食業");
		companyIndustryType.put("5", "小売り");
		companyIndustryType.put("6", "その他");

		applicationStatus.put("", "");
		applicationStatus.put("1", "申請中");
		applicationStatus.put("2", "差戻し");
		applicationStatus.put("3", "承認");
		applicationStatus.put("4", "取下");
		applicationStatus.put("9", "不可");

		applicationStatusCr.put("", "");
		applicationStatusCr.put("2", "差戻し");
		applicationStatusCr.put("3", "承認");
		applicationStatusCr.put("9", "不可");
	}
}
