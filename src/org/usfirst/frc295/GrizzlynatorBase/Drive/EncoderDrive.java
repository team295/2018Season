package org.usfirst.frc295.GrizzlynatorBase.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc295.GrizzlynatorBase.Drive.CheesyDriveHelper;

import org.usfirst.frc295.GrizzlynatorBase.Drive.CheesyDriveHelper;

public class EncoderDrive {
//	public static double motorCorrect(double DSpeed) {
//		double DVoltage = 0;
//		int LPWFXNsegment; //Linear Piecewise function segment number: which part of the piecewise are we looking at
//		if(DSpeed > -1 && DSpeed <= -.75) {
//			LPWFXNsegment = 0;
//		} else if(DSpeed > -.75 && DSpeed <= -.5) {
//			LPWFXNsegment = 1;
//		} else if(DSpeed > -.5 && DSpeed <= -.25) {
//			LPWFXNsegment = 2;
//		} else if(DSpeed > -.25 && DSpeed <= 0) {
//			LPWFXNsegment = 3;
//		} else if(DSpeed > 0 && DSpeed <= .25) {
//			LPWFXNsegment = 4;
//		} else if(DSpeed > .25 && DSpeed <= .5) {
//			LPWFXNsegment = 5;
//		} else if(DSpeed > .5 && DSpeed <= .75) {
//			LPWFXNsegment = 6;
//		} else if(DSpeed > .75 && DSpeed <= 1) {
//			LPWFXNsegment = 7;
//		} else {
//			LPWFXNsegment = -295;
//		}
//		switch(LPWFXNsegment) {
//		case 0:
//		case 1:
//		case 2:
//		case 3:
//		case 4:
//		case 5:
//		case 6:
//		case 7:
//			DVoltage = 10 * DSpeed;
//			break;
//		case -295:
//			DVoltage = 0;
//			break;
//		
//		}
//		return DVoltage;
//	}
	public static DriveSignal EncoderDriveStraight(double SDiff, double Speed, DriveSignal Signal) {
		//NT = Needs Tweaking/Testing
		final double CC = .95; //CC = Correction Constant - NT //May need to be a piecewise function
		final double EncoCC = .25; // Encoder Correction Constant - NT
		final double PerDis = .05; //Threshold of difference between motor speeds
		if(Math.abs(SDiff) > Speed * PerDis) {
			if(SDiff > 0) {
				Signal.leftMotor = CheesyDriveHelper.percent(Signal.leftMotor * CC * EncoCC * Math.abs(SDiff), 1, 1);
				Signal.rightMotor = CheesyDriveHelper.percent(Signal.rightMotor / (CC * EncoCC * Math.abs(SDiff)), 1, 1);
			} else if(SDiff < 0) {
				Signal.rightMotor = CheesyDriveHelper.percent(Signal.rightMotor * CC * EncoCC * Math.abs(SDiff), 1, 1);
				Signal.leftMotor = CheesyDriveHelper.percent(Signal.leftMotor / (CC * EncoCC * Math.abs(SDiff)), 1, 1);
			}
		}
		return Signal;
	}
	//The motors may need to be corrected for any speed differences
	public static DriveSignal EncoderDriveTOP(DriveSignal Signal, double TurnSpeed) {
		Signal.rightMotor = CheesyDriveHelper.getSign(TurnSpeed) * CheesyDriveHelper.limit(TurnSpeed, 1.0);
		Signal.leftMotor = CheesyDriveHelper.getSign(TurnSpeed) * -1 * CheesyDriveHelper.limit(TurnSpeed, 1.0);
		return Signal;
	}


}
