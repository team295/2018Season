package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import java.util.Enumeration;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SysIntake extends Subsystem {

	/*
	 * CHANGE CHANNEL PARAMETERS WHEN ELECTRICAL SYSTEM IS FINALIZED
	 */

	Talon LeftMotor = new Talon(0); 
	Talon RightMotor = new Talon(1);

	double currentspeed = 0;
	double Maxvalue = .80;
	double MaxReversevalue = .50;

	//Automation Variables 

	boolean cubeisIn;

	boolean motorisRunning = false;
	public enum IntakeState { motorOFFcubeOUT, motorONcubeOUT, motorONcubeIN, motorOFFcubeIN }
	IntakeState intakestate = IntakeState.motorOFFcubeOUT;

	boolean motorisReverse = false;
	public enum DropState { motorReverseOFFcubeIN, motorReverseONcubeIN, motorReverseONcubeOUT, motorReverseOFFcubeOUT }
	DropState dropstate = DropState.motorReverseOFFcubeOUT;

	public void initDefaultCommand() {

	}

	/*
	 * Sets motor speed to 0
	 */

	public void MotorSpeedReset() {

		LeftMotor.set(0);
		RightMotor.set(0);

		currentspeed = 0;
		motorisRunning = false;

		if () {
			cubeisIn = true;
		}
		else {
			cubeisIn = false;
		}

	}

	/*
	 * Automated intake
	 */

	public void CheckIntakeState() {

		if (!motorisRunning && !cubeisIn) {
			intakestate = IntakeState.motorOFFcubeOUT;
		} 
		else if (motorisRunning && !cubeisIn) {
			intakestate = IntakeState.motorONcubeOUT;
		} 
		else if (motorisRunning && cubeisIn) {
			intakestate = IntakeState.motorONcubeIN;
		} 
		else {
			intakestate = IntakeState.motorOFFcubeIN;
		}
	}

	public void CheckDropState() {

		if (!motorisRunning && !cubeisIn) {
			dropstate = DropState.motorReverseOFFcubeOUT;
		} 
		else if (motorisRunning && !cubeisIn) {
			dropstate = DropState.motorReverseONcubeOUT;
		} 
		else if (motorisRunning && cubeisIn) {
			dropstate = DropState.motorReverseONcubeIN;
		} 
		else {
			dropstate = DropState.motorReverseOFFcubeIN;
		}
	}

	public void IntakeCube() {

		switch (intakestate) {

		case motorOFFcubeOUT:

			break;

		case motorONcubeOUT:

			break;

		case motorONcubeIN:

			break;

		case motorOFFcubeIN:

			break;
		}
	}

	public void DropCube() {

		switch (dropstate) {

		case motorReverseOFFcubeOUT:

			break;

		case motorReverseONcubeOUT:

			break;

		case motorReverseONcubeIN:

			break;

		case motorReverseOFFcubeIN:

			break;
		}

	}

	/*
	 * Manual Intake and drop
	 */

	public void ManualIntakeCube() {

		LeftMotor.set(currentspeed);
		RightMotor.set(-currentspeed);

		if (currentspeed < Maxvalue) {
			currentspeed = currentspeed + .1;
		} 

	}

	public void ManualDropCube() {

		LeftMotor.set(-currentspeed);
		RightMotor.set(currentspeed);

		if (currentspeed > -MaxReversevalue) {
			currentspeed = currentspeed - .1;
		} 

	}

}

