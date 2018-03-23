package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DfltEncoderDrive extends Command {

    public DfltEncoderDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sysEncoderDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysEncoderDrive.setTOPOff();
    	Robot.sysEncoderDrive.setDSOff();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Robot.sysEncoderDrive.setTOPOff();
    	Robot.sysEncoderDrive.setDSOff();
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}