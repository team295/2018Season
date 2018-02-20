package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import org.usfirst.frc295.GrizzlynatorBase.commands.CmdRampdflt;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
//import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class SysRamp extends Subsystem {
	private final DoubleSolenoid.Value RETRACT_SOLENOID = DoubleSolenoid.Value.kReverse;
	private final DoubleSolenoid.Value EXTEND_SOLENOID = DoubleSolenoid.Value.kForward;

	private Servo RRamp = new Servo(1);
	private Servo LRamp = new Servo(2);


//	private DoubleSolenoid RDS = new DoubleSolenoid(5,6);
//	private DoubleSolenoid LDS = new DoubleSolenoid(7,8);

	private DoubleSolenoid RDS;
	private DoubleSolenoid LDS;

	public boolean hasOpened(short pin) {
		if (pin == 1) {
			if(RRamp.getAngle() > 270) {
				return true;
			} else {
				return false;
			}
		} else if (pin == 2) {
			if(LRamp.getAngle() > 270) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	

	public void RUnlatch() {
		RRamp.set(1);
	}

	public void LUnlatch() {
		RRamp.set(1);
	}

	public void RBoop() {
		RDS.set(EXTEND_SOLENOID);
	}
	
	public void LBoop() {
		LDS.set(EXTEND_SOLENOID);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CmdRampdflt());
	}
}

