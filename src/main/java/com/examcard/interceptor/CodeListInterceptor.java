package com.examcard.interceptor;

import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.examcard.component.common.CodeList;

public class CodeListInterceptor extends HandlerInterceptorAdapter {

	private CodeList codeDefinition;

	public CodeListInterceptor(CodeList codeDefinition) {
		this.codeDefinition = codeDefinition;
	}

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
        return true;
    }
}
