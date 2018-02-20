package org.usfirst.frc295.GrizzlynatorBase.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysDriveTrain;
import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.commands.DfltEncoderDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class SysEncoderDrive extends Subsystem {
	//Turn On Point(TOP) stuff
	protected boolean TOP = false;
	
	public void setTOPOn() {
		TOP = true;
	}


	public void setTOPOff() {
		TOP = false;
	}

	
	public boolean getTOP() {
		return TOP;
	}

	//Drive Straight(DS) stuff
	protected boolean DS = false;
	
	public void setDSOn() {
		DS = true;
	}

	public void setDSOff() {
		DS = false;
	}
	
	public boolean getDS() {
		return DS;
	}

    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DfltEncoderDrive());
    }
}