package com.examcard.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TraceLoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Log logger = LogFactory.getLog(TraceLoggingInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String methodName = getMethodName(handler);
		logger.info(methodName + " : 開始");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) {
		String methodName = getMethodName(handler);
		logger.info(methodName + " : 終了");
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
