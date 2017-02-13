package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import org.usfirst.frc295.GrizzlynatorBase.commands.CmdLiftWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This flywheel will support Open Loop, Speed Control and Encoder Count 1) The
 * RPM speed, the setpoint, and the RPM tolerance. When told to, the flywheel
 * will try to spin up to the setpoint within the set RPM tolerance. 2) The
 * Encoder Count
 */
public class SysLift extends SysCANMotor
{
	private CANTalon _talonSlave;

	// TO BE USED TO ADJUST SPEED
	private double _dCurrentSetRpm = 0;
	private double _dCurrentSetPercentVBus = 0;


	public SysLift()
	{
		super();
		_talonMaster = new CANTalon(RobotMap.CAN_ESC_LIFT_MASTER);
		_talonSlave = new CANTalon(RobotMap.CAN_ESC_LIFT_SLAVE);

		_talonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		_talonMaster.reverseSensor(false);
		_talonMaster.configEncoderCodesPerRev(1024);
		_talonMaster.configNominalOutputVoltage(+0.0f, -0.0f);

		// DON'T ALLOW THE MOTOR TO RUN IN THE FORWARD DIR !!!
		_talonMaster.configPeakOutputVoltage(0.0f, -12.0f);
		_talonMaster.setPosition(0);

		// SPEED CONTROL PROFILE
		_talonMaster.setProfile(0);
		_talonMaster.setPID(RobotMap.FLYWHEEL_SPEED_KP, RobotMap.FLYWHEEL_SPEED_KI, RobotMap.FLYWHEEL_SPEED_KD,
				RobotMap.FLYWHEEL_SPEED_KF, RobotMap.FLYWHEEL_SPEED_IZONE, RobotMap.FLYWHEEL_SPEED_RAMP_RATE, 0);

		// POSITION CONTROL PROFILE
		_talonMaster.setProfile(1);
		_talonMaster.setPID(RobotMap.FLYWHEEL_POSITION_KP, RobotMap.FLYWHEEL_POSITION_KI, RobotMap.FLYWHEEL_POSITION_KD,
				RobotMap.FLYWHEEL_POSITION_KF, RobotMap.FLYWHEEL_POSITION_IZONE, RobotMap.FLYWHEEL_POSITION_RAMP_RATE,
				1);

		_talonMaster.setVoltageRampRate(36.0);
		_talonMaster.enableBrakeMode(false);
		_talonMaster.clearStickyFaults();

		// IF WE HAVE A SLAVE CANTalon AS PART OF OUR FLYWHEEL
		_talonSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		_talonSlave.set(RobotMap.CAN_ESC_LIFT_MASTER);
		_talonSlave.reverseOutput(false);

		_talonSlave.setVoltageRampRate(6.0);
		_talonSlave.enableBrakeMode(false);
		_talonSlave.clearStickyFaults();

		// DEFAULT TO PROFILE 0 AND OPEN LOOP PERCENT V BUS
		_talonMaster.setProfile(0);
		_talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}


	@Override
	protected void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// TEMP FOR TESTING
		setDefaultCommand(new CmdLiftWithJoystick());
	}


	public void outputToSmartDashboard()
	{
		SmartDashboard.putNumber("flywheel_rpm", getRpm());
		SmartDashboard.putNumber("flywheel_setpoint", _talonMaster.getSetpoint());
		SmartDashboard.putBoolean("flywheel_on_speed_target",
				isOnTargetSpeed(RobotMap.FLYWHEEL_SPEED_ONTARGET_TOLERANCE));
		SmartDashboard.putNumber("flywheel_master_current", _talonMaster.getOutputCurrent());
	}


	public void zeroSensors()
	{
		// no-op
	}

}
