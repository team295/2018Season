//// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc295.GrizzlynatorBase;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap.RobotID;
import org.usfirst.frc295.GrizzlynatorBase.Logger.Logger;
import org.usfirst.frc295.GrizzlynatorBase.Looper.Looper;
import org.usfirst.frc295.GrizzlynatorBase.commands.AutonomousLeft;
import org.usfirst.frc295.GrizzlynatorBase.commands.AutonomousRight;
import org.usfirst.frc295.GrizzlynatorBase.commands.AutonomousMiddle;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.NavX_Gyro;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysCompressor;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysElevator;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysDriveTrain;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysDriveTrainCANOpenLoop;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysDriveTrainShifter;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysUltrasonic;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysIntake;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.SysUltrasonic;
import org.usfirst.frc295.GrizzlynatorBase.subsystems.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;







/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{

	// Enabled looper is called at 50Hz whenever the robot is enabled
	public static Looper _EnabledLooper = new Looper(RobotMap.LOOPER_PERIOD_HZ);
	// Disabled looper is called at 50Hz whenever the robot is disabled
	public static Looper _DisabledLooper = new Looper(RobotMap.LOOPER_PERIOD_HZ);

	Command autonomousCommand;
	SendableChooser chooser;
	public static String gameData;
	// Operator Interface from OJ.java
	public static OI oi;
	public static NavX_Gyro ahrs;
//	public static DigitalInput dioRobotID1;
//	public static DigitalInput dioRobotID2;

	// MAJOR SUBSYSTEMS
	public static SysDriveTrainCANOpenLoop sysDriveTrainCAN;
	public static SysDriveTrain sysDriveTrain;
	public static SysDriveTrainCANOpenLoop sysCANLoop;
//	public static SysDriveTrainShifter sysDriveTrainShifter;
	public static SysElevator sysElevator;
	public static SysCompressor sysCompressor;
	public static SysRamp sysRamp;
	public static SysUltrasonic sysUltrasonic;
	public static SysIntake sysIntake;
	public static SysDriveTrainShifter sysDriveTrainShifter;



	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		try
		{ 
			Logger.logRobotInit();
			RobotMap.init();
			
			 			 
			// INSTANTIATE SUB-SYSTEMS FOR THE ROBOT
			if (RobotMap.ROBOT_ID == RobotID.BOT_COMP1)
			{
				//sysDriveTrain = new SysDriveTrainSpark();
				sysDriveTrain = new SysDriveTrainCANOpenLoop();
//				sysIntake = new SysIntake();
				sysIntake = SysIntake.getInstance();
				sysUltrasonic = new SysUltrasonic();
				sysDriveTrainShifter = new SysDriveTrainShifter();
//				sysDriveTrain = new SysDriveTrainSpark();
			}
			else if (RobotMap.ROBOT_ID == RobotID.BOT_COMP0)
			{
				sysDriveTrain = new SysDriveTrainCANOpenLoop();

			}
			else if (RobotMap.ROBOT_ID == RobotID.BOT_PROTO)
			{
//				sysDriveTrain = new SysDriveTrainProto();
			}
			else if (RobotMap.ROBOT_ID == RobotID.BOT_FORKLIFT)
			{
//				sysDriveTrain = new SysDriveTrainForklift();
			}

			sysCompressor = new SysCompressor();
			sysElevator = SysElevator.getInstance();
			sysDriveTrainShifter = new SysDriveTrainShifter();
			sysRamp = new SysRamp();
			// OI must be constructed after subsystems. If the OI creates
			// Commands
			// (which it very likely will), subsystems are not guaranteed to be
			// constructed yet. Thus, their requires() statements may grab null
			// pointers. Bad news. Don't move it.
			oi = new OI();
			ahrs = new NavX_Gyro();

			// TODO: Need to know how SendableChooser work
			
//			  chooser = new SendableChooser();
//			  chooser.addDefault("Default Auto", new AutonomousMiddle());
//			  chooser.addObject("Left Auto", new AutonomousLeft());
//			  chooser.addObject("Right Auto", new AutonomousRight());
//			  SmartDashboard.putData("Auto mode", chooser);
//			 

			// Show what command your subsystem is running on the SmartDashboard
			
		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}
	}


	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit()
	{
		try
		{
			Logger.logDisabledInit();

			// CONFIGURE LOOPERS
			_EnabledLooper.stop();
			_DisabledLooper.start();
		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}
		sysDriveTrain.logToSmartDashboard();
	}


	@Override
	public void disabledPeriodic()
	{
		try
		{
			System.out.print(ahrs.getYaw());
			System.out.print("  ");
			System.out.print(sysDriveTrain.getLeftEncoder());
			System.out.print("  ");
			System.out.println(sysDriveTrain.getRightEncoder());
//			System.out.println(input_dio.get());
			Scheduler.getInstance().run();
//			input_dio.get();
		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}

		sysIntake.IntakeState();

		sysDriveTrain.logToSmartDashboard();

//		sysEncoderDrive.getValues();


	}


	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit()
	{
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		try
		{
			Logger.logAutoInit();

			// Instantiate the command used for the autonomous period
			autonomousCommand = new AutonomousLeft();

			// TODO: How does the chooser work?
			// autonomousCommand = (Command) chooser.getSelected();

			// TODO: How does the SmartDashboard.getString work?
			/*
			 * String autoSelected = SmartDashboard.getString("Auto Selector",
			 * "Default"); switch(autoSelected) { case "My Auto":
			 * autonomousCommand = new MyAutoCommand(); break; case
			 * "Default Auto": default: autonomousCommand = new
			 * ExampleCommand(); break; }
			 */

			sysIntake.initAutoState();
			sysIntake.IntakeState();
			
			// CONFIGURE LOOPERS
			_EnabledLooper.stop();
			_DisabledLooper.start();

			// schedule the autonomous command (example)
			if (autonomousCommand != null)
			{
				autonomousCommand.start();
			}

		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}
	}


//	private void AutonomousLeft(String gameData) {
//		// TODO Auto-generated method stub
//		
//	}


	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic()
	{
		try
		{
			
			sysDriveTrain.logToSmartDashboard();
			sysIntake.IntakeState();
//			System.out.println(sysDriveTrain.getDistance());
//			System.out.println(sysDriveTrain.getInches());
//			System.out.println(ahrs.getAngle());
			Scheduler.getInstance().run();
			log();
		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}
	}


	@Override
	public void teleopInit()
	{
		try
		{
			Logger.logTeleopInit();
			sysElevator.compressoron();
			sysIntake.IntakeState();
			// This makes sure that the autonomous stops running when
			// teleop starts running. If you want the autonomous to
			// continue until interrupted by another command, remove
			// this line or comment it out.
			if (autonomousCommand != null)
			{
				autonomousCommand.cancel();
			}

			// CONFIGURE LOOPERS
			_EnabledLooper.stop();
			_DisabledLooper.start();

		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}
		
	}


	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic()
	{
		try
		{			
			Scheduler.getInstance().run();
			log();
			
		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}

		sysIntake.IntakeState();
//		sysEncoderDrive.getValues();

	}


	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic()
	{
		try
		{
//			LiveWindow.run();
		}
		catch (Throwable t)
		{
			Logger.logThrowable(t);
			throw t;
		}
	}


	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	private void log()
	{
		
	}

}
