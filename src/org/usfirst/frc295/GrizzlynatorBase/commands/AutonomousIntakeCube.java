package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousIntakeCube extends Command {

    public AutonomousIntakeCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysIntake.MotorSpeedReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sysIntake.AutonomousIntakeCube();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (5.5 >= Robot.sysUltrasonic.getDistance());
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