package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SysUltrasonic
{
//Write in a variable
	AnalogInput UltrasonicSensor1 = new AnalogInput(1);

	
	double UltrasonicSensor1volts;
	double USsensor1DistanceInches;
	double FinalSensor1;
	public double Distance;
	
	int _Cycles = 0;
	int _ErrorCycles = 0;

	double conversionfactor = .009765625;
	
	public double getDistance()
	{
		UltrasonicSensor1volts = UltrasonicSensor1.getVoltage();

		//Filters out any outliers
		if ((Math.abs(FinalSensor1 - USsensor1DistanceInches)) < 15)
		{
			if ((_Cycles == 0) || (_ErrorCycles > 5))
			{
				FinalSensor1 = USsensor1DistanceInches;
				_ErrorCycles = 0;
			}
		}
		else
		{
			_ErrorCycles = _ErrorCycles + 1;
		}
		
		Distance = FinalSensor1;
				
		System.out.println(Distance + " in");
		
		return Distance;
	}
}