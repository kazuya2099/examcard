package com.examcard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.examcard.component.common.CodeList;
import com.examcard.constant.CodeMapKey;

@Configuration
public class CodeListConfig {

	@Bean
	public CodeList codeList() {
		Map<String, String> setaiFamily = new HashMap<>();
		setaiFamily.put("", "");
		setaiFamily.put("1", "独身（家族別居）");
		setaiFamily.put("2", "独身（家族同居）");
		setaiFamily.put("3", "既婚");

		Map<String, String> setaiStatus = new HashMap<>();
		setaiStatus.put("", "");
		setaiStatus.put("1", "持家（自己所有）");
		setaiStatus.put("2", "持家（親族所有）");
		setaiStatus.put("3", "賃貸");

		Map<String, String> setaiLoan = new HashMap<>();
		setaiLoan.put("", "");
		setaiLoan.put("1", "あり");
		setaiLoan.put("2", "なし");

		Map<String, String> employmentStatus = new HashMap<>();
		employmentStatus.put("", "");
		employmentStatus.put("1", "会社員");
		employmentStatus.put("2", "自営業");

		Map<String, String> companyIndustryType = new HashMap<>();
		companyIndustryType.put("", "");
		companyIndustryType.put("1", "情報通信業");
		companyIndustryType.put("2", "製造業");
		companyIndustryType.put("3", "建設");
		companyIndustryType.put("4", "飲食業");
		companyIndustryType.put("5", "小売り");
		companyIndustryType.put("6", "その他");
		
		Map<String, String> applicationStatus = new HashMap<>();
		applicationStatus.put("", "");
		applicationStatus.put("1", "申請中");
		applicationStatus.put("2", "差戻し");
		applicationStatus.put("3", "承認");
		applicationStatus.put("4", "取下");
		applicationStatus.put("9", "不可");

		Map<String, String> applicationStatusCr = new HashMap<>();
		applicationStatusCr.put("", "");
		applicationStatusCr.put("2", "差戻し");
		applicationStatusCr.put("3", "承認");
		applicationStatusCr.put("9", "不可");
		
		CodeList codeList = CodeList.getInstance();
		Map<String, Map<String, String>> codeMap = new HashMap<>();
		codeMap.put(CodeMapKey.SETAI_FAMILY, setaiFamily);
		codeMap.put(CodeMapKey.SETAI_STATUS, setaiStatus);
		codeMap.put(CodeMapKey.SETAI_LOAN, setaiLoan);
		codeMap.put(CodeMapKey.EMPLOYMENT_STATUS, employmentStatus);
		codeMap.put(CodeMapKey.COMPANY_INDUSTRY_TYPE, companyIndustryType);
		codeMap.put(CodeMapKey.APPLICATION_STATUS, applicationStatus);
		codeMap.put(CodeMapKey.APPLICATION_STATUS_CR, applicationStatusCr);
		codeList.setCodeMap(codeMap);
		
		return codeList;
	}
}
