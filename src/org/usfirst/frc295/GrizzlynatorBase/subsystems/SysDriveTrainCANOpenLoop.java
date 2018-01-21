package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
*
*/
public class SysDriveTrainCANOpenLoop extends SysDriveTrain
{
	// DECLARE COMPONENTS OF THE DRIVETRAIN
	
	private WPI_TalonSRX _escLeftFront;
	private WPI_TalonSRX _escLeftBack;
	private WPI_TalonSRX _escRightFront;
	private WPI_TalonSRX _escRightBack;

	
	public SysDriveTrainCANOpenLoop()
	{
		super();
		
		// ==========================================================
		// SYS DRIVE TRAIN
		// ==========================================================
		_escLeftFront = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_LEFT_FRONT);

		_escLeftBack = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_LEFT_BACK);

		_escRightFront = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_RIGHT_FRONT);

		_escRightBack = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_RIGHT_BACK);



	    _escLeftBack.follow(_escLeftFront);
	    _escRightBack.follow(_escRightFront);
		_robotDrive = new DifferentialDrive(_escLeftFront, _escRightFront);
	

//		_robotDrive.setInvertedMotor(DifferentialDrive.MotorType.kFrontLeft, true);
//		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
//		// SET TO false FOR COMP1 Robot
//		//_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
//		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
//		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		// If SetSafetyEnabled is false, then the SetExpiration doesn't matter.
		// These are safeties for the drive motors that shut them down if the
		// code goes for too long (1 second as specified by SetExpiration)
		// without setting the motor power.
		// It's there to protect you, from infinite code loops or usually during
		// debugging when you could set the motor speed and have a breakpoint
		// that
		// allows the robot to keep running without stopping or responding to
		// driver controls.
		_robotDrive.setSafetyEnabled(true);
		_robotDrive.setExpiration(0.25);

		// When using drive() -- The algorithm for steering provides a constant
		// turn radius for any normal speed range, both forward and backward.
		// Increasing m_sensitivity causes sharper turns for fixed values of
		// curve.
		// This function will most likely be used in an autonomous routine.
		// Not used in any other "drive" functions like tankDrive(),
		// arcadeDrive() ...
//		_robotDrive.setSensitivity(0.5);

		// Used to scale the output - The values to drive the motor will be
		// scaled
		// by the value passed.
		_robotDrive.setMaxOutput(1.0);


		// DEFINE DIO ENCODERS FOR THE DRIVETRAIN

		//Wheel size = 6 (diameter)
		//Math.Pi * 6 / 256 is the distance traveled per inch if 1 revolution of encoder is 1 revolution of wheel
		//9.6 rev enc = 1 rev wheel
		_encoDriveLeft = new Encoder(RobotMap.DIO_ENC_DRIVE_LEFT_CHAN1, RobotMap.DIO_ENC_DRIVE_LEFT_CHAN2, false,
				EncodingType.k4X);

		_encoDriveLeft.setDistancePerPulse((Math.PI*6)/(256*9.5));

		_encoDriveLeft.setPIDSourceType(PIDSourceType.kDisplacement);
		

		_encoDriveRight = new Encoder(RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN1, RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN2, false,
				EncodingType.k4X);



		_encoDriveRight.setDistancePerPulse((Math.PI*6)/(256*9.5));

		_encoDriveRight.setPIDSourceType(PIDSourceType.kDisplacement);
		
//		_encoElevatorLeft = new Encoder(RobotMap.DIO_ENC_ELEVATOR_LEFT_CHAN1, RobotMap.DIO_ENC_ELEVATOR_RIGHT_CHAN2, false, EncodingType.k4X);
	}

}
