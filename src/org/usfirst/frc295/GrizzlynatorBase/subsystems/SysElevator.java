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

/**
 *
 */
public class SysElevator extends Subsystem

{
	
	public static AnalogInput LimitSwitch0 = new AnalogInput(RobotMap.AIN_ELEVATOR_TEST_LIMIT);
	int LimitSwitch0raw;
	double LimitSwitch0volts = LimitSwitch0.getVoltage();
	
	public static AnalogInput BottomLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_BOTTOM_LIMIT);
	int BottomLimitSwitchraw;
	static double BottomLimitSwitchvolts = BottomLimitSwitch.getVoltage();

	
	public static AnalogInput VaultLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_VAULT_LIMIT);
	int VaultLimitSwitchraw;
	static double VaultLimitSwitchvolts = VaultLimitSwitch.getVoltage();

	
	public static AnalogInput SwitchLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SWITCH_LIMIT);
	int SwitchLimitSwitchraw;
	static double SwitchLimitSwitchvolts = SwitchLimitSwitch.getVoltage();

	
	public static AnalogInput ScaleLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SCALE_LIMIT);
	int ScaleLimitSwitchraw;
	static double ScaleLimitSwitchvolts = ScaleLimitSwitch.getVoltage();

	
    private boolean debugmode;
    
	//TODO - Update the rest of code, get functioning
	public SysElevator()

	{
//		public static DigitalInput ScalelimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_SCALE_LIMIT);
//		public static Counter Scalecounter = new Counter(ScaleLimitSwitch);
	  
//		public static DigitalInput SwitchlimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_SWITCH_LIMIT);
//		public static Counter Switchcounter = new Counter(SwitchLimitSwitch);

//		public static DigitalInput VaultlimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_VAULT_LIMIT);
//		public static Counter Vaultcounter = new Counter(VaultLimitSwitch);

//		public static DigitalInput BottomlimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_BOTTOM_LIMIT);
//	 	public static Counter Bottomcounter = new Counter(BottomLimitSwitch);

		debugmode = false;
		
		Location = 0; 
		SysElevator instance = null;

	}
	

	public static SysElevator getInstance()

	{

		if (instance == null)

		{

			instance = new SysElevator();

		}

		

		return instance;

	}

     
     public static int Location = 0; 
//   private ElevatorState currentElevatorState;
     private static SysElevator instance;
 

     public void debug_test() {
    	System.out.println(BottomLimitSwitchvolts);
/*     	System.out.print("LimitSwitch0Volts:");
     	System.out.println(LimitSwitch0.getVoltage());
     	System.out.print("LimitSwitch0Raw:");
     	System.out.println(LimitSwitch0.getValue());
 */   }
	//Creating ElevatorMotor from Talon with port zero
	 Talon ElevatorMotor = new Talon(RobotMap.ELEVATOR_TALON);
    //TODO - Put in and set the correct motor for the code.
	 
/*	boolean ScaleLimitswitchcount()
	{
		if (ScaleLimitSwitchvolts > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	boolean SwitchLimitSwitchcount()
	{
		if (SwitchLimitSwitchvolts > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	boolean VaultLimitSwitchcount()
	{
		if (VaultLimitSwitchvolts > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	boolean BottomLimitSwitchcount()
	{
		if (BottomLimitSwitchvolts > 2.5)
		{
		return true;
		}
		else
		{
		return false;
		}
	}
*/	 
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
/*    public static boolean isSwitchSetScale() 
    {
		return ScaleLimitSwitchcount.get() > 0;
    }
    public static boolean isSwitchSetSwitch() 
    {
        return SwitchLimitSwitchcount.get() > 0;
    }
    public static boolean isSwitchSetBottom() 
    {
        return BottomLimitSwitchcount.get() > 0;
    }
    public static boolean isSwitchSetVault() 
    {
        return VaultLimitSwitchcount.get() > 0;
    }
    

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

//	public void OperateElevator(ElevatorState stateToGoTo)
	{
		//TODO operator tells what state to go to, you create state machine that guides that
	}
	public void ELevatorScale()
	{
		switch(Location)
		{
			case 0 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
			case 2 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
			case 3 :
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
				System.out.println("Motor is Running.");
				}
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
			case 2 :
				
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
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
				System.out.println("Motor is Running.");
				}
			case 1 :

			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
		}	
	}

	public void ELevatorBottom()
	{
		switch(Location)
		{
			case 0 :
				
			case 1 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
				System.out.println("Motor is Running.");
				}
		}	
	}
	
	public void ELevatorZero()

	{
		ElevatorMotor.set(RobotMap.ZERO);
	}
	
//	private int rise = 1;
//	private int lower = -1;

	
	//Rise and Lower commands left in in case we need to make micro adjustments.

    public void ElevatorManualRise()
    {
    	//Make the elevator rise
    	//One motor will be available
    	ElevatorMotor.set(RobotMap.RISE);
    }
    public void ElevatorManualLower()
    {
    	//Make the Elevator lower
    	ElevatorMotor.set(RobotMap.LOWER);
    }

    }


