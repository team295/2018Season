package org.usfirst.frc295.GrizzlynatorBase.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/** A low overhead, lightweight logging system.
 * @author Nathan Sweet <misc@n4te.com> */

// For the RoboRio: Log to - "/home/lvuser/crash_tracking.txt"

public class Logger {
	/** No logging at all. */
	static public final int LEVEL_NONE = 6;
	/** Critical errors. The application may no longer work correctly. */
	static public final int LEVEL_ERROR = 5;
	/** Important warnings. The application will continue to work correctly. */
	static public final int LEVEL_WARN = 4;
	/** Informative messages. Typically used for deployment. */
	static public final int LEVEL_INFO = 3;
	/** Debug messages. This level is useful during development. */
	static public final int LEVEL_DEBUG = 2;
	/** Trace messages. A lot of information is logged, so this level is usually only needed when debugging a problem. */
	static public final int LEVEL_TRACE = 1;

	/** The level of messages that will be logged. Compiling this and the booleans below as "final" will cause the compiler to
	 * remove all "if (Log.info) ..." type statements below the set level. */
	static private int level = LEVEL_INFO;

	/** True when the ERROR level will be logged. */
	static public boolean ERROR = level <= LEVEL_ERROR;
	/** True when the WARN level will be logged. */
	static public boolean WARN = level <= LEVEL_WARN;
	/** True when the INFO level will be logged. */
	static public boolean INFO = level <= LEVEL_INFO;
	/** True when the DEBUG level will be logged. */
	static public boolean DEBUG = level <= LEVEL_DEBUG;
	/** True when the TRACE level will be logged. */
	static public boolean TRACE = level <= LEVEL_TRACE;

	/** Sets the level to log. If a version of this class is being used that has a final log level, this has no affect. */
	static public void set (int level) {
		// Comment out method contents when compiling fixed level JARs.
		Logger.level = level;
		ERROR = level <= LEVEL_ERROR;
		WARN = level <= LEVEL_WARN;
		INFO = level <= LEVEL_INFO;
		DEBUG = level <= LEVEL_DEBUG;
		TRACE = level <= LEVEL_TRACE;
	}

	static public void NONE () {
		set(LEVEL_NONE);
	}

	static public void ERROR () {
		set(LEVEL_ERROR);
	}

	static public void WARN () {
		set(LEVEL_WARN);
	}

	static public void INFO () {
		set(LEVEL_INFO);
	}

	static public void DEBUG () {
		set(LEVEL_DEBUG);
	}

	static public void TRACE () {
		set(LEVEL_TRACE);
	}

	/** Sets the logger that will write the log messages. */
	static public void setLogWriter (LogWriter writer) {
		Logger.writer = writer;
	}

	static private LogWriter writer = new LogWriter();

	static public void error (String message, Throwable ex) {
		if (ERROR) writer.log(LEVEL_ERROR, null, message, ex);
	}

	static public void error (String category, String message, Throwable ex) {
		if (ERROR) writer.log(LEVEL_ERROR, category, message, ex);
	}

	static public void error (String message) {
		if (ERROR) writer.log(LEVEL_ERROR, null, message, null);
	}

	static public void error (String category, String message) {
		if (ERROR) writer.log(LEVEL_ERROR, category, message, null);
	}

	static public void warn (String message, Throwable ex) {
		if (WARN) writer.log(LEVEL_WARN, null, message, ex);
	}

	static public void warn (String category, String message, Throwable ex) {
		if (WARN) writer.log(LEVEL_WARN, category, message, ex);
	}

	static public void warn (String message) {
		if (WARN) writer.log(LEVEL_WARN, null, message, null);
	}

	static public void warn (String category, String message) {
		if (WARN) writer.log(LEVEL_WARN, category, message, null);
	}

	static public void info (String message, Throwable ex) {
		if (INFO) writer.log(LEVEL_INFO, null, message, ex);
	}

	static public void info (String category, String message, Throwable ex) {
		if (INFO) writer.log(LEVEL_INFO, category, message, ex);
	}

	static public void info (String message) {
		if (INFO) writer.log(LEVEL_INFO, null, message, null);
	}

	static public void info (String category, String message) {
		if (INFO) writer.log(LEVEL_INFO, category, message, null);
	}

