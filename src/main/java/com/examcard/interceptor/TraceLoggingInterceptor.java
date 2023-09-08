package com.examcard.interceptor;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.method.HandlerMethod;

public class TraceLoggingInterceptor implements WebRequestInterceptor {

	private static final Log logger = LogFactory.getLog(TraceLoggingInterceptor.class);
	
	@Override
	public void preHandle(WebRequest paramWebRequest) throws Exception {
		String methodName = getMethodName(paramWebRequest);
		logger.info(methodName + " : 開始");
	}
	
	@Override
	public void postHandle(WebRequest paramWebRequest, ModelMap paramModelMap) throws Exception {
		String methodName = getMethodName(paramWebRequest);
		logger.info(methodName + " : 終了");
	}
	
	@Override
	public void afterCompletion(WebRequest paramWebRequest, Exception paramException) throws Exception {
	}

	private String getMethodName(Object handler) {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Class<?> clazz = method.getDeclaringClass();
			return clazz.getName() + "#" + method.getName();
		} else {
			return handler.getClass().getName();
		}
	}
}
