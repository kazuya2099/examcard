package com.examcard.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ParameterLoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Log logger = LogFactory.getLog(ParameterLoggingInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		List<String> params = new ArrayList<>();
		Map<String, String[]> parameterMap = request.getParameterMap();
		for(Entry<String, String[]> entry : parameterMap.entrySet()) {
			String[] values = entry.getValue();
			StringJoiner join = new StringJoiner(",");
			if (values != null) {
				Arrays.stream(values).forEach(join::add);
			}
			params.add(entry.getKey() + "=" + join.toString());
		}
		
		StringJoiner join = new StringJoiner(", ", "[", "]");
		params.forEach(e -> join.add(e));
		logger.info(join.toString());
		return true;
	}
}
