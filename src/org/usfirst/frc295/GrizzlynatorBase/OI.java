// RobotBuilder Version: 2.0

//

// This file was generated by RobotBuilder. It contains sections of

// code that are automatically generated and assigned by robotbuilder.

// These sections will be updated in the future when you export to

// Java from RobotBuilder. Do not put any code or make any change in

// the blocks indicating autogenerated code or it will be lost on an

// update. Deleting the comments indicating the section will prevent

// it from being updated in the future.



package org.usfirst.frc295.GrizzlynatorBase;



import org.usfirst.frc295.GrizzlynatorBase.commands.AutonomousLeft;


//import org.usfirst.frc295.GrizzlynatorBase.commands.CmdDriveTrainShifterSetHigh;

//import org.usfirst.frc295.GrizzlynatorBase.commands.CmdDriveTrainShifterSetLow;

import org.usfirst.frc295.GrizzlynatorBase.commands.*;



import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI

{

	//// CREATING BUTTONS

	// One type of button is a joystick button which is any button on a

	//// joystick.

	// You create one by telling it which joystick it's on and which button

	// number it is.

	// Joystick stick = new Joystick(port);

	// Button button = new JoystickButton(stick, buttonNumber);



	// There are a few additional built in buttons you can use. Additionally,

	// by subclassing Button you can create custom triggers and bind those to

	// commands the same as any other Button.



	//// TRIGGERING COMMANDS WITH BUTTONS

	// Once you have a button, it's trivial to bind it to a button in one of

private JoystickDriver _joystickDriver = new JoystickDriver(0, JoystickDriver.JoystickType.XBOX);

	private JoystickOperator _joystickOperator = new JoystickOperator(1, JoystickOperator.JoystickType.XBOX);



	public OI()

	{


		SmartDashboard.putData("Autonomous Command", new AutonomousLeft());




		// =====================================================================

		// DRIVER JOYSTICK BUTTON COMMANDS

		// =====================================================================

//		JoystickButton _btnDriver1 = _joystickDriver.get();
//		 _btnDriver1.whenPressed(new );
		 
//		JoystickButton _btnDriver2 = _joystickDriver.get();
//		 _btnDriver2.whenPressed(new );
		
//		JoystickButton _btnDriver3 = _joystickDriver.get();
//		 _btnDriver3.whenPressed(new );
		 
//		JoystickButton _btnDriver4 = _joystickDriver.get();
//		 _btnDriver4.whenPressed(new );
		
		JoystickButton _btnDriver5 = _joystickDriver.getDriveTrainShifterSetHighButton();
		 _btnDriver5.whenPressed(new CmdDriveTrainShiftHighGear());
		 
	 	 JoystickButton _btnDriver6 = _joystickDriver.getDriveTrainShifterSetLowButton();
		 _btnDriver6.whenPressed(new CmdDriveTrainShiftLowGear());
		 
//		JoystickButton _btnDriver7 = _joystickDriver.get();
//		 _btnDriver7.whenPressed(new );
		 
//		JoystickButton _btnDriver8 = _joystickDriver.get();
//		 _btnDriver8.whenPressed(new );
		 
		JoystickButton _btnDriver9 = _joystickDriver.getTOPButton();
		 _btnDriver9.whenPressed(new CmdTurnOnPoint());
		 
		JoystickButton _btnDriver10 = _joystickDriver.getDriveStraightButton();
		 _btnDriver10.whenPressed(new CmdDriveStraight());


		// OPERATOR  BUTTON 

		 JoystickButton _btnOperator1 = _joystickOperator.getElevatorBottomButton();;
		 _btnOperator1.whenPressed(new CmdElevatorBottom());

		 JoystickButton _btnOperator2 = _joystickOperator.getElevatorVaultButton();;
		 _btnOperator2.whenPressed(new CmdElevatorVault());
		
		 JoystickButton _btnOperator3 = _joystickOperator.getElevatorSwitchButton();;
		 _btnOperator3.whenPressed(new CmdElevatorSwitch());

		 JoystickButton _btnOperator4 = _joystickOperator.getElevatorScaleButton();;
		 _btnOperator4.whenPressed(new CmdElevatorScale());

	 	 JoystickButton _btnOperator5 = _joystickOperator.getElevatorRiseButton();;
		 _btnOperator5.whenPressed(new CmdManualRise());
		 
	 	 JoystickButton _btnOperator6 = _joystickOperator.getElevatorLowerButton();;
		 _btnOperator6.whenPressed(new CmdManualLower());
		 
		JoystickButton _btnOpIntakeCube = _joystickOperator.getAutoIntake();
		_btnOpIntakeCube.whenPressed(new CmdIntakeCube());
				
		JoystickButton _btnOpManualIntakeCube = _joystickOperator.getManualIntakeCubeButton();
		_btnOpManualIntakeCube.whileHeld(new CmdManualIntakeCube());
				
		JoystickButton _btnOpManualDropCube = _joystickOperator.getManualDropCubeButton();
		_btnOpManualDropCube.whileHeld(new CmdManualDropCube());
	}

	public JoystickDriver getJoystickDriver()

	{

		return _joystickDriver;

	}


	public JoystickOperator getJoystickOperator()

	{

		return _joystickOperator;

	}

}