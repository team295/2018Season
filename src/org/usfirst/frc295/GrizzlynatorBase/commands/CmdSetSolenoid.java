package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

//Command is empty for now. Needs to be completed.

public class CmdSetSolenoid extends Command {

    public CmdSetSolenoid() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysElevator.compressoron();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sysElevator.setbreak();
		System.out.println("command running");


    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
       	Robot.sysElevator.releasebreak();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}