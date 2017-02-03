package org.usfirst.frc295.GrizzlynatorBase.Logger;

import org.usfirst.frc295.GrizzlynatorBase.Logger.SysLog.SysLogTransport;

public class SysLogFactory 
{
    static SysLog _syslogInstance = null;
    static String _szHostName;
    static int    _iPort;
    static SysLogTransport _eTransport;
    
    
    SysLogFactory(String szHostName, int iPort, SysLogTransport eTransport)
    {
    	_szHostName = szHostName;
    	_iPort      = iPort;
    	_eTransport = eTransport;
    }

    public static SysLog getSysLog() 
    {
    	if (_syslogInstance == null)
    	{
    		_syslogInstance = new SysLog(_szHostName, _iPort, _eTransport);
    	}
        return _syslogInstance;
    }
   
}
