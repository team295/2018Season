package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.JoystickOperator;
import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CmdManualIntakeCube extends Command {

	private JoystickOperator _joystickOperator;
	
	private double dSpeed = 0;
	
    public CmdManualIntakeCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysIntake.MotorSpeedReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {  	
    	dSpeed = - _joystickOperator.getYAxis();
    	Robot.sysIntake.ManualIntakeCube(dSpeed);  	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.sysIntake.MotorSpeedReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
