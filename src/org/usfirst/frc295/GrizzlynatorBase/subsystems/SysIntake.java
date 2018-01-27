package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import java.util.Enumeration;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SysIntake extends Subsystem {

	/*
	 * CHANGE CHANNEL PARAMETERS WHEN ELECTRICAL SYSTEM IS FINALIZED
	 */

	Talon LeftMotor = new Talon(14); 
	Talon RightMotor = new Talon(15);

	double currentspeed = 0;
	double Maxvalue = .80;
	double MaxReversevalue = .50;

//	double distancetocube;
//
//	//Automation Variables 
//
//	boolean cubeisIn;
//
//	boolean motorisRunning = false;
//	public enum IntakeState { motorOFFcubeOUT, motorONcubeOUT, motorONcubeIN, motorOFFcubeIN }
//	IntakeState intakestate = IntakeState.motorOFFcubeOUT;
//
//	boolean motorisReverse = false;
//	public enum DropState { motorReverseOFFcubeIN, motorReverseONcubeIN, motorReverseONcubeOUT, motorReverseOFFcubeOUT }
//	DropState dropstate = DropState.motorReverseOFFcubeOUT;

	public void initDefaultCommand() {

	}

	/*
	 * Automated intake 
	 */

	//AUtomation Components

//	public void RunIntake() {
//
//		if (!cubeisIn) {
//			CheckIntakeState();
//			IntakeCube();
//		} else {
//			CheckDropState();
//			DropCube();
//		}
//	}
//	
//	public void CheckIntakeState() {
//
//		if (!motorisRunning && !cubeisIn) {
//			intakestate = IntakeState.motorOFFcubeOUT;
//		} 
//		else if (motorisRunning && !cubeisIn) {
//			intakestate = IntakeState.motorONcubeOUT;
//		} 
//		else if (motorisRunning && cubeisIn) {
//			intakestate = IntakeState.motorONcubeIN;
//		} 
//		else {
//			intakestate = IntakeState.motorOFFcubeIN;
//		}
//	}
//
//	public void IntakeCube() {
//
//		switch (intakestate) {
//
//		case motorOFFcubeOUT:
//			
//			break;
//
//		case motorONcubeOUT:
//			
//			break;
//
//		case motorONcubeIN:
//			
//			break;
//
//		case motorOFFcubeIN:
//			cubeisIn = true;
//			break;
//		}
//	}
//
//	public void CheckDropState() {
//
//		if (!motorisRunning && !cubeisIn) {
//			dropstate = DropState.motorReverseOFFcubeOUT;
//		} 
//		else if (motorisRunning && !cubeisIn) {
//			dropstate = DropState.motorReverseONcubeOUT;
//		} 
//		else if (motorisRunning && cubeisIn) {
//			dropstate = DropState.motorReverseONcubeIN;
//		} 
//		else {
//			dropstate = DropState.motorReverseOFFcubeIN;
//		}
//	}
//	
//	public void DropCube() {
//
//		switch (dropstate) {
//
//		case motorReverseOFFcubeOUT:
//					
//			break;
//
//		case motorReverseONcubeOUT:
//
//			break;
//
//		case motorReverseONcubeIN:
//
//			break;
//
//		case motorReverseOFFcubeIN:
//
//			break;
//		}
//
//	}

	/*
	 * Sets motor speed to 0
	 */

	public void MotorSpeedReset() {

		LeftMotor.setSpeed(0);
		RightMotor.setSpeed(0);;

		currentspeed = 0;
//		motorisRunning = false;
//
//		distancetocube = Robot.sysUltrasonic.getAverageDistance();
//
//		if (distancetocube > 5) {
//			cubeisIn = true;
//		}
//		else {
//			cubeisIn = false;
//		}

	}

	/*
	 * Manual Intake and drop
	 */

	public void ManualIntakeCube(double AxisSpeed) {

		LeftMotor.setSpeed(AxisSpeed);
		RightMotor.setSpeed(-AxisSpeed);

		if (AxisSpeed > Maxvalue) {
			AxisSpeed = .8;
		} else if (AxisSpeed < -Maxvalue) {
			AxisSpeed = -.8;
		}

	}

//	public void ManualDropCube(double AxisSpeed) {
//
//		LeftMotor.set(-currentspeed);
//		RightMotor.set(currentspeed);
//
//		if (currentspeed > -MaxReversevalue) {
//			currentspeed = currentspeed - .1;
//		} 
//
//	}

}

