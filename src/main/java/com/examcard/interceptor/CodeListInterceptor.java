package com.examcard.interceptor;

import java.util.Map.Entry;
import java.util.Set;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import com.examcard.component.common.CodeList;

import jakarta.servlet.http.HttpServletRequest;

public class CodeListInterceptor implements WebRequestInterceptor {

	private CodeList codeDefinition;

	public CodeListInterceptor(CodeList codeDefinition) {
		this.codeDefinition = codeDefinition;
	}

	@Override
	public void preHandle(WebRequest paramWebRequest) {
		ServletWebRequest servletWebRequest = (ServletWebRequest) paramWebRequest;
		HttpServletRequest request = servletWebRequest.getRequest();
		Set<Entry<String, String>> setaiFamilies = codeDefinition.getCodeSet("setaiFamily");
		Set<Entry<String, String>> setaiStatuses = codeDefinition.getCodeSet("setaiStatus");
		Set<Entry<String, String>> setaiLoans = codeDefinition.getCodeSet("setaiLoan");
		Set<Entry<String, String>> employmentStatuses = codeDefinition.getCodeSet("employmentStatus");
		Set<Entry<String, String>> companyIndustryTypes = codeDefinition.getCodeSet("companyIndustryType");
		request.setAttribute("setaiFamilies", setaiFamilies);
		request.setAttribute("setaiStatuses", setaiStatuses);
		request.setAttribute("setaiLoans", setaiLoans);
		request.setAttribute("employmentStatuses", employmentStatuses);
		request.setAttribute("companyIndustryTypes", companyIndustryTypes);
    }

	@Override
	public void postHandle(WebRequest paramWebRequest, ModelMap paramModelMap) throws Exception {
	}

	@Override
	public void afterCompletion(WebRequest paramWebRequest, Exception paramException) throws Exception {
	}
}
