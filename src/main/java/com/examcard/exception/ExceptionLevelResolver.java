package com.examcard.exception;

/**
 * Provides Functionality to determine the {@link ExceptionLevel} based on
 * the specified {@link Exception} instance <br>
 */
public interface ExceptionLevelResolver {

	/**
     * Determines the {@link ExceptionLevel} based on the instance of {@link Exception} <br>
     * passed as an argument <br>
     * @param ex Exception class
     * @return level of exception
     */
    ExceptionLevel resolveExceptionLevel(Exception ex);
}
