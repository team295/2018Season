package org.usfirst.frc295.GrizzlynatorBase.commands;

import org.usfirst.frc295.GrizzlynatorBase.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.*;
public class WaypointCube extends Command
{
	
	NetworkTableInstance inst = NetworkTableInstance.getDefault();
	NetworkTable oNetTable = inst.getTable("VisionBoard");
	NetworkTableEntry xEntry;
	double Location;
	static double Kp = .023;
	

	public void Cube()
	{
		
		requires(Robot.sysDriveTrain);
	}
	public void initialize()
	{
		Robot.sysDriveTrain.reset();
		Robot.ahrs.reset();
		xEntry = oNetTable.getEntry("iBox");
		
		
	}
	public void execute()
	{
		double iBox = 0;
//		System.out.print("iBox Value===");
		iBox = xEntry.getDouble(9999);
		Location = iBox;
//		System.out.println(iBox);
		if (iBox == 0)
		{
			System.out.println("Center");
		}
		else if (iBox == -1)
		{
			System.out.println("Left");
			Robot.sysDriveTrain.arcadeDrive(-.5, -(5*Kp));
		}
		else if (iBox == 1)
		{
			System.out.println("Right");	
			Robot.sysDriveTrain.arcadeDrive(.5, -(5*Kp));
		}
		else 
		{
			System.out.println("Jank");
		}
		
		
	}
	@Override
	protected boolean isFinished() 
	{
		// TODO Auto-generated method stub
		return(Location == 0);

	}
	

}
