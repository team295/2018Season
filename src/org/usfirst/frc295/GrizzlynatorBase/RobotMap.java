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

import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is used to organize constants used in the program. Provides
 * easily recognizable names for the values Constants will usually map the pins
 * for sensors and actuators This provides flexibility in changing the wiring,
 * Significantly reduces the possibility of multiple allocation.
 */
public class RobotMap
{

	// ALLOW FOR ROBOT SPECIFIC CONFIGURATION
	public static enum RobotID
	{
		BOT_PROTO(1), BOT_FORKLIFT(2), BOT_COMP1(3), BOT_COMP2(4);
		private int id;


		RobotID(int id)
		{
			this.id = id;
		}


		public int getId()
		{
			return id;
		}
	}

	// SPECIFY WHICH ROBOT WE ARE RUNNING
	public static final RobotID ROBOT_ID = RobotID.BOT_COMP1;

	// CAN IDs ARE UNIQUE PER DEVICE TYPE
	public static final short CAN_ESC_DRIVE_LEFT_FRONT = 5;
	public static final short CAN_ESC_DRIVE_LEFT_BACK = 6;
	public static final short CAN_ESC_DRIVE_RIGHT_FRONT = 4;
	public static final short CAN_ESC_DRIVE_RIGHT_BACK = 3;
	public static final short CAN_ESC_LIFT_MASTER = 5;
	public static final short CAN_ESC_LIFT_SLAVE = 6;
	public static final short CAN_ESC_FLYWHEEL_MASTER = 10;
	public static final short CAN_ESC_FLYWHEEL_SLAVE = 11;

	public static final short CAN_PCM_MODULE = 0;
	public static final short CAN_PCM_PORT_DRIVE_SHIFTER = 1;

	// PWM PINS (0 - 20)
	public static final short PWM_ESC_DRIVE_LEFT_FRONT = 0;
	public static final short PWM_ESC_DRIVE_LEFT_BACK = 1;
	public static final short PWM_ESC_DRIVE_RIGHT_FRONT = 2;
	public static final short PWM_ESC_DRIVE_RIGHT_BACK = 3;

	// DIGITAL IO PINS
	public static final short DIO_ENC_DRIVE_RIGHT_CHAN1 = 0;
	public static final short DIO_ENC_DRIVE_RIGHT_CHAN2 = 1;
	public static final short DIO_ENC_DRIVE_LEFT_CHAN1 = 2;
	public static final short DIO_ENC_DRIVE_LEFT_CHAN2 = 3;

	// RELAY PINS
	public static final short RLY_GREENLIGHT = 0;
	public static final short RLY_FLASHLIGHT = 1;
	
	//SYS ELEVATOR PROPERTIES
	public static final int ELEVATOR_TALON = 0;
	public static final int RISE = 1;
	public static final int LOWER = -1;
	public static final int ZERO = 0;


	// SYS FLYWHEEL PARAMETERS
	public static final double FLYWHEEL_SPEED_KP = 0.12;
	public static final double FLYWHEEL_SPEED_KI = 0;
	public static final double FLYWHEEL_SPEED_KD = 0.5;
	public static final double FLYWHEEL_SPEED_KF = 0.014;
	public static final int FLYWHEEL_SPEED_IZONE = (int) (1023.0 / FLYWHEEL_SPEED_KP);
	public static final double FLYWHEEL_SPEED_RAMP_RATE = 0;
	public static final double FLYWHEEL_SPEED_ONTARGET_TOLERANCE = 100.0;

	public static final double FLYWHEEL_POSITION_KP = 0.12;
	public static final double FLYWHEEL_POSITION_KI = 0;
	public static final double FLYWHEEL_POSITION_KD = 0.5;
	public static final double FLYWHEEL_POSITION_KF = 0.014;
	public static final int FLYWHEEL_POSITION_IZONE = (int) (1023.0 / FLYWHEEL_POSITION_KP);
	public static final double FLYWHEEL_POSITION_RAMP_RATE = 0;
	public static final double FLYWHEEL_POSITION_ONTARGET_TOLERANCE = 100.0;

	// SYS DRIVETRAIN PARAMETERS
	public static final double DRIVE_WHEEL_DIAMETER = 5.0;
	public static final double DRIVE_LOW_GEAR_MAX_SPEED_INCH_PER_SEC = 12.0 * 7.0;
	public static final double DRIVE_KP = 0.03;
	public static final double DRIVE_KI = 0.00;
	public static final double DRIVE_KD = 0.00;
	public static final double DRIVE_KF = 0.00;

	// LOOPER PARAMETERS
	public static final double LOOPER_PERIOD_HZ = 50;

	public static final short TBD = 0;


	public static void init()
	{
	}
}
