package com.examcard.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.examcard.exception.ExceptionLogger;

public class ExceptionLoggingFilter extends GenericFilterBean {

	/**
	 * Logger object for exception output.
	 */
	private ExceptionLogger exceptionLogger = null;

	/**
	 * Sets logger object for exception output
	 * <p>
	 * If not set, default logger object for exception output is used. <br>
	 * </p>
	 * @param exceptionLogger any exception logger.
	 */
	public void setExceptionLogger(final ExceptionLogger exceptionLogger) {
		this.exceptionLogger = exceptionLogger;
	}

	/**
	 * Executes next filter. logs exception if exception is occurred.
	 * @param servletRequest {@link ServletRequest}
	 * @param servletResponse {@link ServletResponse}
	 * @param filterChain {@link FilterChain}
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
	 *      javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			filterChain.doFilter(servletRequest, servletResponse);
		} catch (IOException e) {
			logIOException(e, servletRequest, servletResponse);
			throw e;
		} catch (ServletException e) {
			logServletException(e, servletRequest, servletResponse);
			throw e;
		} catch (RuntimeException e) {
			logRuntimeException(e, servletRequest, servletResponse);
			throw e;
		}
	}

	/**
	 * Initializes the exception filter.
	 * <p>
	 * If exception logger object is not set, use {@link org.terasoluna.gfw.common.exception.ExceptionLogger}.
	 * </p>
	 * <p>
	 * default exception logger's name is 'org.terasoluna.gfw.web.exception.ExceptionLoggingFilter'<br>
	 * (this interceptor's class name).
	 * </p>
	 * @see org.springframework.web.filter.GenericFilterBean#initFilterBean()
	 */
	@Override
	protected void initFilterBean() throws ServletException {
		if (exceptionLogger == null) {
			exceptionLogger = new ExceptionLogger(getClass().getName());
			exceptionLogger.afterPropertiesSet();
		}
	}

	/**
	 * Logs IOException.
	 * @param ex Exception
	 * @param request HTTP servlet request
	 * @param response HTTP servlet response
	 */
	protected void logIOException(IOException ex, ServletRequest request, ServletResponse response) {
		exceptionLogger.error(ex);
	}

	/**
	 * Logs ServletException
	 * @param ex Exception
	 * @param request HTTP servlet request
	 * @param response HTTP servlet response
	 */
	protected void logServletException(ServletException ex, ServletRequest request, ServletResponse response) {
		exceptionLogger.error(ex);
	}

	/**
	 * Logs RuntimeException
	 * @param ex Exception
	 * @param request HTTP servlet request
	 * @param response HTTP servlet response
	 */
	protected void logRuntimeException(RuntimeException ex, ServletRequest request, ServletResponse response) {
		exceptionLogger.error(ex);
	}

	/**
	 * Fetches logger object that outputs exception
	 * @return logger object that outputs exception
	 */
	protected ExceptionLogger getExceptionLogger() {
		return exceptionLogger;
	}
}
