package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SysInfraredSensor extends Subsystem {

	double conversionfactor = .009765625;

	AnalogInput InfraredSensor1 = new AnalogInput(0);
	int InfraredSensor1raw;
	double InfraredSensor1volts;
	public double IRsensor1DistanceInches;

	public static double FinalSensor1;

	int _Cycles = 0;
	int _ErrorCycles = 0;

	public double getDistance()
	{
		InfraredSensor1raw = InfraredSensor1.getValue();
		InfraredSensor1volts = InfraredSensor1.getVoltage();
		IRsensor1DistanceInches = InfraredSensor1volts / conversionfactor;

		if ((Math.abs(FinalSensor1 - IRsensor1DistanceInches) < 15))			
		{
			if ((_Cycles == 0) || (_ErrorCycles > 5))
			{

				FinalSensor1 = IRsensor1DistanceInches;
				_ErrorCycles = 0;
			}
		}
		else
		{
			_ErrorCycles = _ErrorCycles + 1;
		}

		double Dist = IRsensor1DistanceInches;

		return Dist;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

