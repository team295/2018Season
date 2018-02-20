package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.Robot;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SysRamp extends Subsystem{



	private DoubleSolenoid RightSideMain = new DoubleSolenoid(RobotMap.PCM_RIGHT_SOL, RobotMap.PCM_RIGHT_SOL_FOLLOW);
	private DoubleSolenoid LeftSideMain = new DoubleSolenoid(RobotMap.PCM_LEFT_SOL,RobotMap.PCM_LEFT_SOL_FOLLOW);
	private DoubleSolenoid PushoutMain = new DoubleSolenoid(RobotMap.PCM_TOP_SOL, RobotMap.PCM_TOP_SOL_FOLLOW);
	private final DoubleSolenoid.Value RETRACT_SOLENOID = DoubleSolenoid.Value.kReverse;
	private final DoubleSolenoid.Value EXTEND_SOLENOID = DoubleSolenoid.Value.kForward;
<<<<<<< HEAD
=======

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
>>>>>>> Added joystick interception for TOP and drive straight, still need to tweak drive straight correction
	
	
	public void OpenRamp(){
		PushoutMain.set(EXTEND_SOLENOID);

	}
	
	public void RampRightOpen(){
		RightSideMain.set(EXTEND_SOLENOID);
		 	
	}
	
	public void RampLeftOpen(){
		LeftSideMain.set(EXTEND_SOLENOID);
	}
	
	public void PushupBoth(){
		RightSideMain.set(EXTEND_SOLENOID);
		LeftSideMain.set(EXTEND_SOLENOID);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
