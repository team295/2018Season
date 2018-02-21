package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

//Command is empty for now. Needs to be completed.

public class AutoElevator extends Command {
	public int _iEPosition;
	public int iEPosition;
	
    public AutoElevator(int _iEPosition) {
    	
        int iEPosition = _iEPosition;
    	requires(Robot.sysElevator);
    }

   
    protected void initialize() {
    	Robot.sysElevator.releasebreak();
    }

 
    protected void execute() {
    	Robot.sysElevator.ELevatorScale();
		System.out.println("Going to Scale.");
		if (Robot.sysElevator.isBottomSet() == false)
		{
	    	SysElevator.Location = 0;  
		}
		if (Robot.sysElevator.isSwitchSet() == false)
		{
	    	SysElevator.Location = 2;  
		}
		if (Robot.sysElevator.isVaultSet() == false)
		{
	    	SysElevator.Location = 1;  
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.sysElevator.isScaleSet();
    }

    // Called once after isFinished returns true
    protected void end() {

    	Robot.sysElevator.ELevatorZero();
    	Robot.sysElevator.setbreak();
    	SysElevator.Location = 3;  
		System.out.println("Currently at Scale.");
    	System.out.println(SysElevator.Location);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sysElevator.ELevatorZero();
    }
}
