package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The flywheel has several parameters: the RPM speed, the setpoint, and the RPM
 * tolerance. When told to, the flywheel will try to spin up to the setpoint
 * within the set RPM tolerance.
 */
public class SysFlywheel extends Subsystem  
{
    private CANTalon _talonMaster = new CANTalon(15);

	
    public SysFlywheel()
    {
		super();

		/*
        if (_talonMaster.isSensorPresent(CANTalon.FeedbackDevice.QuadEncoder) != CANTalon.FeedbackDeviceStatus.FeedbackStatusPresent) 
        {
            DriverStation.reportError("Could not detect Flywheel encoder!", false);
        }
        else
        {
            DriverStation.reportError("Found Flywheel encoder!", false);
        }
		*/

		_talonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        _talonMaster.reverseSensor(false);
        _talonMaster.configEncoderCodesPerRev(4096);
        _talonMaster.configNominalOutputVoltage(+0.0f, -0.0f);
        _talonMaster.configPeakOutputVoltage(12.0f, -12.0f);

        _talonMaster.setProfile(0);
        _talonMaster.setPID(
        		RobotMap.FLYWHEEL_KP, 
        		RobotMap.FLYWHEEL_KI, 
        		RobotMap.FLYWHEEL_KD, 
        		RobotMap.FLYWHEEL_KF,
        		RobotMap.FLYWHEEL_IZONE, 
        		RobotMap.FLYWHEEL_RAMP_RATE, 
                0);

        
        _talonMaster.setVoltageRampRate(36.0);       
        _talonMaster.clearStickyFaults();
        _talonMaster.enableBrakeMode(false);
        _talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

        // IF WE HAVE A SLAVE CANTalon AS PART OF OUR FLYWHEEL
        /*
    	_talonSlave = new CANTalon(RobotMap.CAN_ESC_FLYWHEEL_SLAVE);
        _talonSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
        _talonSlave.set(RobotMap.CAN_ESC_FLYWHEEL_MASTER);
        _talonSlave.reverseOutput(true);
        _talonSlave.setVoltageRampRate(36.0);
        _talonSlave.enableBrakeMode(false);
        _talonSlave.clearStickyFaults();
        */
    }

	@Override
	protected void initDefaultCommand() 
	{
        // Set the default command for a subsystem here.
	}


    public synchronized double getRpm() 
    {
        return _talonMaster.getSpeed();
    }

    /**
     * Sets the RPM of the flywheel. The flywheel will then spin up to the set
     * speed within a preset tolerance.
     * 
     * @param Set
     *            flywheel RPM
     */
    public synchronized void setRpm(double rpm) 
    {
    	_talonMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
    	_talonMaster.set(rpm);
    }


    // SPEED IS [-1,1] AND DOES NOT UTILIZE THE ENCODERS
    public synchronized void setOpenLoop(double speed) 
    {
     	_talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	_talonMaster.set(speed);
    }

    
    public synchronized double getSetpoint() 
    {
        return _talonMaster.getSetpoint();
    }

    /**
     * @return If the flywheel RPM is within the tolerance to the specified set
     *         point.
     */
    public synchronized boolean isOnTarget() 
    {
        return (_talonMaster.getControlMode() == CANTalon.TalonControlMode.Speed
                && Math.abs(getRpm() - getSetpoint()) < RobotMap.FLYWHEEL_ONTARGET_TOLERANCE);
    }

    public synchronized void stop() 
    {
        setOpenLoop(0);
    }

    public void outputToSmartDashboard() 
    {
        SmartDashboard.putNumber("flywheel_rpm", getRpm());
        SmartDashboard.putNumber("flywheel_setpoint", _talonMaster.getSetpoint());
        SmartDashboard.putBoolean("flywheel_on_target", isOnTarget());
        SmartDashboard.putNumber("flywheel_master_current", _talonMaster.getOutputCurrent());
    }

    public void zeroSensors() 
    {
        // no-op
    }

}
