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
	public boolean _disQuickTurn;

	public double _dDistanceTarget;
	static int WHEEL_SIZE;
	private double _dDistanceStart;
	double _dDistanceTargetz = 0 ;

	private double _wantedtime;

	public Waypoint(double dDistance/*double time*/, double dRotation, double dMove, boolean disQuickTurn)
	{
		

		_dMove = dMove;
		_dRotation = dRotation;
		_dDistanceTarget = dDistance;
		//_wantedtime = time;
		_dTrack = false;
		_disQuickTurn = disQuickTurn;
		requires(Robot.sysDriveTrain);
	
		System.out.println(_dRotation);
		SmartDashboard.putNumber("Wanted Rotation: ", _dRotation);
		//ahrs = Robot.ahrs;
		WHEEL_SIZE = 6;
		
//		_dDistanceTarget = _dDistanceTarget / (WHEEL_SIZE * Math.PI);
//		_dDistanceTarget = _dDistanceTarget * 1024;
//		_dDistanceTarget = _dDistanceTarget;
		SmartDashboard.putNumber("TicksWanted", _dDistanceTarget);
	
	}
	 
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		Robot.sysDriveTrain.reset();
		Robot.ahrs.reset();
		// START_TIME = Timer.getFPGATimestamp();
//		_dDistanceStart = Robot.sysDriveTrain.getDistance();
		
	
		_dInitialAngle = Robot.ahrs.getYaw();
		_dTargetAngle = _dRotation;
		
		

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
		System.out.print(Robot.sysDriveTrain.getDistance());
		// _dCurvecurve = 0.6;
		// firstvar = move secondvar = move + rotation
		if (_dTargetAngle == 0)
		{
			System.out.println("NO turn");
			Robot.sysDriveTrain.arcadeDrive(-_dMove, -_dCurvecurve);

			SmartDashboard.putNumber("Encoder Value", Robot.sysDriveTrain.getDistance());

		}
		else
		{
			System.out.println("Fix Left Right Turning");
			if ((Math.abs(_dCurvecurve / Kp) > 2.0))
			{
				System.out.println("YES turn");
				Robot.sysDriveTrain.arcadeDrive(-_dMove, -_dCurvecurve);
//				Robot.sysDriveTrain.curvatureDrive(_dMove, _dRotation, _disQuickTurn);
//				Robot.sysDriveTrain.tankDrive(_dMove);

			}
			else
			{
				
				Robot.sysDriveTrain.stop();
			}
		}
		SmartDashboard.putNumber("Error", _dCurvecurve);
		SmartDashboard.putNumber("Rotation", _dRotation);
//		System.out.println("Curve is  " + _dCurvecurve);
//		System.out.print("Target angle is " + _dTargetAngle);

	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		

		
		if (_dTargetAngle != 0)
		{
			if (Math.abs(_dTargetAngle) == Math.abs(Robot.ahrs.getYaw()))
			{
				System.out.println("Turn Logic");
				Robot.sysDriveTrain.stop();
				return true;
			}
		}
		else if (_dTargetAngle == 0) 
		{

			return ((Math.abs(Robot.sysDriveTrain.getDistance())) >= _dDistanceTarget);
		}
		
//		if (_dTrack)
//		{
//			if (Robot.sysUltrasonic.getAverageDistance() <= 15)
//			{
//				return true;
//			}
//		}
//		SmartDashboard.putNumber("Real Stop Encoder", Robot.sysDriveTrain.getDistance());
		return false;

	}
	
	@Override
	protected void end()
	{
		Robot.sysDriveTrain.stop();
		Robot.sysDriveTrain.reset();
		Robot.ahrs.reset();
	}
	
}