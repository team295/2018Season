package org.usfirst.frc295.GrizzlynatorBase.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysDriveTrain;
import org.usfirst.frc295.GrizzlynatorBase.Robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class SysEncoderDrive extends Subsystem {


    Encoder EncoderR = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    Encoder EncoderL = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	


    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

