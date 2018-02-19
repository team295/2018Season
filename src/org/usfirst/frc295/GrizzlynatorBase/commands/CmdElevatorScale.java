package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

//Command is empty for now. Needs to be completed.

public class CmdElevatorScale extends Command {

    public CmdElevatorScale() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sysElevator.ELevatorScale();
		System.out.println("Going to Scale.");
		if (SysElevator.VaultLimitSwitch.getVoltage() > 2.5)
		{
	    	SysElevator.Location = 1;  
		}
		if (SysElevator.SwitchLimitSwitch.getVoltage() > 2.5)
		{
	    	SysElevator.Location = 2;  
		}
		if (SysElevator.BottomLimitSwitch.getVoltage() > 2.5)
		{
	    	SysElevator.Location = 0;  
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SysElevator.isSwitchSetScale();
    }

    // Called once after isFinished returns true
    protected void end() {

    	Robot.sysElevator.ELevatorZero();
    	Robot.sysElevator.setbreak();
    	SysElevator.Location = 3;  
		System.out.println("Currently at Scale.");
    	System.out.println(SysElevator.Location);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sysElevator.ELevatorZero();
    }
}