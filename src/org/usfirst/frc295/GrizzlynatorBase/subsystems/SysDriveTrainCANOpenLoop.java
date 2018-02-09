package org.usfirst.frc295.GrizzlynatorBase.subsystems;



import org.usfirst.frc295.GrizzlynatorBase.RobotMap;



//import com.ctre.CANTalon;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import com.ctre.phoenix.motorcontrol.can.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;



//import edu.wpi.first.wpilibj.CounterBase.EncodingType;

//import edu.wpi.first.wpilibj.Encoder;

//import edu.wpi.first.wpilibj.PIDSourceType;

//import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//import edu.wpi.first.wpilibj.livewindow.LiveWindow;



/**

*

*/

public class SysDriveTrainCANOpenLoop extends SysDriveTrain

{

	// DECLARE COMPONENTS OF THE DRIVETRAIN

	

	private WPI_TalonSRX _escLeftFront;

//	private WPI_TalonSRX _escLeftBack;

	private WPI_TalonSRX _escRightFront;

//	private WPI_TalonSRX _escRightBack;



	

	public SysDriveTrainCANOpenLoop()

	{

		super();

		

		// ==========================================================

		// SYS DRIVE TRAIN

		// ==========================================================

		_escLeftFront = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_LEFT_FRONT);

//		_escLeftFront.setFeedbackDevice(TalonSRX.FeedbackDevice.QuadEncoder);

//		_escLeftFront.reverseSensor(false);

//		_escLeftFront.configEncoderCodesPerRev(1024);

//		





//		_escLeftBack = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_LEFT_BACK);

//		

//

		_escRightFront = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_RIGHT_FRONT);

////		_escRightFront.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);

////		_escRightFront.reverseSensor(false);

////		_escRightFront.configEncoderCodesPerRev(1024);

////		LiveWindow.addActuator("SysDriveTrain", "Esc Right Front", _escRightFront);

//

//		_escRightBack = new WPI_TalonSRX(RobotMap.CAN_ESC_DRIVE_RIGHT_BACK);

//		LiveWindow.addActuator("SysDriveTrain", "Esc Right Back", _escRightBack);



//	    _escLeftBack.follow(_escLeftFront);

//	    _escRightBack.follow(_escRightFront);

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

/*		_encoDriveLeft = new Encoder(RobotMap.DIO_ENC_DRIVE_LEFT_CHAN1, RobotMap.DIO_ENC_DRIVE_LEFT_CHAN2, false,

				EncodingType.k4X);

		

		_encoDriveLeft.setDistancePerPulse(1.0);

		_encoDriveLeft.setPIDSourceType(PIDSourceType.kRate);

		



		_encoDriveRight = new Encoder(RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN1, RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN2, false,

				EncodingType.k4X);

		_encoDriveRight.setDistancePerPulse(1.0);

		_encoDriveRight.setPIDSourceType(PIDSourceType.kRate);

		

    	_encoElevatorLeft = new Encoder(RobotMap.DIO_ENC_ELEVATOR_LEFT_CHAN1, RobotMap.DIO_ENC_ELEVATOR_RIGHT_CHAN2, false, EncodingType.k4X);
*/
	}



}
