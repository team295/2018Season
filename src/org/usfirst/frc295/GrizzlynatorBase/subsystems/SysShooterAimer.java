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
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class SysShooterAimer extends Subsystem 
{
	/*
	private static final int STORE         = 10000; //10000
	private static final int CASTLE_SHOOT  = 19400; //19400
	private static final int HIGH_SHOOT    = 25500; //25500
	private static final int LOW_SHOOT     = 80000; //95000
	private static final int PICKUP        = 90000; //105000
	
	private static double    ANGLE_REVERSE_LIMIT = 0;
	private static double    ANGLE_FORWARD_LIMIT = 0;
	*/
	
	
	private CANTalon         _escAimer;
    private Encoder          _encoAimer;
    private DigitalInput     _switchTop;

	private double           _dShooterAngle = 0;
	private double           _dAngleOffset = 0;    
    
	/*
    public void SysAimer()
    {

		_dAngleOffset = _escAimer.getPosition();
		System.out.println(_dAngleOffset);

		ANGLE_FORWARD_LIMIT = _dAngleOffset + 35;
		ANGLE_REVERSE_LIMIT = _dAngleOffset + 2;	
		
    }
	*/
	
    public SysShooterAimer()
    {
		super();

		//TODO: NEED TO FIGURE OUT WHAT IS GOING ON HERE
    	
        // ==========================================================
        // SYS SHOOTER AIMER 
        // ==========================================================
        _escAimer = new CANTalon(RobotMap.PWM_SHOOTER_AIMER_ESC);
        _escAimer.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        _escAimer.changeControlMode(CANTalon.TalonControlMode.Position);
        _escAimer.configPeakOutputVoltage(5.8, -2.2); //2.5, -4.4
		
		//_talon.configEncoderCodesPerRev(4000);
        _escAimer.setProfile(0); // Position
        _escAimer.setF(0.1);
        _escAimer.setP(0.25);
        _escAimer.setI(0);
        _escAimer.setD(3.2);
		
        _escAimer.setProfile(1); //Speed
        _escAimer.setF(0.005);
        _escAimer.setP(0.02);
        _escAimer.setI(0); 
        _escAimer.setD(0.01);
		
        _escAimer.changeControlMode(CANTalon.TalonControlMode.Speed);
        _escAimer.configPeakOutputVoltage(12, -12);
        _escAimer.setProfile(1);

        _escAimer.enableForwardSoftLimit(false);
        _escAimer.enableReverseSoftLimit(false);
    	//_escAimer.setForwardSoftLimit(ANGLE_FORWARD_LIMIT);
    	//_escAimer.setReverseSoftLimit(ANGLE_REVERSE_LIMIT);
		
        _escAimer.reverseOutput(false);
		
        _escAimer.setEncPosition(0);
        _escAimer.enable();
        _escAimer.set(0);


    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
	public boolean isAtTop() 
	{
		return (_switchTop.get());
	}
	
	
	public void setAimerModePosition() 
	{
		_escAimer.changeControlMode(CANTalon.TalonControlMode.Position);
		_escAimer.configPeakOutputVoltage(3, -3);
		_escAimer.setProfile(0);
		_escAimer.set(_escAimer.getPosition() / 1.4);
	}
	
	public void setAimerModeSpeed() 
	{
		_escAimer.changeControlMode(CANTalon.TalonControlMode.Speed);
		_escAimer.configPeakOutputVoltage(12, -12);
		_escAimer.setProfile(1);
	}
	
	
	public double getAngleAbsolute() 
	{
		return _escAimer.getPosition();
	}
	
	public void setAngleAbsolute(double dPosition) 
	{
		_escAimer.set(dPosition);
    	_dShooterAngle = getAngleAbsolute();
	}

	public void setAngleRelative(double dAdjust) 
	{
		// TODO: WHY DO WE SCALE BY 1.4? 
		_escAimer.set(_escAimer.getPosition() / 1.4 + dAdjust);
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

