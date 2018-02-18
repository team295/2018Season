package org.usfirst.frc295.GrizzlynatorBase.DriveAdvanced;

import org.usfirst.frc295.GrizzlynatorBase.Drive.Rotation2d;
import org.usfirst.frc295.GrizzlynatorBase.Drive.VelocityHeadingSetpoint;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.NavX_Gyro;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSystemHelperVelocityHeading extends DriveSystemHelper
{
	/**
	 * a driveSystem that directs the robot towards a
	 * {@link VelocityHeadingSetpoint}
	 *
	 * @author amind
	 */
	// TODO figure out how to use this drive algorithm
	protected DifferentialDrive drive;
	private NavX_Gyro gyro;

	private double mLastHeadingErrorDegrees;
	private VelocityHeadingSetpoint velocityHeadingSetpoint_;
	private SynchronousPID velocityHeadingPid_;


	/**
	 * @param drive
	 *            a speed controlled drive stream
	 * @param gyro
	 *            a stream of robot heading
	 */
	public DriveSystemHelperVelocityHeading(DifferentialDrive drive, NavX_Gyro gyro)
	{
		this.drive = drive;
		this.gyro = gyro;
	}


	/**
	 *
	 */
	public void update()
	{
		// WHAT IS THE CURRENT ANGLE WE AER HEADING
		Rotation2d actualGyroAngle = Rotation2d.fromDegrees(gyro.getAngle());

		// CALCULATE THE ERROR IN ANGLE FROM OUR CURRENT velocityHeadingSetpoint
		mLastHeadingErrorDegrees = velocityHeadingSetpoint_.getHeading().rotateBy(actualGyroAngle.inverse())
				.getDegrees();

		// USE PID TO CALCULATE THE DIFFERENCE IN SPEED OF THE WHEELS TO CORRECT
		// THE ERROR
		double deltaSpeed = velocityHeadingPid_.calculate(mLastHeadingErrorDegrees);

		// ADJUST SPEED OF THE MOTOR TO REDUCE THE ERROR
//		drive.setLeftRightMotorOutputs(velocityHeadingSetpoint_.getLeftSpeed() + (deltaSpeed / 2),
//				velocityHeadingSetpoint_.getRightSpeed() - (deltaSpeed / 2));
	}


	/**
	 * sets the {@link VelocityHeadingSetpoint} of this driveSystem. assumes
	 * that the setpoint desires straight line motion
	 *
	 * @param forward_inches_per_sec
	 *            the desired wheel speed (applied to both wheels)
	 * @param headingSetpoint
	 *            the desired heading
	 */
	public void setVelocityHeadingSetpoint(double forward_inches_per_sec, Rotation2d headingSetpoint)
	{
		velocityHeadingPid_.reset();
		velocityHeadingSetpoint_ = new VelocityHeadingSetpoint(forward_inches_per_sec, forward_inches_per_sec,
				headingSetpoint);
	}


	public String getName()
	{
		return "DriveSystemHelperVelocityHeading";
	}
}
