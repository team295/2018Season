package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SysUltrasonic
{

	boolean isPerpendicular = false;
	double conversionfactor = .009765625;

	AnalogInput UltrasonicSensor1 = new AnalogInput(0);
	int iUltrasonicSensor1raw;
	double UltrasonicSensor1volts;
	public double USsensor1DistanceInches;

	public double FinalSensor1;

	int _Cycles = 0;
	int _ErrorCycles = 0;


	public double getAverageDistance()
	{
		iUltrasonicSensor1raw = UltrasonicSensor1.getValue();
		UltrasonicSensor1volts = UltrasonicSensor1.getVoltage();
		USsensor1DistanceInches = UltrasonicSensor1volts / conversionfactor;

		if ((Math.abs(FinalSensor1 - USsensor1DistanceInches) < 15))
				
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

		double dAvgDist = USsensor1DistanceInches;
		SmartDashboard.putNumber("Ultrasonic: GetAverageDistance", dAvgDist);

		return dAvgDist;
	}
	
	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void logToSmartDashboard()
	{
		// SmartDashboard.putData("vibrate", new CmdHapticFeedback());
		SmartDashboard.putNumber("Ultrasonic: Right Distance inches", UltrasonicSensor1.getVoltage() / conversionfactor );
	}

	
}