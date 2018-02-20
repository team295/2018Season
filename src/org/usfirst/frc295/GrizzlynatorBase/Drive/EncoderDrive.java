package org.usfirst.frc295.GrizzlynatorBase.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc295.GrizzlynatorBase.Drive.CheesyDriveHelper;

public class EncoderDrive {
	public static double motorCorrect(double DSpeed) {
		double DVoltage = 0;
		int LPWFXNsegment; //Linear Piecewise function segment number: which part of the piecewise are we looking at
		if(DSpeed > -1 && DSpeed <= -.75) {
			LPWFXNsegment = 0;
		} else if(DSpeed > -.75 && DSpeed <= -.5) {
			LPWFXNsegment = 1;
		} else if(DSpeed > -.5 && DSpeed <= -.25) {
			LPWFXNsegment = 2;
		} else if(DSpeed > -.25 && DSpeed <= 0) {
			LPWFXNsegment = 3;
		} else if(DSpeed > 0 && DSpeed <= .25) {
			LPWFXNsegment = 4;
		} else if(DSpeed > .25 && DSpeed <= .5) {
			LPWFXNsegment = 5;
		} else if(DSpeed > .5 && DSpeed <= .75) {
			LPWFXNsegment = 6;
		} else if(DSpeed > .75 && DSpeed <= 1) {
			LPWFXNsegment = 7;
		} else {
			LPWFXNsegment = -295;
		}
		switch(LPWFXNsegment) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			DVoltage = 10 * DSpeed;
			break;
		case -295:
			DVoltage = 0;
			break;
		
		}
		return DVoltage;
	}

	
		

}
