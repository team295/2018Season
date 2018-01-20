// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc295.GrizzlynatorBase.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;



/**
 *
 */
public class AutonomousLeft extends CommandGroup //9 + 10
{

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public AutonomousLeft(String gameData)
	{
		if(gameData.charAt(0) == 'L')
		{
			// Start Left and Color match on Switch
			addSequential(new Waypoint(168,0,.8,false));
			addSequential(new Wait());
			addSequential(new Waypoint(0,90,.5,false));//turn left
			//addSequential(new Wait());
			//addSequential ultra sonic to go to switch
			//addSequential(new Wait());
			//addSequential drop cube
			addSequential(new Waypoint(-24,0,.8,false));
			addSequential(new Wait());
			addSequential(new Waypoint(0,-90,.5,false));
			addSequential(new Waypoint(18,0,.8,false));
			addSequential(new Wait());
			addSequential(new Waypoint(0,90,.5,false));
			addSequential(new Wait());
			//addSequential pick up cube
		}
		else if(gameData.charAt(1) == 'L')
		{
			// Start Left and No color match on Switch But color match on Scale
			addSequential(new Waypoint(324,0,.9,false));
			addSequential(new Wait());
			addSequential(new Waypoint(0,90,.5,false));
			addSequential(new Wait());
			//add sequential extend elevator
			// add sequential drop cube
			//addSequential(new Wait());
			// add sequential retract elevator
			addSequential(new Wait());
			addSequential(new Waypoint(0,-90,.5,false));
		}
		else
		{
			addSequential(new Waypoint(240,0,.8,false));
		}
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() //haha 69
	{
	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return false;
	}


	// Called once after isFinished returns true
	@Override
	protected void end()
	{
	}


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}
