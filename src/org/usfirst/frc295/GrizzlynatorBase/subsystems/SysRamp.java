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

