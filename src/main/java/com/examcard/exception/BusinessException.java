package com.examcard.exception;

public class BusinessException extends RuntimeException {

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
	}

	/**
	 * Constructor for specify messages and exception.
	 * <p>
	 * Takes multiple {@code String} messages and cause of exception as argument.
	 * </p>
	 * @param messages {@link ResultMessages} instance
	 * @param cause {@link Throwable} instance
	 */
	public BusinessException(String messages, Throwable cause) {
		super(messages, cause);
	}
}
