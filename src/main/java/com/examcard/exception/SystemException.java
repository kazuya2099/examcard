package com.examcard.exception;

/**
 * Exception to indicate that it has detected a condition that should not occur when the system is running normally.<br>
 * <p>
 * System exception is to be thrown if something that must exist, is not there (like file, directory, master data etc)
 * </p>
 */
public class SystemException extends RuntimeException implements ExceptionCodeProvider {

	private static final long serialVersionUID = 1L;

	/**
	 * exception code.
	 */
	private final String code;

	/**
	 * Constructor<br>
	 * <p>
	 * {@link ExceptionCodeProvider}, message to be displayed and underlying cause of exception can be specified.
	 * </p>
	 * @param code ExceptionCode {@link ExceptionCodeProvider}
	 * @param message message to be displayed
	 * @param cause underlying cause of exception
	 */
	public SystemException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	/**
	 * Constructor<br>
	 * <p>
	 * {@link ExceptionCodeProvider}, message to be displayed can be specified.
	 * </p>
	 * @param code ExceptionCode {@link ExceptionCodeProvider}
	 * @param message message to be displayed
	 */
	public SystemException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * Constructor<br>
	 * <p>
	 * {@link ExceptionCodeProvider} and underlying cause of exception can be specified.
	 * </p>
	 * @param code ExceptionCode {@link ExceptionCodeProvider}
	 * @param cause underlying cause of exception
	 */
	public SystemException(String code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	/**
	 * Returns the {@link ExceptionCodeProvider}
	 * @see org.terasoluna.gfw.common.exception.ExceptionCodeProvider#getCode()
	 */
	@Override
	public String getCode() {
		return code;
	}
}
