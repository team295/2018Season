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

import org.usfirst.frc295.GrizzlynatorBase.Drive.DriveSignal;
import org.usfirst.frc295.GrizzlynatorBase.commands.CmdDriveWithJoystick;

import com.ctre.CANTalon;
import com.ctre.CanTalonJNI;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Troubleshooting: 1. OPERATING THE JOYSTICK TO GO STRAIGHT SPINS THE ROBOT
 * Invert the "setInvertedMotor" statements for one side
 *
 * 2. OPERATING THE JOYSTICK TO TURN RIGHT TURNS THE ROBOT LEFT Invert the
 * "setInvertedMotor" statements for all motors
 */
public abstract class SysDriveTrain extends Subsystem
{

	protected DifferentialDrive _robotDrive;

	// SENSORS
	protected Encoder _encoDriveRight;
	protected Encoder _encoDriveLeft;
//	protected CANTalon _encoDriveRight;


	// THE ROBOT DRIVETRAIN'S VARIOUS STATES
	protected enum DriveControlState
	{
		OPEN_LOOP, BASE_LOCKED, VELOCITY_SETPOINT, VELOCITY_HEADING_CONTROL, PATH_FOLLOWING_CONTROL
	}

	protected DriveControlState _stateDriveControl = DriveControlState.OPEN_LOOP;


	public SysDriveTrain()
	{
		super();
	}


	@Override
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// DEFAULT FOR THIS SUBSYSTEM IS TO DRIVE WITH JOYSTICK
		setDefaultCommand(new CmdDriveWithJoystick());
	}


	public synchronized void setOpenLoop(DriveSignal signal)
	{
		if (_stateDriveControl != DriveControlState.OPEN_LOOP)
		{
			// _escLeftFront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
			// _escRightFront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
			_stateDriveControl = DriveControlState.OPEN_LOOP;
		}

		_robotDrive.tankDrive(signal.leftMotor, signal.rightMotor);
	
	
	}


	public synchronized void stop()
	{
		_robotDrive.stopMotor();
	}


	public synchronized void arcadeDrive(double move, double rotation)
	{
		_robotDrive.arcadeDrive(move, rotation);
	}


	
	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset()
	{
		// _gyro.reset();
//		_encoDriveRight.reset();
//		_encoDriveLeft.reset();
	}


	/**
	 * @return The robots heading in degrees.
	 */
	public double getHeading()
	{
		// return gyro.getAngle();
		return (0);
	}


	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance()
	{
		return (_encoDriveRight.getDistance() + _encoDriveLeft.getDistance()) / 2;
	}


	/**
	 * @return The distance to the obstacle detected by the rangefinder.
	 */
	public double getDistanceToObstacle()
	{
		// Really meters in simulation since it's a rangefinder...
		// return rangefinder.getAverageVoltage();
		return (0);
	}


	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void logToSmartDashboard()
	{
		// SmartDashboard.putData("vibrate", new CmdHapticFeedback());
		SmartDashboard.putNumber("Drive Encoder: Left Distance", _encoDriveLeft.getDistance());
		SmartDashboard.putNumber("Drive Encoder: Right Distance", _encoDriveRight.getDistance());
		SmartDashboard.putNumber("Drive Encoder: Left Speed", _encoDriveLeft.getRate());
		SmartDashboard.putNumber("Drive Encoder: Right Speed", _encoDriveRight.getRate());
	}
}
