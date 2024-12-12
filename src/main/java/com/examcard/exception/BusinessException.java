package com.examcard.exception;

import org.jboss.logging.Logger;

public class BusinessException extends RuntimeException {

	Logger logger = Logger.getLogger(BusinessException.class);
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for specify a message.
	 * <p>
	 * generate a {@link ResultMessages} instance of error type and add a message.
	 * </p>
	 * @param message result message
	 */
	public BusinessException(String message) {
		super(message);
		logger.warn(message);
	}

	/**
	 * Constructor for specify messages and exception.
	 * <p>
	 * Takes multiple {@code String} messages and cause of exception as argument.
	 * </p>
	 * @param message {@link ResultMessages} instance
	 * @param cause {@link Throwable} instance
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		logger.warn(message, cause);
	}
}