	static public void debug (String message, Throwable ex) {
		if (DEBUG) writer.log(LEVEL_DEBUG, null, message, ex);
	}

	static public void debug (String category, String message, Throwable ex) {
		if (DEBUG) writer.log(LEVEL_DEBUG, category, message, ex);
	}

	static public void debug (String message) {
		if (DEBUG) writer.log(LEVEL_DEBUG, null, message, null);
	}

	static public void debug (String category, String message) {
		if (DEBUG) writer.log(LEVEL_DEBUG, category, message, null);
	}

	static public void trace (String message, Throwable ex) {
		if (TRACE) writer.log(LEVEL_TRACE, null, message, ex);
	}

	static public void trace (String category, String message, Throwable ex) {
		if (TRACE) writer.log(LEVEL_TRACE, category, message, ex);
	}

	static public void trace (String message) {
		if (TRACE) writer.log(LEVEL_TRACE, null, message, null);
	}

	static public void trace (String category, String message) {
		if (TRACE) writer.log(LEVEL_TRACE, category, message, null);
	}

	
	// ROBOT SPECIFIC LOGGING
    public static void logRobotStartup() {
        writer.log(LEVEL_INFO, "Marker", "<<>>===========================", null);
        writer.log(LEVEL_INFO, "Marker", "Robot Startup", null);
    }

    public static void logRobotConstruction() {
    	writer.log(LEVEL_INFO, "Marker", "Robot Constrction", null);
    }

    public static void logRobotInit() {
    	writer.log(LEVEL_INFO, "Marker", "Robot Init", null);
    }

    public static void logTeleopInit() {
    	writer.log(LEVEL_INFO, "Marker", "Teleop Init", null);
    }

    public static void logAutoInit() {
    	writer.log(LEVEL_INFO, "Marker", "Auto Init", null);
    }

    public static void logDisabledInit() {
    	writer.log(LEVEL_INFO, "Marker", "Disabled Init", null);
    }

    public static void logThrowable(Throwable throwable) {
    	writer.log(LEVEL_INFO, "Marker", "Exception", throwable);
    }
	
	private Logger () {
	}

	/** Performs the actual logging. Default implementation logs to System.out. Extended and use {@link Log#logger} set to handle
	 * logging differently. */
	static public class LogWriter {
		private long firstLogTime = new Date().getTime();

		public void log (int level, String category, String message, Throwable ex) {
			StringBuilder builder = new StringBuilder(256);

			long time = new Date().getTime() - firstLogTime;
			long minutes = time / (1000 * 60);
			long seconds = time / (1000) % 60;
			if (minutes <= 9) builder.append('0');
			builder.append(minutes);
			builder.append(':');
			if (seconds <= 9) builder.append('0');
			builder.append(seconds);

			switch (level) {
			case LEVEL_ERROR:
				builder.append(" ERROR: ");
				break;
			case LEVEL_WARN:
				builder.append("  WARN: ");
				break;
			case LEVEL_INFO:
				builder.append("  INFO: ");
				break;
			case LEVEL_DEBUG:
				builder.append(" DEBUG: ");
				break;
			case LEVEL_TRACE:
				builder.append(" TRACE: ");
				break;
			}

			if (category != null) {
				builder.append('[');
				builder.append(category);
				builder.append("] ");
			}

			builder.append(message);

			if (ex != null) {
				StringWriter writer = new StringWriter(256);
				ex.printStackTrace(new PrintWriter(writer));
				builder.append('\n');
				builder.append(writer.toString().trim());
			}

			print(level, builder.toString());
			//save(level, builder.toString());
			syslog(level, builder.toString());
		}

		/** Prints the message to System.out. Called by the default implementation of {@link #log(int, String, String, Throwable)}. */
		protected void print (int iLevel, String szMessage) 
		{
			if (iLevel > Logger.LEVEL_WARN)
			{
				System.out.println(szMessage);
			}
		}
		
		protected void save (int iLevel, String szMessage) 
		{
	        try (PrintWriter writer = new PrintWriter(new FileWriter("/home/lvuser/crash_tracking.txt", true))) {
	            writer.println(szMessage);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		protected void syslog (int iLevel, String szMessage) 
		{
			SysLog s = SysLogFactory.getSysLog();
			s.log(iLevel, SysLog.Facility.LOCAL0, szMessage);					
		}
	}

}