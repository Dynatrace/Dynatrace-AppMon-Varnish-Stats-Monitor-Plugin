package com.dynatrace.diagnostics.plugins.varnish;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Compresses repeated logs on log level basis.
 */
public class PrimitiveCompressingLogger {
	public static PrimitiveCompressingLogger getLogger(String name) {
		Logger logger = Logger.getLogger(name);
		return new PrimitiveCompressingLogger(logger);
	}

	private Logger logger;

	private PrimitiveCompressingLogger(Logger logger) {
		this.logger = logger;
	}

	public boolean isLoggable(Level level) {
		return logger.isLoggable(level);
	}

	private static class LogRecord {
		private String message = null;
		private long count = 0;

		public LogRecord(String message) { this.message = message; }
		public String getMessage() { return message; }
		public long getCount() { return count; }
		public void incCount() { count++; }
		@Override
		public String toString() { return message + " (" + count + "x)"; }
	}
	private HashMap<Level, LogRecord> lastLogs = new HashMap<Level, LogRecord>();

	public void log(Level level, String msg, Throwable t) {
		if (!logger.isLoggable(level))
			return;

		synchronized (this) {
			LogRecord record = lastLogs.get(level);
			if (record != null) {
				if (msg.equals(record.getMessage())) {
					record.incCount();
					return;
				}
				if (record.getCount() > 0)
					logger.log(level, "Last message on " + level + " level repeated " + record.getCount() + " times");
			}
			logger.log(level, msg, t);
			lastLogs.put(level, new LogRecord(msg));
		}
	}

	public void log(Level level, String msg) { log(level, msg, null); }

	public void severe(String msg) { log(Level.SEVERE, msg); }
	public void warning(String msg) { log(Level.WARNING, msg); }
	public void info(String msg) { log(Level.INFO, msg); }
	public void config(String msg) { log(Level.CONFIG, msg); }
	public void fine(String msg) { log(Level.FINE, msg); }
	public void finer(String msg) { log(Level.FINER, msg); }
	public void finest(String msg) { log(Level.FINEST, msg); }
}
