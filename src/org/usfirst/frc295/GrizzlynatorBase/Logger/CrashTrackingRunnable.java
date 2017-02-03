package org.usfirst.frc295.GrizzlynatorBase.Logger;

/**
 * Runnable class with uncaught exceptions are logged
 * 1.  Inherit from CrashTrackingRunnable
 * 2.  Override runCrashTracked()
 */
public abstract class CrashTrackingRunnable implements Runnable 
{

    @Override
    public final void run() 
    {
        try 
        {
            runCrashTracked();
        } 
        catch (Throwable t) 
        {
            Logger.logThrowable(t);
            throw t;
        }
    }

    public abstract void runCrashTracked();
}