package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class SysDriveTrainSpark extends SysDriveTrain {
	// DECLARE COMPONENTS OF THE DRIVETRAIN
	
	private Spark _escMaster;
	private Spark _escBlank;
	
	public SysDriveTrainSpark()
	{
		super();
		
		// ==========================================================
		// SYS DRIVE TRAIN
		// ==========================================================
		_escMaster = new Spark(RobotMap.PWM_ESC_LIFT);
		_escBlank = new Spark(RobotMap.PWM_ESC_BLANK);
//		_escLeftFront.setFeedbackDevice(TalonSRX.FeedbackDevice.QuadEncoder);
//		_escLeftFront.reverseSensor(false);
//		_escLeftFront.configEncoderCodesPerRev(1024);
//		

//	    _escLeftBack.follow(_escLeftFront);
//	    _escRightBack.follow(_escRightFront);
		_robotDrive = new DifferentialDrive(_escMaster, _escBlank);
//	

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
		_encoDriveLeft = new Encoder(RobotMap.DIO_ENC_DRIVE_LEFT_CHAN1, RobotMap.DIO_ENC_DRIVE_LEFT_CHAN2, false,
				EncodingType.k4X);
		
		_encoDriveLeft.setDistancePerPulse(1.0);
		_encoDriveLeft.setPIDSourceType(PIDSourceType.kRate);
		

		_encoDriveRight = new Encoder(RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN1, RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN2, false,
				EncodingType.k4X);
		_encoDriveRight.setDistancePerPulse(1.0);
		_encoDriveRight.setPIDSourceType(PIDSourceType.kRate);
		
//		_encoElevatorLeft = new Encoder(RobotMap.DIO_ENC_ELEVATOR_LEFT_CHAN1, RobotMap.DIO_ENC_ELEVATOR_RIGHT_CHAN2, false, EncodingType.k4X);
	}


}
