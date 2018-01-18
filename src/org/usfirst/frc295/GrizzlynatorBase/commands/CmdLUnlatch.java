package org.usfirst.frc295.GrizzlynatorBase.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysRamp;
/**
 *
 */
public class CmdLUnlatch extends Command {

    private short pin = 2;
	public CmdLUnlatch() {
    	requires(Robot.sysRamp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysRamp.LUnlatch();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sysRamp.LUnlatch();
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
