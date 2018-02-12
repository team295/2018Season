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
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysElevator.ELevatorBottom();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		System.out.println("Going to Bottom.");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SysElevator.isSwitchSetBottom();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.sysElevator.setbreak();
    	Robot.sysElevator.ELevatorZero();
    	SysElevator.Location = 0;  
		System.out.println("Currently at Bottom.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
