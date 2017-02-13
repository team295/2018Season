/*
Copyright (c) 2012 Vitaly Russinkovsky

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package org.usfirst.frc295.GrizzlynatorBase.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SysLog
{

	private Thread _threadWorker;
	private BlockingQueue<SysLogMessage> _blockingQueue = new ArrayBlockingQueue<SysLogMessage>(LOG_QUEUE_SIZE);

	private static final int LOG_QUEUE_SIZE = 4096;
	static final boolean escapeNewLines = true;


	public String adaptPriority(int iLevel, Facility eFacility)
	{
		int code = (eFacility.getId() << 3) + adaptSeverity(iLevel);
		return "<" + code + ">";
	}


	public int adaptSeverity(int iLevel)
	{
		if (iLevel >= Logger.LEVEL_ERROR)
		{
			return SysLogSeverity.ERROR.getLevel();
		}
		else if (iLevel >= Logger.LEVEL_WARN)
		{
			return SysLogSeverity.WARNING.getLevel();
		}
		else if (iLevel >= Logger.LEVEL_INFO)
		{
			return SysLogSeverity.INFO.getLevel();
		}
		else
		{
			return SysLogSeverity.DEBUG.getLevel();
		}
	}


	SysLog(String szHostName, int iPort, SysLogTransport eTransport)
	{
		if (eTransport == SysLogTransport.TCP)
		{
			_threadWorker = new Thread(new SysLogTcpSender(szHostName, iPort, _blockingQueue));
		}
		else
		{
			_threadWorker = new Thread(new SysLogUdpSender(szHostName, iPort, _blockingQueue));
		}
		_threadWorker.start();
	}


	public void stop()
	{
		_threadWorker = null;
	}


	void log(SysLogMessage syslogMessage)
	{
		// BlockingQueue is thread-safe but will throw an exception
		// if the request cannot be completed immediately
		// we will just ignore it since this is just logging.....
		try
		{
			_blockingQueue.offer(syslogMessage);
		}
		catch (Throwable t)
		{
		}
	}


	void log(int iLevel, SysLog.Facility eFacility, String szMessage)
	{
		try
		{
			SysLogMessage message = new SysLogMessage();
			String pri = adaptPriority(iLevel, eFacility);
			message.print(pri);
			message.print(szMessage);
			_blockingQueue.offer(message);
		}
		catch (Throwable t)
		{
		}
	}

	/**
	 * Enumeration of transports for syslog protocol.
	 */
	enum SysLogTransport
	{
		UDP, TCP;
	}

	/**
	 * Enumeration of facilities according to RFC 3164.
	 */
	public enum Facility
	{
		KERN(0), // Kernel messages
		USER(1), // user-level messages
		MAIL(2), // mail system
		DAEMON(3), // system daemons
		AUTH(4), // security/authorization messages (note 1)
		SYSLOG(5), // messages generated internally by syslogd
		LPR(6), // line printer subsystem
		NEWS(7), // network news subsystem
		UUCP(8), // UUCP subsystem
		CRON(9), // clock daemon (note 2)
		SECURITY(10), // security/authorization messages (note 1)
		FTP(11), // FTP daemon
		NTP(12), // NTP subsystem
		LOGAUDIT(13), // log audit (note 1)
		LOGALERT(14), // log alert (note 1)
		CLOCK(15), // clock daemon (note 2)
		LOCAL0(16), // local use 0 (local0)
		LOCAL1(17), // local use 1 (local1)
		LOCAL2(18), // local use 2 (local2)
		LOCAL3(19), // local use 3 (local3)
		LOCAL4(20), // local use 4 (local4)
		LOCAL5(21), // local use 5 (local5)
		LOCAL6(22), // local use 6 (local6)
		LOCAL7(23); // local use 7 (local7)

		private int id;


		Facility(int id)
		{
			this.id = id;
		}


		public int getId()
		{
			return id;
		}
	}

	/*
	 * Enumeration for severity according to RFC 3164
	 */
	public enum SysLogSeverity
	{

		// RFC 3164

		EMERGENCY(0), // System is unusable
		ALERT(1), // Action must be taken immediately
		CRITICAL(2), // Critical conditions
		ERROR(3), // Error conditions
		WARNING(4), // Warning conditions
		NOTICE(5), // Normal but significant condition
		INFO(6), // Informational messages
		DEBUG(7); // Debug-level messages

		private int level;


		SysLogSeverity(int level)
		{
			this.level = level;
		}


		public int getLevel()
		{
			return level;
		}
	}

}
