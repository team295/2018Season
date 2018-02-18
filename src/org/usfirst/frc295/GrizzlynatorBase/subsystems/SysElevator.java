package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
//import org.usfirst.frc295.GrizzlynatorBase.RobotMap.RobotID;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Counter;
//import edu.wpi.first.wpilibj.Counter.Mode;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.PWMSpeedController;
//import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Compressor;

/**
 *
 */
public class SysElevator extends Subsystem

{
	
	public static AnalogInput LimitSwitch0 = new AnalogInput(RobotMap.AIN_ELEVATOR_TEST_LIMIT);

	public static AnalogInput BottomLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_BOTTOM_LIMIT);

	public static AnalogInput VaultLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_VAULT_LIMIT);

	public static AnalogInput SwitchLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SWITCH_LIMIT);

	public static AnalogInput ScaleLimitSwitch = new AnalogInput(RobotMap.AIN_ELEVATOR_SCALE_LIMIT);
	

	//Creating ElevatorMotor from Talon with port zero
	//Talon ElevatorMotor = new Talon(RobotMap.ELEVATOR_TALON);
    //TODO - Put in and set the correct motor for the code.
	private WPI_TalonSRX ElevatorMotor;
	
	private DoubleSolenoid elevatorbreak;
	private final DoubleSolenoid.Value RETRACT_SOLENOID = DoubleSolenoid.Value.kReverse;
	private final DoubleSolenoid.Value EXTEND_SOLENOID = DoubleSolenoid.Value.kForward;
	private Compressor _elevatorcompressor = new Compressor(RobotMap.CAN_PCM_MODULE);
	
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

		debugmode = true;
		SysElevator instance = null;
		_elevatorcompressor.setClosedLoopControl(true);
		elevatorbreak  = new DoubleSolenoid(0, 7); //placeholder ports
		ElevatorMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON);

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
/*     	System.out.print("LimitSwitch0Volts:");
     	System.out.println(LimitSwitch0.getVoltage());
     	System.out.print("LimitSwitch0Raw:");
     	System.out.println(LimitSwitch0.getValue());
 */   }

	 
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
/*	public void ELevatorScale()
	{
		if (Location == 0) {
			ElevatorMotor.set(RobotMap.RISE);
			System.out.println("To Scale - From Bottom");
		}
		if (Location == 1) {
			ElevatorMotor.set(RobotMap.RISE);
			System.out.println("To Scale - From Vault");
		}
		if (Location == 2) {
			ElevatorMotor.set(RobotMap.RISE);
			System.out.println("To Scale - From Switch");
		}
		if (Location == 3) {
			ElevatorMotor.set(0.0);
			System.out.println("Already at Scale");
		}
	}
	public void ELevatorSwitch()
	{
		if (Location == 0) {
			ElevatorMotor.set(RobotMap.RISE);
			System.out.println("To Switch - From Bottom");
		}
		if (Location == 1) {
			ElevatorMotor.set(RobotMap.RISE);
			System.out.println("To Switch - From Vault");
		}
		if (Location == 2) {
			ElevatorMotor.set(0.0);
			System.out.println("Already at Switch");
		}
		if (Location == 3) {
			ElevatorMotor.set(RobotMap.LOWER);
			System.out.println("To Switch - From Scale");
		}
	}
	public void ELevatorVault()
	{
		if (Location == 0) {
			ElevatorMotor.set(RobotMap.RISE);
			System.out.println("To Vault - From Bottom");
		}
		if (Location == 1) {
			ElevatorMotor.set(0.0);
			System.out.println("Already at Vault");
		}
		if (Location == 2) {
			ElevatorMotor.set(RobotMap.LOWER);
			System.out.println("To Vault - From Switch");
		}
		if (Location == 3) {
			ElevatorMotor.set(RobotMap.LOWER);
			System.out.println("To Vault - From Scale");
		}
	}
	public void ELevatorBottom()
	{
		if (Location == 0) {
			ElevatorMotor.set(0.0);
			System.out.println("Already at Bottom");
		}
		if (Location == 1) {
			ElevatorMotor.set(RobotMap.LOWER);
			System.out.println("To Bottom - From Vault");
		}
		if (Location == 2) {
			ElevatorMotor.set(RobotMap.LOWER);
			System.out.println("To Bottom - From Switch");
		}
		if (Location == 3) {
			ElevatorMotor.set(RobotMap.LOWER);
			System.out.println("To Bottom - From Scale");
		}
	}
		
*/	public void ELevatorScale()
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
    	//Make the elevator rise
    	//One motor will be available
    	ElevatorMotor.set(RobotMap.RISE);
    }
    public void ElevatorManualLower()
    {
    	//Make the Elevator lower
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
	
	//public void compressoroff() {
	//	
	//}

}



