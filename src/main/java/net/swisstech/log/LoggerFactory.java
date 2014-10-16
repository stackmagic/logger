package net.swisstech.log;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/** Factory for Format-String Logger */
public final class LoggerFactory {

	private static final ConcurrentMap<org.slf4j.Logger, Logger> MAP = new ConcurrentHashMap<org.slf4j.Logger, Logger>();

	/** private constructor for utility class */
	private LoggerFactory() {}

	/**
	 * Factory Method for Class-based Loggers. Logger instances are cached and reused.
	 * @param clazz The Class for which to get a Logger
	 * @return The Logger instance
	 */
	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	/**
	 * Factory Method for String-based Loggers. Logger instances are cached and reused.
	 * @param name The Name for which to get a Logger (usually a class name. In that case you can use the Class object directly, if available)
	 * @return The Logger instance
	 */
	public static Logger getLogger(String name) {
		org.slf4j.Logger slf4jLogger = org.slf4j.LoggerFactory.getLogger(name);
		Logger logger = MAP.get(slf4jLogger);
		if (logger == null) {
			logger = new Logger(slf4jLogger);
			Logger other = MAP.putIfAbsent(slf4jLogger, logger);
			if (other != null) {
				logger = other;
			}
		}
		return logger;
	}
}
