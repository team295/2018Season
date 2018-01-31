package org.usfirst.frc295.GrizzlynatorBase.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc295.*;
import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;

/**
 *
 */
public class CmdElevatorSwitch extends Command {

    public CmdElevatorSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	// requires(Robot.sysElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sysElevator.ELevatorSwitch();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
      return Robot.sysElevator.isSwitchSetSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {
     	Robot.sysElevator.ELevatorZero();
    	SysElevator.Location = 2;    
    	Robot.sysElevator.initializeCounter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
   }
}
