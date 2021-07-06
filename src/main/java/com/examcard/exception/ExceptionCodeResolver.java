package com.examcard.exception;

/**
 * Provides the functionality to determine {@link ExceptionCodeProvider} based on <br>
 * Exception object
 */
public interface ExceptionCodeResolver {

    /**
     * Determines exception code.
     * @param ex Exception
     * @return Exception code based on Exception object
     */
    String resolveExceptionCode(Exception ex);
}
