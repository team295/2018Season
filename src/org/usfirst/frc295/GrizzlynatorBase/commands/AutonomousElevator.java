package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

//Command is empty for now. Needs to be completed.

public class AutonomousElevator extends Command {
	
	public int iElevator;

    public AutonomousElevator() {
    	requires(Robot.sysElevator);
    }

    protected void initialize() {
    	Robot.sysElevator.releasebreak();
    }

    protected void execute() {
    	if (iElevator == 0) 
    	{
    	  	Robot.sysElevator.ELevatorBottom();
    		System.out.println("Going to Bottom.");
    		if (Robot.sysElevator.isVaultSet() == false)
    		{
    	    	SysElevator.Location = 1;  
    		}
    		if (Robot.sysElevator.isSwitchSet() == false)
    		{
    	    	SysElevator.Location = 2;  
    		}
    		if (Robot.sysElevator.isScaleSet() == false)
    		{
    	    	SysElevator.Location = 3;  
    		}
    	}
    	if (iElevator == 1) 
    	{
    	  	Robot.sysElevator.ElevatorVault();
    		System.out.println("Going to Vault.");
    		if (Robot.sysElevator.isScaleSet() == false)
    		{
    	    	SysElevator.Location = 3;  
    		}
    		if (Robot.sysElevator.isSwitchSet() == false)
    		{
    	    	SysElevator.Location = 2;  
    		}
    		if (Robot.sysElevator.isBottomSet() == false)
    		{
    	    	SysElevator.Location = 0;  
    		}
    	}
    	if (iElevator == 2) 
    	{
    	  	Robot.sysElevator.ELevatorSwitch();
    		System.out.println("Going to Switch.");
    		if (Robot.sysElevator.isVaultSet() == false)
    		{
    	    	SysElevator.Location = 1;  
    		}
    		if (Robot.sysElevator.isScaleSet() == false)
    		{
    	    	SysElevator.Location = 3;  
    		}
    		if (Robot.sysElevator.isBottomSet() == false)
    		{
    	    	SysElevator.Location = 0;  
    		}
    	}
    	if (iElevator == 3) 
    	{
    	  	Robot.sysElevator.ELevatorScale();
    		System.out.println("Going to Scale.");
    		if (Robot.sysElevator.isVaultSet() == false)
    		{
    	    	SysElevator.Location = 1;  
    		}
    		if (Robot.sysElevator.isSwitchSet() == false)
    		{
    	    	SysElevator.Location = 2;  
    		}
    		if (Robot.sysElevator.isBottomSet() == false)
    		{
    	    	SysElevator.Location = 0;  
    		}
    	}
 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
     	if (iElevator == 0) 
    	{
            return !Robot.sysElevator.isBottomSet();
    	}
    	if (iElevator == 1) 
    	{
            return !Robot.sysElevator.isVaultSet();
    	}
    	if (iElevator == 2) 
    	{
            return !Robot.sysElevator.isSwitchSet();
    	}
    	if (iElevator == 3) 
    	{
            return !Robot.sysElevator.isScaleSet();
    	}
    	else {
    		return false;
    	}

    }

    // Called once after isFinished returns true
    protected void end() {
    	if (iElevator == 0) 
    	{
        	Robot.sysElevator.ELevatorZero();
        	Robot.sysElevator.setbreak();
        	SysElevator.Location = 0;  
    		System.out.println("Currently at Bottom.");
        	System.out.println(SysElevator.Location);
        }
    	if (iElevator == 1) 
    	{
        	Robot.sysElevator.ELevatorZero();
        	Robot.sysElevator.setbreak();
        	SysElevator.Location = 1;  
    		System.out.println("Currently at Vault.");
        	System.out.println(SysElevator.Location);   
        }
    	if (iElevator == 2) 
    	{
        	Robot.sysElevator.ELevatorZero();
        	Robot.sysElevator.setbreak();
        	SysElevator.Location = 2;  
    		System.out.println("Currently at Switch.");
        	System.out.println(SysElevator.Location);   
        }
    	if (iElevator == 3) 
    	{
        	Robot.sysElevator.ELevatorZero();
        	Robot.sysElevator.setbreak();
        	SysElevator.Location = 3;  
    		System.out.println("Currently at Scale.");
        	System.out.println(SysElevator.Location);    
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sysElevator.ELevatorZero();
    	Robot.sysElevator.setbreak();
    }
}
