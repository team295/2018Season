
package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class SysElevator extends Subsystem
{
	 public static DigitalInput ScalelimitSwitch = new DigitalInput(4);
     public static Counter Scalecounter = new Counter(ScalelimitSwitch);

	 public static DigitalInput BottomlimitSwitch = new DigitalInput(2);
     public static Counter Bottomcounter = new Counter(BottomlimitSwitch);
     
	 public static DigitalInput VaultlimitSwitch = new DigitalInput(1);
     public static Counter Vaultcounter = new Counter(VaultlimitSwitch);
     
	 public static DigitalInput SwitchlimitSwitch = new DigitalInput(3);
     public static Counter Switchcounter = new Counter(SwitchlimitSwitch);
     
     public static int Location = 0; 
     
	//Creating ElevatorMotor from Talon with port zero
	Talon ElevatorMotor = new Talon(RobotMap.ELEVATOR_TALON);
	
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

}
