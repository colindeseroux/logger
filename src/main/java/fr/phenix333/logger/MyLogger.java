package fr.phenix333.logger;

import java.io.Serializable;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;

/**
 * Custom Logger interface with convenience methods for the FATAL, ERROR, WARN,
 * INFO, DEBUG and FUNCTION custom log levels.
 * 
 * @author Colin de Seroux
 */
public final class MyLogger implements Serializable {

	private static final long serialVersionUID = 59421658641800L;
	private final ExtendedLoggerWrapper logger;

	private static final String FQCN = MyLogger.class.getName();
	private static final Level FATAL = Level.forName("FATAL", 100);
	private static final Level ERROR = Level.forName("ERROR", 200);
	private static final Level WARN = Level.forName("WARN", 300);
	private static final Level INFO = Level.forName("INFO", 400);
	private static final Level DEBUG = Level.forName("DEBUG", 500);
	private static final Level FUNCTION = Level.forName("FUNCTION", 550);

	private MyLogger(final Logger logger) {
		this.logger = new ExtendedLoggerWrapper((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
	}

	/**
	 * Returns a custom Logger with the name of the calling class.
	 * 
	 * @return The custom Logger for the calling class.
	 */
	public static MyLogger create() {
		final Logger wrapped = LogManager.getLogger();
		return new MyLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified name of the Class as the
	 * Logger name.
	 * 
	 * @param loggerName The Class whose name should be used as the Logger name. If
	 *                   null it will default to the calling class.
	 * @return The custom Logger.
	 */
	public static MyLogger create(final Class<?> loggerName) {
		final Logger wrapped = LogManager.getLogger(loggerName);
		return new MyLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified name of the Class as the
	 * Logger name.
	 * 
	 * @param loggerName     The Class whose name should be used as the Logger name.
	 *                       If null it will default to the calling class.
	 * @param messageFactory The message factory is used only when creating a
	 *                       logger, subsequent use does not change the logger but
	 *                       will log a warning if mismatched.
	 * @return The custom Logger.
	 */
	public static MyLogger create(final Class<?> loggerName, final MessageFactory factory) {
		final Logger wrapped = LogManager.getLogger(loggerName, factory);
		return new MyLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified class name of the value as
	 * the Logger name.
	 * 
	 * @param value The value whose class name should be used as the Logger name. If
	 *              null the name of the calling class will be used as the logger
	 *              name.
	 * @return The custom Logger.
	 */
	public static MyLogger create(final Object value) {
		final Logger wrapped = LogManager.getLogger(value);
		return new MyLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified class name of the value as
	 * the Logger name.
	 * 
	 * @param value          The value whose class name should be used as the Logger
	 *                       name. If null the name of the calling class will be
	 *                       used as the logger name.
	 * @param messageFactory The message factory is used only when creating a
	 *                       logger, subsequent use does not change the logger but
	 *                       will log a warning if mismatched.
	 * @return The custom Logger.
	 */
	public static MyLogger create(final Object value, final MessageFactory factory) {
		final Logger wrapped = LogManager.getLogger(value, factory);
		return new MyLogger(wrapped);
	}

	/**
	 * Returns a custom Logger with the specified name.
	 * 
	 * @param name The logger name. If null the name of the calling class will be
	 *             used.
	 * @return The custom Logger.
	 */
	public static MyLogger create(final String name) {
		final Logger wrapped = LogManager.getLogger(name);
		return new MyLogger(wrapped);
	}

	/**
	 * Returns a custom Logger with the specified name.
	 * 
	 * @param name           The logger name. If null the name of the calling class
	 *                       will be used.
	 * @param messageFactory The message factory is used only when creating a
	 *                       logger, subsequent use does not change the logger but
	 *                       will log a warning if mismatched.
	 * @return The custom Logger.
	 */
	public static MyLogger create(final String name, final MessageFactory factory) {
		final Logger wrapped = LogManager.getLogger(name, factory);
		return new MyLogger(wrapped);
	}

	/**
	 * Logs a message with the specific Marker at the {@code FATAL} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 */
	public void fatal(final Marker marker, final Message msg) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, msg, (Throwable) null);
	}

	/**
	 * Logs a message with the specific Marker at the {@code FATAL} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 * @param t      A Throwable or null.
	 */
	public void fatal(final Marker marker, final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, msg, t);
	}

	/**
	 * Logs a message object with the {@code FATAL} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void fatal(final Marker marker, final Object message) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code FATAL} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void fatal(final Marker marker, final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, message, t);
	}

	/**
	 * Logs a message object with the {@code FATAL} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void fatal(final Marker marker, final String message) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code FATAL} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void fatal(final Marker marker, final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, message, params);
	}

	/**
	 * Logs a message at the {@code FATAL} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void fatal(final Marker marker, final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, message, t);
	}

	/**
	 * Logs the specified Message at the {@code FATAL} level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void fatal(final Message msg) {
		this.logger.logIfEnabled(FQCN, FATAL, null, msg, (Throwable) null);
	}

	/**
	 * Logs the specified Message at the {@code FATAL} level.
	 * 
	 * @param msg the message string to be logged
	 * @param t   A Throwable or null.
	 */
	public void fatal(final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, null, msg, t);
	}

	/**
	 * Logs a message object with the {@code FATAL} level.
	 * 
	 * @param message the message object to log.
	 */
	public void fatal(final Object message) {
		this.logger.logIfEnabled(FQCN, FATAL, null, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code FATAL} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void fatal(final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, null, message, t);
	}

	/**
	 * Logs a message object with the {@code FATAL} level.
	 * 
	 * @param message the message object to log.
	 */
	public void fatal(final String message) {
		this.logger.logIfEnabled(FQCN, FATAL, null, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code FATAL} level.
	 * 
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void fatal(final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, FATAL, null, message, params);
	}

	/**
	 * Logs a message at the {@code FATAL} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void fatal(final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, null, message, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FATAL}level.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void fatal(final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, FATAL, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FATAL} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void fatal(final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, null, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FATAL} level with the specified Marker.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void fatal(final Marker marker, final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code FATAL} level.
	 *
	 * @param marker         the marker data specific to this log statement
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void fatal(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, message, paramSuppliers);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FATAL} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void fatal(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, msgSupplier, t);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code FATAL} level.
	 *
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void fatal(final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, FATAL, null, message, paramSuppliers);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FATAL} level with the specified Marker. The {@code MessageSupplier}
	 * may or may not use the {@link MessageFactory} to construct the
	 * {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void fatal(final Marker marker, final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FATAL} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter. The
	 * {@code MessageSupplier} may or may not use the {@link MessageFactory} to
	 * construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void fatal(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, marker, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FATAL} level. The {@code MessageSupplier} may or may not use the
	 * {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void fatal(final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, FATAL, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FATAL} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter. The {@code MessageSupplier} may or may
	 * not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void fatal(final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FATAL, null, msgSupplier, t);
	}

	/**
	 * Logs a message with the specific Marker at the {@code ERROR} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 */
	public void error(final Marker marker, final Message msg) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, msg, (Throwable) null);
	}

