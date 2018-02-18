package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SysUltrasonic
{
	double conversionfactor = .009765625;

	AnalogInput UltrasonicSensor1 = new AnalogInput(1);
	
	int UltrasonicSensor1raw;
	double UltrasonicSensor1volts;
	public double USsensor1DistanceInches;

	public static double FinalSensor1;

	int _Cycles = 0;
	int _ErrorCycles = 0;

	double Dist;

	public double getDistance()
	{
		UltrasonicSensor1raw = UltrasonicSensor1.getValue();
		UltrasonicSensor1volts = UltrasonicSensor1.getVoltage();
		USsensor1DistanceInches = UltrasonicSensor1volts / conversionfactor;

		//Filters out any outliers
//		
//		if ((Math.abs(FinalSensor1 - USsensor1DistanceInches) < 15))
//				
//		{
//			if ((_Cycles == 0) || (_ErrorCycles > 5))
//			{
//
//				FinalSensor1 = USsensor1DistanceInches;
//				_ErrorCycles = 0;
//			}
//		}
//		else
//		{
//			_ErrorCycles = _ErrorCycles + 1;
//		}

//		Dist = FinalSensor1;

		Dist = USsensor1DistanceInches;
				
		System.out.println(Dist + " in");
		
		return Dist;
	}
}