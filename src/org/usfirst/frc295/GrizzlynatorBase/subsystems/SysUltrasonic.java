package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SysUltrasonic
{
//Write in a variable
	AnalogInput UltrasonicSensor1 = new AnalogInput(1);
	double conversionfactor = .009765625;
	
	double UltrasonicSensor1volts;
	double USsensor1DistanceInches;
	double FinalSensor1;
	
	int _Cycles = 0;
	int _ErrorCycles = 0;
	
	public double getDistance()
	{
		UltrasonicSensor1volts = UltrasonicSensor1.getVoltage();
		USsensor1DistanceInches = UltrasonicSensor1volts / conversionfactor;
		
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
						
//		System.out.println(FinalSensor1 + " in");
		
		return FinalSensor1;
	}
}