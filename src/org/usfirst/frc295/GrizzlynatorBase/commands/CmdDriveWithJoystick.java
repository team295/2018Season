// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent// it from being updated in the future.

package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.JoystickDriver;
import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.Drive.CheesyDriveHelper;
import org.usfirst.frc295.GrizzlynatorBase.Drive.DriveSignal;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CmdDriveWithJoystick extends Command
{
	private JoystickDriver _joystickDriver;
	private CheesyDriveHelper _helperCheesyDrive;
	public boolean _bBackwardsMode;
	
	public CmdDriveWithJoystick()
	{
		requires(Robot.sysDriveTrain);
		_joystickDriver = Robot.oi.getJoystickDriver();
		_helperCheesyDrive = new CheesyDriveHelper();
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		double dThrottle = _joystickDriver.getDriveTrainThrottleValue();
		double dTurn = _joystickDriver.getDriveTrainTurnValue();
		boolean bQuickTurn = _joystickDriver.getDriveTrainQuickTurnValue();
		
//		if( _joystickDriver.getBackwardsMode()== true){
//			_bBackwardsMode = true;
//			System.out.println("<===In Backward mode");
//		}
//		else
//		if( _joystickDriver.getForwardsMode() == true){
//			_bBackwardsMode = false;
//			System.out.println("===>In Forward mode");
//		}
		
		if(_bBackwardsMode == true){
			dThrottle = -1*dThrottle;
			//dTurn = -1*dTurn;
		}
		
		DriveSignal oDriveSignal = _helperCheesyDrive.cheesyDrive(dThrottle, dTurn, bQuickTurn);
		Robot.sysDriveTrain.setOpenLoop(oDriveSignal);
		
		

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
		Robot.sysDriveTrain.setOpenLoop(new DriveSignal(0, 0));
	}


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		end();
	}
}
