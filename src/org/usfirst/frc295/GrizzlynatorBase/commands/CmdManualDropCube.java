package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CmdManualDropCube extends Command {

    public CmdManualDropCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysIntake.MotorSpeedReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    	Robot.sysIntake.ManualDropCube();   	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(isCanceled());
        return isCanceled();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("END");
    	Robot.sysIntake.MotorSpeedReset();
    }

    
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Interrupted");
    	Robot.sysIntake.MotorSpeedReset();
    }
}
