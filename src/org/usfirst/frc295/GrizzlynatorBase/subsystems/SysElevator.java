package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
//import org.usfirst.frc295.GrizzlynatorBase.RobotMap.RobotID;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.Counter;
//import edu.wpi.first.wpilibj.Counter.Mode;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.PWMSpeedController;
//import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 *
 */
public class SysElevator extends Subsystem
{
	public static AnalogInput BottomLimitSwitch;
	int BottomLimitSwitchraw;
	double BottomLimitSwitchvolts;

	public static AnalogInput VaultLimitSwitch;
	int VaultLimitSwitchraw;
	double VaultLimitSwitchvolts;

	public static AnalogInput SwitchLimitSwitch;
	int SwitchLimitSwitchraw;
	double SwitchLimitSwitchvolts;

	public static AnalogInput ScaleLimitSwitch;
	int ScaleLimitSwitchraw;
	double ScaleLimitSwitchvolts;
	
	private DoubleSolenoid elevatorbreak;
	
	private final DoubleSolenoid.Value RETRACT_SOLENOID = DoubleSolenoid.Value.kReverse;
	private final DoubleSolenoid.Value EXTEND_SOLENOID = DoubleSolenoid.Value.kForward;
	
    public static int Location = 0; 
    private static SysElevator instance;
	Talon ElevatorMotor = new Talon(RobotMap.ELEVATOR_TALON);




	public SysElevator()
	{
		BottomLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_BOTTOM_LIMIT);
		BottomLimitSwitchvolts = BottomLimitSwitch.getVoltage();
		
		VaultLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_VAULT_LIMIT);
		VaultLimitSwitchvolts = VaultLimitSwitch.getVoltage();

		SwitchLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SWITCH_LIMIT);
		SwitchLimitSwitchvolts = SwitchLimitSwitch.getVoltage();
		
		ScaleLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SCALE_LIMIT);
		ScaleLimitSwitchvolts = ScaleLimitSwitch.getVoltage();
		
		Location = 0; 
		SysElevator instance = null;
		
		elevatorbreak  = new DoubleSolenoid(1, 2); //placeholder ports
	}
	

	public static SysElevator getInstance()
	{
		if (instance == null)
		{
			instance = new SysElevator();
		}
		return instance;
	}

       	 
	public static boolean isSwitchSetScale()
	{
		if (ScaleLimitSwitch.getVoltage() > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	public static boolean isSwitchSetSwitch()
	{
		if (SwitchLimitSwitch.getVoltage() > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	public static boolean isSwitchSetVault()
	{
		if (VaultLimitSwitch.getVoltage() > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	public static boolean isSwitchSetBottom()
	{
		if (BottomLimitSwitch.getVoltage() > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
/*
    public void initializeCounter() 

    {
        Scalecounter.reset();
        Bottomcounter.reset();
        Switchcounter.reset();
        Vaultcounter.reset();
    }
*/
	protected void initDefaultCommand()
	{
		
	}

	public void ELevatorScale()
	{
		switch(Location)
		{
			case 0 :
				ElevatorMotor.set(RobotMap.RISE);
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
			case 2 :
				ElevatorMotor.set(RobotMap.RISE);
			case 3 :
		}	
	}
	
	public void ELevatorSwitch()
	{
		switch(Location)
		{
			case 0 :
				ElevatorMotor.set(RobotMap.RISE);
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
			case 2 :
				
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
		}	
	}
	
	public void ELevatorVault()
	{
		switch(Location)
		{
			case 0 :
				ElevatorMotor.set(RobotMap.RISE);
			case 1 :

			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);	
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);

		}	
	}

	public void ELevatorBottom()
	{
		switch(Location)
		{
			case 0 :
				
			case 1 :
				ElevatorMotor.set(RobotMap.LOWER);
			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
		}	
	}
	
	public void ELevatorZero()

	{
		ElevatorMotor.set(RobotMap.ZERO);
	}
	
    public void ElevatorManualRise()
    {
    	ElevatorMotor.set(RobotMap.RISE);
    }
    public void ElevatorManualLower()
    {
    	ElevatorMotor.set(RobotMap.LOWER);
    }
    
    public void setbreak() {
    	elevatorbreak.set(EXTEND_SOLENOID);
	}
	
	public void releasebreak() {
		elevatorbreak.set(RETRACT_SOLENOID);
	}
}


