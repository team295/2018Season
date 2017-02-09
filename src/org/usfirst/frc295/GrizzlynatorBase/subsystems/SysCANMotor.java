package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * The CANTalon controlled motor supporting Open Loop, Speed Control and Encoder Count  
 */
public abstract class SysCANMotor extends Subsystem  
{
	// IF THERE IS A SLAVE TALON, CONFIGURE IT IN THE SUBCLASS CONSTRUCTOR
    protected CANTalon _talonMaster;
    
    // TO BE USED TO ADJUST SPEED USING addXXX()
	private double _dCurrentSetRpm = 0;
	private double _dCurrentSetPercentVBus = 0;
	


    public synchronized double getRpm() 
    {
        return _talonMaster.getSpeed();
    }

    
    public synchronized void setSpeedMode() 
    {
        _talonMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
        _talonMaster.setProfile(0);
        _talonMaster.set(0);
    }

    public synchronized void setPositionMode() 
    {
        _talonMaster.changeControlMode(CANTalon.TalonControlMode.Position);
        _talonMaster.setProfile(1);
        _talonMaster.set(0);
    }

    public synchronized void setPercentVBusMode() 
    {
        _talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        _talonMaster.setProfile(0);
        _talonMaster.set(0);
    }
    

    // POSITION IS NUMBER OF ENCODER UNITS TO MOVE FROM CURRENT POS
    public synchronized void setPosition(double dPosition) 
    {
        _talonMaster.set(dPosition);
    }
    public synchronized void addPosition(double dPositionDelta) 
    {
    	double dCurrentPos = _talonMaster.getPosition();  	
        _talonMaster.set(dCurrentPos + dPositionDelta);
    }
    
    
    /**
     * Sets the RPM of the flywheel. The flywheel will then spin up to the set
     * speed within a preset tolerance.
     * 
     * @param Set
     *            flywheel RPM
     */
    public synchronized void setSpeed(double dRpm) 
    {
    	_dCurrentSetRpm = dRpm;
        _talonMaster.set(_dCurrentSetRpm);
    }
    public synchronized void addSpeed(double dRpmDelta) 
    {
    	_dCurrentSetRpm = _dCurrentSetRpm + dRpmDelta;
        _talonMaster.set(_dCurrentSetRpm);
    }


    // PERCENT VBUS IS [-1,1] AND DOES NOT UTILIZE THE ENCODERS
    public synchronized void setPercentVBus(double dPercentVBus) 
    {
    	_dCurrentSetPercentVBus = dPercentVBus;
        _talonMaster.set(_dCurrentSetPercentVBus);
    }
    public synchronized void addPercentVBus(double dPercentVBusDelta) 
    {
    	_dCurrentSetPercentVBus = _dCurrentSetPercentVBus + dPercentVBusDelta;
        _talonMaster.set(_dCurrentSetPercentVBus);
    }

    
    public synchronized double getSetpoint() 
    {
        return _talonMaster.getSetpoint();
    }

    /**
     * @return If the flywheel RPM is within the tolerance to the specified set
     *         point.
     */
    public synchronized boolean isOnTargetSpeed(double dOnTragetTolance) 
    {
        return (_talonMaster.getControlMode() == CANTalon.TalonControlMode.Speed
                && Math.abs(getRpm() - getSetpoint()) < dOnTragetTolance);
    }

    public synchronized void stop() 
    {
        setPercentVBusMode();
        setPercentVBus(0);
    }

}
