package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
*
*/
public class Waypoint extends Command
{


	private double _dInitialAngle;
	private double _dTargetAngle;
	private double _dMove;
	private double _dRotation;
	private double _dTime;
	public double _dCurvecurve;
	static double Kp = .08;
	static double START_TIME;
	public boolean _dTrack;

	public double _dDistanceTarget;
	static int WHEEL_SIZE;
	private double _dDistanceStart;

	private double _wantedtime;

	public Waypoint(double dDistance/*double time*/, double dRotation, double dMove, boolean dTrack)
	{
		

		_dMove = dMove;
		_dRotation = dRotation;
		_dDistanceTarget = dDistance;
		//_wantedtime = time;
		_dTrack = dTrack;
		requires(Robot.sysDriveTrain);

		System.out.println(_dRotation);
		SmartDashboard.putNumber("Wanted Rotation: ", _dRotation);
		//ahrs = Robot.ahrs;
		WHEEL_SIZE = 5;
		
		_dDistanceTarget = _dDistanceTarget / (WHEEL_SIZE * Math.PI);
		_dDistanceTarget = _dDistanceTarget * 1024;
		_dDistanceTarget =  _dDistanceTarget;
		SmartDashboard.putNumber("TicksWanted", _dDistanceTarget);

	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{

		// START_TIME = Timer.getFPGATimestamp();
		_dDistanceStart = Robot.sysDriveTrain.getDistance();
		
		Robot.ahrs.reset();
		_dInitialAngle = Robot.ahrs.getYaw();
		_dTargetAngle = _dRotation;
		Robot.sysDriveTrain.reset();

	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		_dCurvecurve = _dTargetAngle - Robot.ahrs.getYaw();
		_dCurvecurve = (_dCurvecurve) * Kp;

		SmartDashboard.putNumber("Curve", -_dCurvecurve);
		SmartDashboard.putNumber("Angle", Robot.ahrs.getAngle());
		SmartDashboard.putNumber("Yaw", Robot.ahrs.getYaw());
		SmartDashboard.putNumber("_dTargetAngle", _dTargetAngle);

		// _dCurvecurve = 0.6;
		// firstvar = move secondvar = move + rotation
		if (_dTargetAngle == 0)
		{
			Robot.sysDriveTrain.arcadeDrive(-_dMove, -_dCurvecurve);
			SmartDashboard.putNumber("Encoder Value", Robot.sysDriveTrain.getDistance());
		}
		else
		{
			// System.out.println("Fix Left Right Turning");
			if ((Math.abs(_dCurvecurve / Kp) > 2.0))
			{
				Robot.sysDriveTrain.arcadeDrive(-_dMove, -_dCurvecurve);
				SmartDashboard.putNumber("Encoder Value", Robot.sysDriveTrain.getDistance());
			}
			else
			{
				Robot.sysDriveTrain.stop();
			}
		}
		SmartDashboard.putNumber("Error", _dCurvecurve);
		SmartDashboard.putNumber("Rotation", _dRotation);
		System.out.println("Curve is  " + _dCurvecurve);
		System.out.print("Target angle is " + _dTargetAngle);

	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{

		//return(timeSinceInitialized()>_wantedtime);
	/*	
		if (_dTargetAngle != 0)
		{
			if (Math.abs(_dCurvecurve / Kp) < 2.0)
			{
				Robot.sysDriveTrain.stop();
				return true;
			}
		}
		if (_dTrack)
		{
			if (Robot.sysUltrasonic.getAverageDistance() <= 15)
			{
				return true;
			}
		}*/
		SmartDashboard.putNumber("Real Stop Encoder", Robot.sysDriveTrain.getDistance());
		return ((Robot.sysDriveTrain.getDistance() - _dDistanceStart) >= _dDistanceTarget);
	

	}


	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.sysDriveTrain.stop();
	}


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}