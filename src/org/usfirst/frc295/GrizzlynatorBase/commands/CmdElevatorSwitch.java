package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

//Command is empty for now. Needs to be completed.

public class CmdElevatorSwitch extends Command {

    public CmdElevatorSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sysElevator.ELevatorSwitch();
		System.out.println("Going to Switch.");
		if (SysElevator.ScaleLimitSwitch.getVoltage() > 2.5)
		{
	    	SysElevator.Location = 3;  
		}
		if (SysElevator.VaultLimitSwitch.getVoltage() > 2.5)
		{
	    	SysElevator.Location = 1;  
		}
		if (SysElevator.BottomLimitSwitch.getVoltage() > 2.5)
		{
	    	SysElevator.Location = 0;  
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SysElevator.isSwitchSetSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {

    	Robot.sysElevator.ELevatorZero();
    	Robot.sysElevator.setbreak();
		System.out.println("Currently at Switch.");
    	SysElevator.Location = 2;  
    	System.out.println(SysElevator.Location);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sysElevator.ELevatorZero();
    }
}
