
package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap.ElevatorState;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
/**
 *
 */
public class SysElevator extends Subsystem
{
	
	 private static DigitalInput ScalelimitSwitch;
     private Counter Scalecounter;
     
	 private static DigitalInput BottomlimitSwitch;
     private Counter Bottomcounter;
     
	 private static DigitalInput VaultlimitSwitch;
     private Counter Vaultcounter;
     
	 private static DigitalInput SwitchlimitSwitch;
     private Counter Switchcounter;
     
     private ElevatorState currentElevatorState;
     public static int Location;
     private static SysElevator instance;
     
     private boolean debugmode;
	 Talon ElevatorMotor;
	

	//Constructor
	private SysElevator()
	{
		debugmode = false;
		
		//TODO create variables for inputs in robotmap
		DigitalInput ScalelimitSwitch = new DigitalInput(9);
		Counter Scalecounter = new Counter(ScalelimitSwitch);
		
		DigitalInput BottomlimitSwitch = new DigitalInput(8);
		Counter Bottomcounter = new Counter(BottomlimitSwitch);
		
		DigitalInput VaultlimitSwitch = new DigitalInput(0);
		Counter Vaultcounter = new Counter(VaultlimitSwitch);
		
		DigitalInput SwitchlimitSwitch = new DigitalInput(0);
		Counter Switchcounter = new Counter(SwitchlimitSwitch);
		
		Location = 0; 
		SysElevator instance = null;
		
		ElevatorMotor = new Talon(RobotMap.ELEVATOR_TALON);
	}
	
	public static SysElevator getInstance()
	{
		if (instance == null)
		{
			instance = new SysElevator();
		}
		
		return instance;
	}
	
    public boolean isSwitchSetScale() 
    {
        return Scalecounter.get() > 0;
    }
    
    public boolean isSwitchSetSwitch() 
    {
        return Switchcounter.get() > 0;
    }
      
    public boolean isSwitchSetBottom() 
    {
        return Bottomcounter.get() > 0;
    }
    
    public boolean isSwitchSetVault() 
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
	
	public void OperateElevator(ElevatorState stateToGoTo)
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
					System.out.println("Motor Running");
				}
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
				}
			case 2 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
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
					System.out.println("Motor Running");
				}
			case 1 :
				ElevatorMotor.set(RobotMap.RISE);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
				}
			case 2 :
				
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
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
					System.out.println("Motor Running");
				}			
			case 1 :
				
			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
				}
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
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
					System.out.println("Motor Running");
				}
			case 2 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
				}
			case 3 :
				ElevatorMotor.set(RobotMap.LOWER);
				if (debugmode = true) 
				{
					System.out.println("Motor Running");
				}

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

}
