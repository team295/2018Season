package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
//import org.usfirst.frc295.GrizzlynatorBase.RobotMap.RobotID;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Counter.Mode;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;

//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.PWMSpeedController;
//import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 *
 */
public class SysElevator extends Subsystem

{
	private static Encoder _encoElevator;
//	public static AnalogInput BottomLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_BOTTOM_LIMIT);
//	public static AnalogInput VaultLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_VAULT_LIMIT);
//	//public static AnalogInput SwitchLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SWITCH_LIMIT);
//	public static AnalogInput ScaleLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SCALE_LIMIT);
//	
	private static DigitalInput SwitchlimitSwitchScale;
	private static DigitalInput SwitchlimitSwitchVault;
	private static DigitalInput SwitchlimitSwitchSwitch;
	private static DigitalInput SwitchlimitSwitchBottom;
    public static  Counter Switchcounter;
    
	private Spark ElevatorMotor;
	public static boolean Switchbolt;
	private DoubleSolenoid elevatorbreak;
	private final DoubleSolenoid.Value RETRACT_SOLENOID = DoubleSolenoid.Value.kReverse;
	private final DoubleSolenoid.Value EXTEND_SOLENOID = DoubleSolenoid.Value.kForward;
	private Compressor _elevatorcompressor = new Compressor(RobotMap.CAN_PCM_MODULE);
	private static SysElevator _instance = null;
	
    private boolean debugmode;
    
	private SysElevator()
	{
		debugmode = true;
		
		_elevatorcompressor.setClosedLoopControl(true);
		elevatorbreak  = new DoubleSolenoid(0, 7); 
		ElevatorMotor = new Spark(RobotMap.ELEVATOR_TALON);
		SwitchlimitSwitchScale = new DigitalInput(RobotMap.DIO_ELEVATOR_SCALE_LIMIT);
		SwitchlimitSwitchVault = new DigitalInput(RobotMap.DIO_ELEVATOR_VAULT_LIMIT);
		SwitchlimitSwitchSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_SWITCH_LIMIT);
		SwitchlimitSwitchBottom = new DigitalInput(RobotMap.DIO_ELEVATOR_BOTTOM_LIMIT);
		
		_encoElevator = new Encoder(RobotMap.DIO_ENC_ELEVATOR_LEFT_CHAN1, RobotMap.DIO_ENC_ELEVATOR_RIGHT_CHAN2, false, EncodingType.k4X);
		_encoElevator.setDistancePerPulse(1.0);
		_encoElevator.setPIDSourceType(PIDSourceType.kDisplacement);
	
	}
	//public boolean getRaw() {
	//	
	//	return SwitchlimitSwitch.get();
	//}

	public static SysElevator getInstance()
	{
		if (_instance == null)
		{
			_instance = new SysElevator();
		}
		return _instance;
	}

     public static int Location = 0; 
     private static SysElevator instance;
 

     public void debug_test() {
     }

     public double getEncoderValue()
     {
    	 return _encoElevator.getDistance();
     }
	 
//	public static boolean isSwitchSetScale()
//	{
//		if (ScaleLimitSwitch.getVoltage() > 2.5)
//		{
//		return true;		
//		}
//		else
//		{
//		return false;
//		}
//	}
//	
//	public static boolean isSwitchSetScaleEnco()
//	{
//		if (_encoElevator.getDistance() == 12000)
//		{
//		return true;		
//		}
//		else
//		{
//		return false;
//		}
//	}
//	
//	/*public static boolean isSwitchSetSwitch()
//	{
//		if (SwitchLimitSwitch.getVoltage() > 2.5)
//		{
//		return true;
//		}
//		else	
//		{
//		return false;
//		}
//	}*/
//	
//	public static boolean isSwitchSetSwitchEnco()
//	{
//		if (_encoElevator.getDistance() == 8000)
//		{
//		return true;
//		}
//		else
//		{
//		return false;
//		}
//	}

    public boolean isScaleSet() 
    {
        return SwitchlimitSwitchScale.get();
    }
    
    public boolean isSwitchSet() 
    {
        return SwitchlimitSwitchSwitch.get();
    }
    public boolean isVaultSet() 
    {
        return SwitchlimitSwitchVault.get();
    }
    public boolean isBottomSet() 
    {
        return SwitchlimitSwitchBottom.get();
    }
    
//    
//    
//    
//	public static boolean isSwitchSetVault()
//	{
//		if (VaultLimitSwitch.getVoltage() > 2.5)
//		{
//		return true;
//		}
//		else
//		{
//		return false;
//		}
//	}
//    
//	public static boolean isSwitchSetVaultEnco()
//	{
//		if (_encoElevator.getDistance() == 4000)
//		{
//		return true;
//		}
//		else
//		{
//		return false;
//		}
//	}   
//	public static boolean isSwitchSetBottom()
//	{
//		if (BottomLimitSwitch.getVoltage() > 2.5)
//		{
//		return true;
//		}
//		else
//		{
//		return false;
//		}
//	}
//    
//	public static boolean isSwitchSetBottomEnco()
//	{
//		if (_encoElevator.getDistance() == 0000)
//		{
//		return true;
//		}
//		else
//		{
//		return false;
//		}
//	}
//	
	protected void initDefaultCommand()
	{
		
	}

	public void ELevatorScale()
	{
		switch(Location)
		{
			case 0 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
				System.out.println("To Scale - From Bottom");
				}
					break;
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
				System.out.println("To Scale - From Vault");
				}
					break;
			case 2 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
			System.out.println("To Scale - From Switch");
				}
					break;
			case 3 :
					System.out.println("Already at Scale");
					break;
		}	
	}
	

	public void ELevatorSwitch()
	{
		switch(Location)
		{
			case 0 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
			System.out.println("To Switch - From Bottom");
				}
				break;
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
			System.out.println("To Switch - From Vault");
				}
				break;
			case 2 :
			System.out.println("Already at Switch");
				break;
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
			System.out.println("To Switch - From Scale");
				}
				break;
		}	
	}

	
	public void ELevatorVault()
	{
		switch(Location)
		{
			case 0 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
			System.out.println("To Vault - From Bottom");
				}
					break;
			case 1 :
					System.out.println("Already at Vault");
						break;
			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
			System.out.println("To Vault - From Switch");
				}
					break;
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
			System.out.println("To Vault - From Scale");
				}
					break;
		}	
	}

	public void ELevatorBottom()
	{
		switch(Location)
		{
			case 0 :
				System.out.println("Already at Bottom");
				break;
			case 1 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
			System.out.println("To Bottom - From Vault");
				}
					break;
			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
			System.out.println("To Bottom - From Switch");
				}
					break;
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
			System.out.println("To Bottom - From Scale");
				}
					break;
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
	
	public void compressoron() {
		_elevatorcompressor.setClosedLoopControl(true);
	}
}



