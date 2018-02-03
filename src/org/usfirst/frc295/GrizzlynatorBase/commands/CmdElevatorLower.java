package org.usfirst.frc295.GrizzlynatorBase.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc295.GrizzlynatorBase.Robot;
/**
 *
 */
public class CmdElevatorLower extends Command {

    public CmdElevatorLower() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	// requires(Robot.sysElevator)
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysElevator.ElevatorReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 //   	Robot.sysElevator.ElevatorLower();
 // If used uncomment
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.sysElevator.ElevatorReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sysElevator.ElevatorReset();
    }
}
