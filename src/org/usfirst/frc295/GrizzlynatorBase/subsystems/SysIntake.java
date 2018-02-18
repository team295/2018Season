package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SysIntake extends Subsystem {

	/*
	 * CHANGE CHANNEL PARAMETERS WHEN ELECTRICAL SYSTEM IS FINALIZED
	 */

	//General Variables

	Spark LeftMotor;
	Spark RightMotor;

	boolean cubeisIn;
	boolean Reverse;
	boolean motorisRunning;

	public enum IntakeState 
	{ 
		motorForwardOFFcubeOUT, 
		motorForwardONcubeOUT, 
		motorForwardONcubeIN, 
		motorForwardOFFcubeIN, 

		motorReverseOFFcubeIN, 
		motorReverseONcubeIN, 
		motorReverseONcubeOUT, 
		motorReverseOFFcubeOUT 
	}

	IntakeState currentstate;
	IntakeState nextstate;

	double distancetocube;

	double currentspeed;
	double Maxvalue;
	double MaxReversevalue;

	private static SysIntake instance = null;

	private SysIntake()
	{
		//MAP CORRECT PORT NUMBER WHEN ELECTRICAL BOARD CONFIGURATION IS FINALIZED

		LeftMotor = new Spark(1);
		RightMotor = new Spark(2);

		currentstate = IntakeState.motorForwardOFFcubeOUT;
		nextstate = currentstate;

		motorisRunning = false;

		currentspeed = 0;
		Maxvalue = .5;
		MaxReversevalue = .50;
	}

	//ensures only 1 instance is created

	public static SysIntake getInstance()
	{
		if(instance == null)
		{
			instance = new SysIntake();
		}

		return instance;
	}

	public void initDefaultCommand() 
	{

	}

	/*
	 * State Machine
	 */

	public void IntakeState() 
	{

		//Looping conditions

		distancetocube = Robot.sysUltrasonic.getDistance();

		if (distancetocube < 26) 
		{
			cubeisIn = true;
		} 
		else 
		{
			cubeisIn = false;
		}

		if (LeftMotor.getSpeed() != 0) 
		{
			motorisRunning = true;
		} 
		else 
		{
			motorisRunning = false;
		}

		//State machine

		switch (currentstate) 
		{

		case motorForwardOFFcubeOUT:

			Reverse = false;

			if (motorisRunning && !cubeisIn) 
			{
				nextstate = IntakeState.motorForwardONcubeOUT;
			} 
			
			break;

		case motorForwardONcubeOUT:
			if (motorisRunning && cubeisIn) 
			{
				nextstate = IntakeState.motorForwardONcubeIN;
			} 
			
			break;

		case motorForwardONcubeIN:
			if (!motorisRunning && cubeisIn) 
			{
				nextstate = IntakeState.motorForwardOFFcubeIN;
			}
			
			break;

		case motorForwardOFFcubeIN:
			if (!motorisRunning && cubeisIn) 
			{
				nextstate = IntakeState.motorReverseOFFcubeIN;
			}
			
			break;

		case motorReverseOFFcubeIN:

			Reverse = true;

			if (!motorisRunning && cubeisIn) 
			{
				nextstate = IntakeState.motorReverseOFFcubeIN;
			}
			
			break;

		case motorReverseONcubeIN:
			if (motorisRunning && cubeisIn) 
			{
				nextstate = IntakeState.motorReverseONcubeIN;
			}
			
			break;

		case motorReverseONcubeOUT:
			if (!motorisRunning && cubeisIn) 
			{
				nextstate = IntakeState.motorReverseOFFcubeIN;
			}
			
			break;

		case motorReverseOFFcubeOUT:
			if (!motorisRunning && !cubeisIn) 
			{
				nextstate = IntakeState.motorForwardOFFcubeOUT;
			} 
			
			break;
		}

		currentstate = nextstate;

		System.out.println(currentstate);
	}

	public void AutoIntake() 
	{
		if (Reverse) 
		{	
			if (currentspeed < Maxvalue) 
			{
				currentspeed = currentspeed + .01;
			} 

			LeftMotor.setSpeed(currentspeed);
			RightMotor.setSpeed(-currentspeed);

		} 
		else 
		{
			if (currentspeed > -MaxReversevalue) 
			{
				currentspeed = currentspeed - .01;
			} 

			LeftMotor.setSpeed(-currentspeed);
			RightMotor.setSpeed(currentspeed);
		}
	}

	/*
	 * Resets motor speed to 0
	 */

	public void MotorSpeedReset() 
	{
		LeftMotor.setSpeed(0);
		RightMotor.setSpeed(0);

		currentspeed = 0;
		motorisRunning = false;
	}

	/*
	 * Manual Intake and drop
	 */

	public void ManualIntakeCube() 
	{
		if (currentspeed < Maxvalue) 
		{
			currentspeed = currentspeed + .1;
		} 

		LeftMotor.setSpeed(-currentspeed);
		RightMotor.setSpeed(currentspeed);
	}

	public void ManualDropCube() 
	{
		if (currentspeed > -MaxReversevalue) 
		{
			currentspeed = currentspeed - .1;
		} 

		LeftMotor.setSpeed(-currentspeed);
		RightMotor.setSpeed(currentspeed);
	}
}

