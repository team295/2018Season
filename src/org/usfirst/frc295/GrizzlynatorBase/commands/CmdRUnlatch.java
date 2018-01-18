package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CmdRUnlatch extends Command {
	private short pin = 1;
    public CmdRUnlatch() {
    	requires(Robot.sysRamp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysRamp.RUnlatch();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sysRamp.RUnlatch();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.sysRamp.hasOpened(pin)) {
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
