package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestDriveStraight extends Command {

    public TestDriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sysDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysDriveTrain.LIncrement();
    	Robot.sysDriveTrain.RIncrement();
    	Robot.sysDriveTrain.LIncrement();
    	Robot.sysDriveTrain.RIncrement();
    	Robot.sysDriveTrain.LIncrement();
    	Robot.sysDriveTrain.RIncrement();
    	Robot.sysDriveTrain.LIncrement();
    	Robot.sysDriveTrain.RIncrement();
    	Robot.sysDriveTrain.LIncrement();
    	Robot.sysDriveTrain.RIncrement();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        try {
			wait((long) 10000.0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.sysDriveTrain.LDecrement();
    	Robot.sysDriveTrain.RDecrement();
    	Robot.sysDriveTrain.LDecrement();
    	Robot.sysDriveTrain.RDecrement();
    	Robot.sysDriveTrain.LDecrement();
    	Robot.sysDriveTrain.RDecrement();
    	Robot.sysDriveTrain.LDecrement();
    	Robot.sysDriveTrain.RDecrement();
    	Robot.sysDriveTrain.LDecrement();
    	Robot.sysDriveTrain.RDecrement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