	/**
	 * Logs a message with the specific Marker at the {@code ERROR} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 * @param t      A Throwable or null.
	 */
	public void error(final Marker marker, final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, msg, t);
	}

	/**
	 * Logs a message object with the {@code ERROR} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void error(final Marker marker, final Object message) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code ERROR} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void error(final Marker marker, final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, message, t);
	}

	/**
	 * Logs a message object with the {@code ERROR} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void error(final Marker marker, final String message) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code ERROR} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void error(final Marker marker, final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, message, params);
	}

	/**
	 * Logs a message at the {@code ERROR} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void error(final Marker marker, final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, message, t);
	}

	/**
	 * Logs the specified Message at the {@code ERROR} level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void error(final Message msg) {
		this.logger.logIfEnabled(FQCN, ERROR, null, msg, (Throwable) null);
	}

	/**
	 * Logs the specified Message at the {@code ERROR} level.
	 * 
	 * @param msg the message string to be logged
	 * @param t   A Throwable or null.
	 */
	public void error(final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, null, msg, t);
	}

	/**
	 * Logs a message object with the {@code ERROR} level.
	 * 
	 * @param message the message object to log.
	 */
	public void error(final Object message) {
		this.logger.logIfEnabled(FQCN, ERROR, null, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code ERROR} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void error(final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, null, message, t);
	}

	/**
	 * Logs a message object with the {@code ERROR} level.
	 * 
	 * @param message the message object to log.
	 */
	public void error(final String message) {
		this.logger.logIfEnabled(FQCN, ERROR, null, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code ERROR} level.
	 * 
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void error(final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, ERROR, null, message, params);
	}

	/**
	 * Logs a message at the {@code ERROR} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void error(final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, null, message, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code ERROR}level.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void error(final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, ERROR, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code ERROR} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void error(final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, null, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code ERROR} level with the specified Marker.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void error(final Marker marker, final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code ERROR} level.
	 *
	 * @param marker         the marker data specific to this log statement
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void error(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, message, paramSuppliers);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code ERROR} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void error(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, msgSupplier, t);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code ERROR} level.
	 *
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void error(final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, ERROR, null, message, paramSuppliers);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code ERROR} level with the specified Marker. The {@code MessageSupplier}
	 * may or may not use the {@link MessageFactory} to construct the
	 * {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void error(final Marker marker, final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code ERROR} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter. The
	 * {@code MessageSupplier} may or may not use the {@link MessageFactory} to
	 * construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void error(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, marker, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code ERROR} level. The {@code MessageSupplier} may or may not use the
	 * {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void error(final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, ERROR, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code ERROR} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter. The {@code MessageSupplier} may or may
	 * not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void error(final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, ERROR, null, msgSupplier, t);
	}

	/**
	 * Logs a message with the specific Marker at the {@code WARN} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 */
	public void warn(final Marker marker, final Message msg) {
		this.logger.logIfEnabled(FQCN, WARN, marker, msg, (Throwable) null);
	}

	/**
	 * Logs a message with the specific Marker at the {@code WARN} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 * @param t      A Throwable or null.
	 */
	public void warn(final Marker marker, final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, marker, msg, t);
	}

	/**
	 * Logs a message object with the {@code WARN} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void warn(final Marker marker, final Object message) {
		this.logger.logIfEnabled(FQCN, WARN, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code WARN} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void warn(final Marker marker, final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, marker, message, t);
	}

	/**
	 * Logs a message object with the {@code WARN} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void warn(final Marker marker, final String message) {
		this.logger.logIfEnabled(FQCN, WARN, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code WARN} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void warn(final Marker marker, final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, WARN, marker, message, params);
	}

	/**
	 * Logs a message at the {@code WARN} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void warn(final Marker marker, final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, marker, message, t);
	}

	/**
	 * Logs the specified Message at the {@code WARN} level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void warn(final Message msg) {
		this.logger.logIfEnabled(FQCN, WARN, null, msg, (Throwable) null);
	}

	/**
	 * Logs the specified Message at the {@code WARN} level.
	 * 
	 * @param msg the message string to be logged
	 * @param t   A Throwable or null.
	 */
	public void warn(final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, null, msg, t);
	}

	/**
	 * Logs a message object with the {@code WARN} level.
	 * 
	 * @param message the message object to log.
	 */
	public void warn(final Object message) {
		this.logger.logIfEnabled(FQCN, WARN, null, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code WARN} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void warn(final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, null, message, t);
	}

	/**
	 * Logs a message object with the {@code WARN} level.
	 * 
	 * @param message the message object to log.
	 */
	public void warn(final String message) {
		this.logger.logIfEnabled(FQCN, WARN, null, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code WARN} level.
	 * 
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void warn(final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, WARN, null, message, params);
	}

	/**
	 * Logs a message at the {@code WARN} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void warn(final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, null, message, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code WARN}level.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void warn(final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, WARN, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code WARN} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void warn(final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, null, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code WARN} level with the specified Marker.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void warn(final Marker marker, final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, WARN, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code WARN} level.
	 *
	 * @param marker         the marker data specific to this log statement
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void warn(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, WARN, marker, message, paramSuppliers);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code WARN} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void warn(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, marker, msgSupplier, t);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code WARN} level.
	 *
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void warn(final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, WARN, null, message, paramSuppliers);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code WARN} level with the specified Marker. The {@code MessageSupplier} may
	 * or may not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void warn(final Marker marker, final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, WARN, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code WARN} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter. The
	 * {@code MessageSupplier} may or may not use the {@link MessageFactory} to
	 * construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void warn(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, marker, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code WARN} level. The {@code MessageSupplier} may or may not use the
	 * {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void warn(final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, WARN, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code WARN} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter. The {@code MessageSupplier} may or may
	 * not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void warn(final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, WARN, null, msgSupplier, t);
	}

	/**
	 * Logs a message with the specific Marker at the {@code INFO} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 */
	public void info(final Marker marker, final Message msg) {
		this.logger.logIfEnabled(FQCN, INFO, marker, msg, (Throwable) null);
	}

	/**
	 * Logs a message with the specific Marker at the {@code INFO} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 * @param t      A Throwable or null.
	 */
	public void info(final Marker marker, final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, marker, msg, t);
	}

	/**
	 * Logs a message object with the {@code INFO} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void info(final Marker marker, final Object message) {
		this.logger.logIfEnabled(FQCN, INFO, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code INFO} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void info(final Marker marker, final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, marker, message, t);
	}

	/**
	 * Logs a message object with the {@code INFO} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void info(final Marker marker, final String message) {
		this.logger.logIfEnabled(FQCN, INFO, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code INFO} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void info(final Marker marker, final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, INFO, marker, message, params);
	}

	/**
	 * Logs a message at the {@code INFO} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void info(final Marker marker, final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, marker, message, t);
	}

	/**
	 * Logs the specified Message at the {@code INFO} level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void info(final Message msg) {
		this.logger.logIfEnabled(FQCN, INFO, null, msg, (Throwable) null);
	}

	/**
	 * Logs the specified Message at the {@code INFO} level.
	 * 
	 * @param msg the message string to be logged
	 * @param t   A Throwable or null.
	 */
	public void info(final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, null, msg, t);
	}

	/**
	 * Logs a message object with the {@code INFO} level.
	 * 
	 * @param message the message object to log.
	 */
	public void info(final Object message) {
		this.logger.logIfEnabled(FQCN, INFO, null, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code INFO} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void info(final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, null, message, t);
	}

	/**
	 * Logs a message object with the {@code INFO} level.
	 * 
	 * @param message the message object to log.
	 */
	public void info(final String message) {
		this.logger.logIfEnabled(FQCN, INFO, null, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code INFO} level.
	 * 
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void info(final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, INFO, null, message, params);
	}

	/**
	 * Logs a message at the {@code INFO} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void info(final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, null, message, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code INFO}level.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void info(final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, INFO, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code INFO} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void info(final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, null, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code INFO} level with the specified Marker.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void info(final Marker marker, final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, INFO, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code INFO} level.
	 *
	 * @param marker         the marker data specific to this log statement
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void info(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, INFO, marker, message, paramSuppliers);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code INFO} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void info(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, marker, msgSupplier, t);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code INFO} level.
	 *
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void info(final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, INFO, null, message, paramSuppliers);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code INFO} level with the specified Marker. The {@code MessageSupplier} may
	 * or may not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void info(final Marker marker, final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, INFO, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code INFO} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter. The
	 * {@code MessageSupplier} may or may not use the {@link MessageFactory} to
	 * construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void info(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, marker, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code INFO} level. The {@code MessageSupplier} may or may not use the
	 * {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void info(final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, INFO, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code INFO} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter. The {@code MessageSupplier} may or may
	 * not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void info(final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, INFO, null, msgSupplier, t);
	}

	/**
	 * Logs a message with the specific Marker at the {@code DEBUG} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 */
	public void debug(final Marker marker, final Message msg) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, msg, (Throwable) null);
	}

	/**
	 * Logs a message with the specific Marker at the {@code DEBUG} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 * @param t      A Throwable or null.
	 */
	public void debug(final Marker marker, final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, msg, t);
	}

	/**
	 * Logs a message object with the {@code DEBUG} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void debug(final Marker marker, final Object message) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code DEBUG} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void debug(final Marker marker, final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, message, t);
	}

	/**
	 * Logs a message object with the {@code DEBUG} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void debug(final Marker marker, final String message) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code DEBUG} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void debug(final Marker marker, final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, message, params);
	}

	/**
	 * Logs a message at the {@code DEBUG} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void debug(final Marker marker, final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, message, t);
	}

	/**
	 * Logs the specified Message at the {@code DEBUG} level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void debug(final Message msg) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, msg, (Throwable) null);
	}

	/**
	 * Logs the specified Message at the {@code DEBUG} level.
	 * 
	 * @param msg the message string to be logged
	 * @param t   A Throwable or null.
	 */
	public void debug(final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, msg, t);
	}

	/**
	 * Logs a message object with the {@code DEBUG} level.
	 * 
	 * @param message the message object to log.
	 */
	public void debug(final Object message) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code DEBUG} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void debug(final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, message, t);
	}

	/**
	 * Logs a message object with the {@code DEBUG} level.
	 * 
	 * @param message the message object to log.
	 */
	public void debug(final String message) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code DEBUG} level.
	 * 
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void debug(final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, message, params);
	}

	/**
	 * Logs a message at the {@code DEBUG} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void debug(final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, message, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code DEBUG}level.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void debug(final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code DEBUG} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void debug(final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code DEBUG} level with the specified Marker.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void debug(final Marker marker, final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code DEBUG} level.
	 *
	 * @param marker         the marker data specific to this log statement
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void debug(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, message, paramSuppliers);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code DEBUG} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void debug(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, msgSupplier, t);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code DEBUG} level.
	 *
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void debug(final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, message, paramSuppliers);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code DEBUG} level with the specified Marker. The {@code MessageSupplier}
	 * may or may not use the {@link MessageFactory} to construct the
	 * {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void debug(final Marker marker, final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code DEBUG} level) with the specified Marker and including the stack trace
	 * of the {@link Throwable} <code>t</code> passed as parameter. The
	 * {@code MessageSupplier} may or may not use the {@link MessageFactory} to
	 * construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void debug(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, marker, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code DEBUG} level. The {@code MessageSupplier} may or may not use the
	 * {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void debug(final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code DEBUG} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter. The {@code MessageSupplier} may or may
	 * not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void debug(final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, DEBUG, null, msgSupplier, t);
	}

	/**
	 * Logs a message with the specific Marker at the {@code FUNCTION} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 */
	public void function(final Marker marker, final Message msg) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, msg, (Throwable) null);
	}

	/**
	 * Logs a message with the specific Marker at the {@code FUNCTION} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 * @param t      A Throwable or null.
	 */
	public void function(final Marker marker, final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, msg, t);
	}

	/**
	 * Logs a message object with the {@code FUNCTION} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void function(final Marker marker, final Object message) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code FUNCTION} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void function(final Marker marker, final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, message, t);
	}

	/**
	 * Logs a message object with the {@code FUNCTION} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message object to log.
	 */
	public void function(final Marker marker, final String message) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code FUNCTION} level.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void function(final Marker marker, final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, message, params);
	}

	/**
	 * Logs a message at the {@code FUNCTION} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param marker  the marker data specific to this log statement
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void function(final Marker marker, final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, message, t);
	}

	/**
	 * Logs the specified Message at the {@code FUNCTION} level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void function(final Message msg) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, msg, (Throwable) null);
	}

	/**
	 * Logs the specified Message at the {@code FUNCTION} level.
	 * 
	 * @param msg the message string to be logged
	 * @param t   A Throwable or null.
	 */
	public void function(final Message msg, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, msg, t);
	}

	/**
	 * Logs a message object with the {@code FUNCTION} level.
	 * 
	 * @param message the message object to log.
	 */
	public void function(final Object message) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, message, (Throwable) null);
	}

	/**
	 * Logs a message at the {@code FUNCTION} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void function(final Object message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, message, t);
	}

	/**
	 * Logs a message object with the {@code FUNCTION} level.
	 * 
	 * @param message the message object to log.
	 */
	public void function(final String message) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, message, (Throwable) null);
	}

	/**
	 * Logs a message with parameters at the {@code FUNCTION} level.
	 * 
	 * @param message the message to log; the format depends on the message factory.
	 * @param params  parameters to the message.
	 * @see #getMessageFactory()
	 */
	public void function(final String message, final Object... params) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, message, params);
	}

	/**
	 * Logs a message at the {@code FUNCTION} level including the stack trace of the
	 * {@link Throwable} {@code t} passed as parameter.
	 * 
	 * @param message the message to log.
	 * @param t       the exception to log, including its stack trace.
	 */
	public void function(final String message, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, message, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FUNCTION}level.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void function(final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FUNCTION} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void function(final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FUNCTION} level with the specified Marker.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @since 2.4
	 */
	public void function(final Marker marker, final Supplier<?> msgSupplier) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code FUNCTION} level.
	 *
	 * @param marker         the marker data specific to this log statement
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void function(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, message, paramSuppliers);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FUNCTION} level) with the specified Marker and including the stack
	 * trace of the {@link Throwable} <code>t</code> passed as parameter.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message; the format depends on the message factory.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void function(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, msgSupplier, t);
	}

	/**
	 * Logs a message with parameters which are only to be constructed if the
	 * logging level is the {@code FUNCTION} level.
	 *
	 * @param message        the message to log; the format depends on the message
	 *                       factory.
	 * @param paramSuppliers An array of functions, which when called, produce the
	 *                       desired log message parameters.
	 * @since 2.4
	 */
	public void function(final String message, final Supplier<?>... paramSuppliers) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, message, paramSuppliers);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FUNCTION} level with the specified Marker. The {@code MessageSupplier}
	 * may or may not use the {@link MessageFactory} to construct the
	 * {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void function(final Marker marker, final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FUNCTION} level) with the specified Marker and including the stack
	 * trace of the {@link Throwable} <code>t</code> passed as parameter. The
	 * {@code MessageSupplier} may or may not use the {@link MessageFactory} to
	 * construct the {@code Message}.
	 *
	 * @param marker      the marker data specific to this log statement
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           A Throwable or null.
	 * @since 2.4
	 */
	public void function(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, marker, msgSupplier, t);
	}

	/**
	 * Logs a message which is only to be constructed if the logging level is the
	 * {@code FUNCTION} level. The {@code MessageSupplier} may or may not use the
	 * {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @since 2.4
	 */
	public void function(final MessageSupplier msgSupplier) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, msgSupplier, (Throwable) null);
	}

	/**
	 * Logs a message (only to be constructed if the logging level is the
	 * {@code FUNCTION} level) including the stack trace of the {@link Throwable}
	 * <code>t</code> passed as parameter. The {@code MessageSupplier} may or may
	 * not use the {@link MessageFactory} to construct the {@code Message}.
	 *
	 * @param msgSupplier A function, which when called, produces the desired log
	 *                    message.
	 * @param t           the exception to log, including its stack trace.
	 * @since 2.4
	 */
	public void function(final MessageSupplier msgSupplier, final Throwable t) {
		this.logger.logIfEnabled(FQCN, FUNCTION, null, msgSupplier, t);
	}

}
