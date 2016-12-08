// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class SysFlashLight extends Subsystem 
{
	private Relay            _relayFlashlight;
	                    
    // ==========================================================
    // SYS FLASHLIGHT 
    // ==========================================================
	public SysFlashLight()
	{
		super();

		_relayFlashlight = new Relay(RobotMap.PORT_FLASHLIGHT_RELAY);
	    LiveWindow.addActuator("SysFlashlight", "Relay", _relayFlashlight);
	}

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void On()
    {
    	_relayFlashlight.set(Relay.Value.kOn);
    }

    public void Off()
    {
    	_relayFlashlight.set(Relay.Value.kOff);
    }
    
    
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    /**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void logToSmartDashboard() 
    {
	
	}   
}

