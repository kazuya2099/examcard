package com.examcard.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class ParameterLoggingInterceptor implements WebRequestInterceptor {

	private static final Log logger = LogFactory.getLog(ParameterLoggingInterceptor.class);

	@SuppressWarnings("null")
	@Override
	public void preHandle(WebRequest paramWebRequest) {
		List<String> params = new ArrayList<>();
		Map<String, String[]> parameterMap = paramWebRequest.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			String[] values = entry.getValue();
			StringJoiner join = new StringJoiner(",");
			if (values != null) {
				Arrays.stream(values).forEach(join::add);
			}
			params.add(entry.getKey() + "=" + join.toString());
		}

		StringJoiner join = new StringJoiner(", ", "[", "]");
		params.forEach(join::add);
		logger.info(join.toString());
	}

	@SuppressWarnings("null")
	@Override
	public void postHandle(WebRequest paramWebRequest, ModelMap paramModelMap) throws Exception {
		// 未使用
	}

	@SuppressWarnings("null")
	@Override
	public void afterCompletion(WebRequest paramWebRequest, Exception paramException) throws Exception {
		// 未使用
	}
}
