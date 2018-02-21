package org.usfirst.frc295.GrizzlynatorBase.Drive;



/**
 * Helper class to implement "Cheesy Drive". "Cheesy Drive" simply means that
 * the "turning" stick controls the curvature of the robot's path rather than
 * its rate of heading change. This helps make the robot more controllable at
 * high speeds. Also handles the robot's quick turn functionality - "quick turn"
 * overrides constant-curvature turning for turn-in-place maneuvers.
 */

public class CheesyDriveHelper
{
	private static final double THROTTLE_DEADBAND = 0.02;
	private static final double TURN_DEADBAND = 0.02;
	private static final double TURN_SENSITIVITY = 1.0;

	private double mQuickStopAccumulator;
	private DriveSignal mSignal = new DriveSignal(0, 0);


	public DriveSignal cheesyDrive(double throttle, double wheel, boolean isQuickTurn)
	{

		throttle = handleDeadband(throttle, THROTTLE_DEADBAND);
		wheel = handleDeadband(wheel, TURN_DEADBAND);

		double overPower;
		double angularPower;

		if (isQuickTurn)
		{
			if (Math.abs(throttle) < 0.2)
			{
				double alpha = 0.1;
				mQuickStopAccumulator = ((1 - alpha) * mQuickStopAccumulator) + (alpha * limit(wheel, 1.0) * 2);
			}
			overPower = 1.0;
			angularPower = wheel;
		}
		else
		{
			overPower = 0.0;
			angularPower = (Math.abs(throttle) * wheel * TURN_SENSITIVITY) - mQuickStopAccumulator;
			if (mQuickStopAccumulator > 1)
			{
				mQuickStopAccumulator -= 1;
			}
			else if (mQuickStopAccumulator < -1)
			{
				mQuickStopAccumulator += 1;
			}
			else
			{
				mQuickStopAccumulator = 0.0;
			}
		}

		// WHEN JOYSTICK LEFT IS TURNING THE ROBOT TO THE RIGHT
		// SWAP THE +/- OF THE angularPower (e.g. + => -, - => +)
		double rightPwm = throttle + angularPower;
		double leftPwm = throttle - angularPower;

		if (leftPwm > 1.0)
		{
			rightPwm -= overPower * (leftPwm - 1.0);
			leftPwm = 1.0;
		}
		else if (rightPwm > 1.0)
		{
			leftPwm -= overPower * (rightPwm - 1.0);
			rightPwm = 1.0;
		}
		else if (leftPwm < -1.0)
		{
			rightPwm += overPower * (-1.0 - leftPwm);
			leftPwm = -1.0;
		}
		else if (rightPwm < -1.0)
		{
			leftPwm += overPower * (-1.0 - rightPwm);
			rightPwm = -1.0;
		}

		mSignal.rightMotor = rightPwm;
		mSignal.leftMotor = leftPwm;

		return mSignal;
	}


	/**
	 * Limits the given input to the given magnitude.
	 */
	public double limit(double v, double limit)
	{
		return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1);
	}


	public double handleDeadband(double val, double deadband)
	{
		return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
	}


	public double handleThrottleDeadband(double val)
	{
		return (Math.abs(val) > Math.abs(THROTTLE_DEADBAND)) ? val : 0.0;
	}


	public double handleTurnDeadband(double val)
	{
		return (Math.abs(val) > Math.abs(TURN_DEADBAND)) ? val : 0.0;
	}
}
