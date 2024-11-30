package com.examcard.exception;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class ExceptionLogger implements InitializingBean {

	/**
	* Logger for application log output.
	*/
	private final Logger applicationLogger;

	/**
	 * Logger for monitoring log output.
	 */
	private final Logger monitoringLogger;

	/**
	 * Logger for each log level.
	 */
	private final Map<ExceptionLevel, LogLevelWrappingLogger> exceptionLevelLoggers = new ConcurrentHashMap<ExceptionLevel, LogLevelWrappingLogger>();

	/**
	 * Logger that outputs log at INFO log level.
	 */
	private final InfoLogger infoLogger;

	/**
	 * Logger that outputs log at WARN log level.
	 */
	private final WarnLogger warnLogger;

	/**
	 * Logger that outputs log at ERROR log level.
	 */
	private final ErrorLogger errorLogger;

	/**
	 * Object that resolves exception code.
	 */
	private ExceptionCodeResolver exceptionCodeResolver = new SimpleMappingExceptionCodeResolver();

	/**
	 * Object that resolves exception level.
	 */
	private ExceptionLevelResolver exceptionLevelResolver;

	/**
	 * placeholder for exception code of log formatter.
	 */
	private String PLACEHOLDER_OF_EXCEPTION_CODE = "{0}";

	/**
	 * placeholder for exception message of log formatter.
	 */
	private String PLACEHOLDER_OF_EXCEPTION_MESSAGE = "{1}";

	/**
	 * Message formatter for log output.
	 */
	private String logMessageFormat = String.format("[%s] %s",
			PLACEHOLDER_OF_EXCEPTION_CODE, PLACEHOLDER_OF_EXCEPTION_MESSAGE);

	/**
	 * Default exception code in case it is not specified.
	 */
	private String defaultCode = "UNDEFINED-CODE";

	/**
	 * Default exception message in case it is not specified.
	 */
	private String defaultMessage = "UNDEFINED-MESSAGE";

	/**
	 * Log message trim flag.
	 */
	private boolean trimLogMessage = true;

	/**
	 * Logger suffix of monitoring log.
	 */
	private static final String MONITORING_LOG_LOGGER_SUFFIX = ".Monitoring";

	/**
	 * Default constructor.
	 * <p>
	 * {@link #ExceptionLogger(String)} is called with FQCN of this class as parameter.
	 * </p>
	 */
	public ExceptionLogger() {
		this(ExceptionLogger.class.getName());
	}

	public ExceptionLogger(String name) {
		this.applicationLogger = LoggerFactory.getLogger(name);
		this.monitoringLogger = LoggerFactory.getLogger(name + MONITORING_LOG_LOGGER_SUFFIX);
		this.infoLogger = new InfoLogger();
		this.warnLogger = new WarnLogger();
		this.errorLogger = new ErrorLogger();
	}

	public void setExceptionCodeResolver(ExceptionCodeResolver exceptionCodeResolver) {
		this.exceptionCodeResolver = exceptionCodeResolver;
	}

	public void setExceptionLevelResolver(ExceptionLevelResolver exceptionLevelResolver) {
		this.exceptionLevelResolver = exceptionLevelResolver;
	}

	public void setLogMessageFormat(String logMessageFormat) {
		this.logMessageFormat = logMessageFormat;
	}

	public void setTrimLogMessage(boolean trimLogMessage) {
		this.trimLogMessage = trimLogMessage;
	}

	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	/**
	 * Initializes the exception logger.
	 * <p>
	 * If exception resolution object is not set, use {@link org.terasoluna.gfw.common.exception.DefaultExceptionLevelResolver}.
	 * </p>
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() {
		validateLogMessageFormat(logMessageFormat);
		if (exceptionLevelResolver == null) {
			exceptionLevelResolver = new DefaultExceptionLevelResolver(exceptionCodeResolver);
		}
		registerExceptionLevelLoggers(ExceptionLevel.INFO, infoLogger);
		registerExceptionLevelLoggers(ExceptionLevel.WARN, warnLogger);
		registerExceptionLevelLoggers(ExceptionLevel.ERROR, errorLogger);
	}

	/**
	 * Output the log related to exception level.
	 * @param ex Exception
	 */
	public void log(Exception ex) {
		ExceptionLevel level = exceptionLevelResolver.resolveExceptionLevel(ex);
		LogLevelWrappingLogger logger = null;
		if (level != null) {
			logger = exceptionLevelLoggers.get(level);
		}
		if (logger == null) {
			logger = errorLogger;
		}
		log(ex, logger);
	}

	/**
	 * Output the information log.
	 * <p>
	 * Outputs INFO level log to application log and monitoring log.
	 * </p>
	 * @param ex Exception
	 */
	public void info(Exception ex) {
		log(ex, infoLogger);
	}

	/**
	 * Output WARN level log
	 * <p>
	 * Outputs WARN level log to application log and monitoring log.
	 * </p>
	 * @param ex Exception
	 */
	public void warn(Exception ex) {
		log(ex, warnLogger);
	}

	/**
	 * Ouputs ERROR log.
	 * <p>
	 * Outputs ERROR level log to application log and monitoring log.
	 * </p>
	 * @param ex Exception
	 */
	public void error(Exception ex) {
		log(ex, errorLogger);
	}

	protected void validateLogMessageFormat(String logMessageFormat) {
		if (logMessageFormat == null || !logMessageFormat.contains(PLACEHOLDER_OF_EXCEPTION_CODE)
				|| !logMessageFormat.contains(PLACEHOLDER_OF_EXCEPTION_MESSAGE)) {
			String message = "logMessageFormat must have placeholder({0} and {1})."
					+ " {0} is replaced with exception code."
					+ " {1} is replaced with exception message. current logMessageFormat is \""
					+ logMessageFormat + "\".";
			throw new IllegalArgumentException(message);
		}
	}

	protected String resolveExceptionCode(Exception ex) {
		String exceptionCode = null;
		if (exceptionCodeResolver != null) {
			exceptionCode = exceptionCodeResolver.resolveExceptionCode(ex);
		}
		return exceptionCode;
	}

	protected String makeLogMessage(Exception ex) {
		String exceptionCode = resolveExceptionCode(ex);
		return formatLogMessage(exceptionCode, ex.getMessage());
	}

	protected String formatLogMessage(String exceptionCode, String exceptionMessage) {
		String bindingExceptionCode = exceptionCode;
		String bindingExceptionMessage = exceptionMessage;
		if (StringUtils.isEmpty(bindingExceptionCode)) {
			bindingExceptionCode = defaultCode;
		}
		if (StringUtils.isEmpty(bindingExceptionMessage)) {
			bindingExceptionMessage = defaultMessage;
		}
		String message = MessageFormat.format(logMessageFormat, bindingExceptionCode, bindingExceptionMessage);
		if (trimLogMessage) {
			message = message.trim();
		}
		return message;
	}

	protected void registerExceptionLevelLoggers(ExceptionLevel level, LogLevelWrappingLogger logger) {
		this.exceptionLevelLoggers.put(level, logger);
	}

	protected Logger getApplicationLogger() {
		return applicationLogger;
	}

	protected Logger getMonitoringLogger() {
		return monitoringLogger;
	}

	private void log(Exception ex, LogLevelWrappingLogger logger) {
		if (!logger.isEnabled()) {
			return;
		}
		String logMessage = makeLogMessage(ex);
		logger.log(logMessage, ex);
	}

	/**
	 * Logger instance that wraps the log level.
	 */
	protected interface LogLevelWrappingLogger {
		/**
		 * Determines if the logger is valid.
		 * @return Returns <code>true</code> if valid.
		 */
		boolean isEnabled();

		/**
		 * Outputs the log.
		 * @param logMessage log message
		 * @param ex Exception
		 */
		void log(String logMessage, Exception ex);
	}

	/**
	 * Wrapper logger for output of INFO level of log.
	 */
	private final class InfoLogger implements LogLevelWrappingLogger {
		/**
		 * Checks whether Info logging is enabled in either monitoring log or application log
		 * @see org.terasoluna.gfw.common.exception.ExceptionLogger.LogLevelWrappingLogger#isEnabled()
		 */
		@Override
		public boolean isEnabled() {
			return monitoringLogger.isInfoEnabled() || applicationLogger.isInfoEnabled();
		}

		/**
		 * Logs messages of Info level.
		 * <p>
		 * Logs messages of Info level in Monitoring log and Application log if Info logging in these loggers are enabled.
		 * </p>
		 * @see org.terasoluna.gfw.common.exception.ExceptionLogger.LogLevelWrappingLogger#log(java.lang.String,
		 *      java.lang.Exception)
		 */
		@Override
		public void log(String logMessage, Exception ex) {
			if (monitoringLogger.isInfoEnabled()) {
				monitoringLogger.info(logMessage);
			}
			if (applicationLogger.isInfoEnabled()) {
				applicationLogger.info(logMessage, ex);
			}
		}
	}

	/**
	 * Wrapper logger for output of WARN level of log.
	 */
	private final class WarnLogger implements LogLevelWrappingLogger {
		/**
		 * Checks whether Warn logging is enabled in either monitoring log or application log
		 * @see org.terasoluna.gfw.common.exception.ExceptionLogger.LogLevelWrappingLogger#isEnabled()
		 */
		@Override
		public boolean isEnabled() {
			return monitoringLogger.isWarnEnabled() || applicationLogger
					.isWarnEnabled();
		}

		/**
		 * Logs messages of Warn level.
		 * <p>
		 * Logs messages of Warn level in Monitoring log and Application log if Warn logging in these loggers are enabled.
		 * </p>
		 * @see org.terasoluna.gfw.common.exception.ExceptionLogger.LogLevelWrappingLogger#log(java.lang.String,
		 *      java.lang.Exception)
		 */
		@Override
		public void log(String logMessage, Exception ex) {
			if (monitoringLogger.isWarnEnabled()) {
				monitoringLogger.warn(logMessage);
			}
			if (applicationLogger.isWarnEnabled()) {
				applicationLogger.warn(logMessage, ex);
			}
		}
	}

	/**
	 * Wrapper logger for output of ERROR level of log.
	 */
	private final class ErrorLogger implements LogLevelWrappingLogger {
		/**
		 * Checks whether Error logging is enabled in either monitoring log or application log
		 * @see org.terasoluna.gfw.common.exception.ExceptionLogger.LogLevelWrappingLogger#isEnabled()
		 */
		@Override
		public boolean isEnabled() {
			return monitoringLogger.isErrorEnabled() || applicationLogger
					.isErrorEnabled();
		}

		/**
		 * Logs messages of Error level.
		 * <p>
		 * Logs messages of Error level in Monitoring log and Application log if error logging in these loggers are enabled.
		 * </p>
		 * @see org.terasoluna.gfw.common.exception.ExceptionLogger.LogLevelWrappingLogger#log(java.lang.String,
		 *      java.lang.Exception)
		 */
		@Override
		public void log(String logMessage, Exception ex) {
			if (monitoringLogger.isErrorEnabled()) {
				monitoringLogger.error(logMessage);
			}
			if (applicationLogger.isErrorEnabled()) {
				applicationLogger.error(logMessage, ex);
			}
		}
	}
}
