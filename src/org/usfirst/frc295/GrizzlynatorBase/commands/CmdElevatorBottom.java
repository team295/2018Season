package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

//Command is empty for now. Needs to be completed.

public class CmdElevatorBottom extends Command {

    public CmdElevatorBottom() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sysElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysElevator.releasebreak();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sysElevator.ELevatorBottom();
		System.out.println("Going to Bottom.");
		if (Robot.sysElevator.isVaultSet() == false)
		{
	    	SysElevator.Location = 1;  
		}
		if (Robot.sysElevator.isScaleSet() == false)
		{
	    	SysElevator.Location = 3;  
		}
		if (Robot.sysElevator.isSwitchSet() == false)
		{
	    	SysElevator.Location = 2;  
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.sysElevator.isBottomSet();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.sysElevator.ELevatorZero();
    	Robot.sysElevator.setbreak();
    	SysElevator.Location = 0;  
		System.out.println("Currently at Bottom.");
    	System.out.println(SysElevator.Location);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sysElevator.ELevatorZero();
    	Robot.sysElevator.setbreak();
    }
}
