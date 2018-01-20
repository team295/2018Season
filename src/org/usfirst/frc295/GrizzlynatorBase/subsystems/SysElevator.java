
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
	 public static DigitalInput ToplimitSwitch = new DigitalInput(1);
     public static Counter Topcounter = new Counter(ToplimitSwitch);

	 public static DigitalInput BottomlimitSwitch = new DigitalInput(1);
     public static Counter Bottomcounter = new Counter(BottomlimitSwitch);
     
	//Creating ElevatorMotor from Talon with port zero
	Talon ElevatorMotor = new Talon(RobotMap.ELEVATOR_TALON);
	
    public static boolean isSwitchSetTop() 
    {
        return Topcounter.get() > 0;
    }
    
    public static boolean isSwitchSetBottom() 
    {
        return Bottomcounter.get() > 0;
    }
    
    public void initializeCounter() 
    {
        Topcounter.reset();
        Bottomcounter.reset();

    }

    
	protected void initDefaultCommand()
	{
		
	}
	
	public void ElevatorRise()
	{
		ElevatorMotor.set(RobotMap.RISE);
	}
	
	public void ElevatorLower()
	{
		ElevatorMotor.set(RobotMap.LOWER);
	}
	
	public void ElevatorReset()
	{
		ElevatorMotor.set(RobotMap.RESET);
	}

}
