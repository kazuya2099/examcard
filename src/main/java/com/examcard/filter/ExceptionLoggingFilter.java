package com.examcard.filter;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import com.examcard.exception.ExceptionLogger;

import jakarta.servlet.ServletException;

public class ExceptionLoggingFilter extends GenericFilterBean {

	private ExceptionLogger exceptionLogger = null;

	public void setExceptionLogger(final ExceptionLogger exceptionLogger) {
		this.exceptionLogger = exceptionLogger;
	}

	protected ExceptionLogger getExceptionLogger() {
		return exceptionLogger;
	}

	@Override
	protected void initFilterBean() throws ServletException {
		if (exceptionLogger == null) {
			exceptionLogger = new ExceptionLogger(getClass().getName());
			exceptionLogger.afterPropertiesSet();
		}
	}

	@Override
	public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response,
			jakarta.servlet.FilterChain chain) throws IOException, jakarta.servlet.ServletException {
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			exceptionLogger.error(e);
			throw e;
		}
	}
}
