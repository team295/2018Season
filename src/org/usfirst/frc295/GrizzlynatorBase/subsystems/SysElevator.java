package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
//import org.usfirst.frc295.GrizzlynatorBase.RobotMap.RobotID;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SysElevator extends Subsystem

{
	
	public static AnalogInput LimitSwitch1 = new AnalogInput(RobotMap.AIN_ELEVATOR_TEST_LIMIT);
	int LimitSwitch1raw;
	double LimitSwitch1volts;
	double LimitSwitch1averagevolts;
	
	//TODO - Update all ports to analog
	//TODO - Add in a function - If less than 2.5, if bigger than 2.5
	//TODO - Get raw value in place of counter
	//TODO - Update the rest of code, get functioning

	public static DigitalInput ScalelimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_SCALE_LIMIT);
	public static Counter Scalecounter = new Counter(ScalelimitSwitch);
  
	public static DigitalInput SwitchlimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_SWITCH_LIMIT);
	public static Counter Switchcounter = new Counter(SwitchlimitSwitch);

	public static DigitalInput VaultlimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_VAULT_LIMIT);
	public static Counter Vaultcounter = new Counter(VaultlimitSwitch);

 	public static DigitalInput BottomlimitSwitch = new DigitalInput(RobotMap.DIO_ELEVATOR_BOTTOM_LIMIT);
 	public static Counter Bottomcounter = new Counter(BottomlimitSwitch);
     

     public static int Location = 0; 
     
     public void debug() {
     	System.out.print("LimitSwitch1Volts:");
     	System.out.println(LimitSwitch1.getVoltage());
     	System.out.print("LimitSwitch1Raw:");
     	System.out.println(LimitSwitch1.getValue());
     }

    
	//Creating ElevatorMotor from Talon with port zero
	 Talon ElevatorMotor = new Talon(RobotMap.ELEVATOR_TALON);
    //TODO - Put in and set the correct motor for the code.

    public static boolean isSwitchSetScale() 
    {
        return Scalecounter.get() > 0;
    }

    
    public static boolean isSwitchSetSwitch() 
    {
        return Switchcounter.get() > 0;
    }

    
    public static boolean isSwitchSetBottom() 
    {
        return Bottomcounter.get() > 0;
    }
    

    public static boolean isSwitchSetVault() 

    {

        return Vaultcounter.get() > 0;

    }

    

    

    public void initializeCounter() 

    {
        Scalecounter.reset();
        Bottomcounter.reset();
        Switchcounter.reset();
        Vaultcounter.reset();
    }



    

	protected void initDefaultCommand()

	{



	}

	
	// TODO - Put in a reset mechanism of sorts so that the elevator motor can stop and reset it's counter
	// TODO - Fill in the commands and have them functioning
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
	
//	private int rise = 1;
//	private int lower = -1;
	private int reset = 0;
	
	//Rise and Lower commands left in in case we need to make micro adjustments.
/*
    public void ElevatorRise()
    {
    	//Make the elevator rise
    	//One motor will be available
    	ElevatorMotor.set(rise);
    }
    public void ElevatorLower()
    {
    	//Make the Elevator lower
    	ElevatorMotor.set(lower);
    }
*/
    public void ElevatorReset()

    {
    	//Tell Elevator to stop running
    	ElevatorMotor.set(reset);
    }
    }


