package org.usfirst.frc295.GrizzlynatorBase.Looper;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import org.usfirst.frc295.GrizzlynatorBase.Logger.CrashTrackingRunnable;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This code runs all of the robot's Loop objects. Loop objects are stored in a List
 * object. They are started when the robot powers up and stopped after the
 * match.
 */
public class Looper 
{
    private double _dPeriod = 50;

    private boolean running_;
    private double timestamp_ = 0;
    private double dt_ = 0;

    private final Notifier notifier_;
    private final List<Loop> loops_;
    private final Object taskRunningLock_ = new Object();

    
    // RUNNABLE THAT RUNS LOOPS when the Notifier triggers every Constants.LOOPER_PERIOD_SEC
    private final CrashTrackingRunnable runnable_ = new CrashTrackingRunnable() 
    {
        @Override
        public void runCrashTracked() 
        {
            synchronized (taskRunningLock_) 
            {
                if (running_) {
                    double now = Timer.getFPGATimestamp();
                    for (Loop loop : loops_) 
                    {
                        loop.onLoop();
                    }
                    dt_ = now - timestamp_;
                    timestamp_ = now;
                }
            }
        }
    };

    
    public Looper(double dPeriod) 
    {
        notifier_ = new Notifier(runnable_);
        running_ = false;
        loops_ = new ArrayList<>();
        _dPeriod = dPeriod;
    }

    
    public synchronized void register(Loop loop) 
    {
        synchronized (taskRunningLock_) 
        {
            loops_.add(loop);
        }
    }

    public synchronized void start() 
    {
        if (!running_) 
        {
            System.out.println("Starting loops");
            synchronized (taskRunningLock_) 
            {
                timestamp_ = Timer.getFPGATimestamp();
                for (Loop loop : loops_) 
                {
                    loop.onStart();
                }
                running_ = true;
            }
            notifier_.startPeriodic(_dPeriod);
        }
    }

    public synchronized void stop() 
    {
        if (running_) {
            System.out.println("Stopping loops");
            notifier_.stop();
            synchronized (taskRunningLock_) 
            {
                running_ = false;
                for (Loop loop : loops_) 
                {
                    System.out.println("Stopping " + loop);
                    loop.onStop();
                }
            }
        }
    }

    public void outputToSmartDashboard() {
        SmartDashboard.putNumber("looper_dt", dt_);
    }
}