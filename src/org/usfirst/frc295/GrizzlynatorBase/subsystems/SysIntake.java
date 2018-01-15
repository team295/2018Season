package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SysIntake extends Subsystem {

	//CHANGE CHANNEL PARAMETERS WHEN ELECTRICAL SYSTEM IS FINALIZED

	Talon LeftMotor = new Talon(0); 
	Talon RightMotor = new Talon(1);

	double currentspeed = 0;

	double Maxvalue = .80;

	public void initDefaultCommand() {

	}

	public void IntakeCube() {

		LeftMotor.set(currentspeed);
		RightMotor.set(-currentspeed);

		if (currentspeed < Maxvalue) {
			currentspeed = currentspeed + .1;
		} 
	}

	public void DropCube() {

		LeftMotor.set(-currentspeed);
		RightMotor.set(currentspeed);

		if (currentspeed < Maxvalue) {
			currentspeed = currentspeed - .1;
		} 
	}

	public void MotorSpeedReset() {

		LeftMotor.set(0);
		RightMotor.set(0);

		currentspeed = 0;
	}

}

