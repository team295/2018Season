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
		BOT_COMP0(0), BOT_PROTO(1), BOT_FORKLIFT(2), BOT_COMP1(3), BOT_COMP2(4);
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
	
	public static final short PCM_DRIVE_SHIFT_1 = 3;
	public static final short PCM_DRIVE_SHIFT_2 = 4;
	
	public static final short PCM_ELEVATOR_SOL_FOLLOW = 7;
	public static final short PCM_ELEVATOR_SOL        = 0;
	
	public static final short CAN_PCM_MODULE = 0;
	public static final short CAN_PCM_PORT_DRIVE_SHIFTER = 1;
	public static final short CAN_ESC_DRIVE_LEFT_FRONT   = 3;
	public static final short CAN_ESC_DRIVE_LEFT_BACK    = 4;
	public static final short CAN_ESC_DRIVE_RIGHT_FRONT  = 5;
	public static final short CAN_ESC_DRIVE_RIGHT_BACK   = 6;

	public static final short PWM_ESC_LEFT_INTAKE_MOTOR  = 1;
	public static final short PWM_ESC_RIGHT_INTAKE_MOTOR = 2;
	public static final short PWM_ELEVATOR_SPARK         = 0;
	
	public static final short RLY_GREENLIGHT             = 0;
	public static final short RLY_FLASHLIGHT             = 1;

	public static final short DIO_ENC_DRIVE_LEFT_CHAN1 = 0;
	public static final short DIO_ENC_DRIVE_LEFT_CHAN2 = 1;
	public static final short DIO_ENC_DRIVE_RIGHT_CHAN1= 2;
	public static final short DIO_ENC_DRIVE_RIGHT_CHAN2= 3;
	public static final short DIO_ENC_ELEVATOR_CHAN1   = 4;
	public static final short DIO_ENC_ELEVATOR_CHAN2   = 5;
	public static final short DIO_ELEVATOR_SCALE_LIMIT=  6;
	public static final short DIO_ELEVATOR_VAULT_LIMIT=  7;
	public static final short DIO_ELEVATOR_SWITCH_LIMIT= 8;
	public static final short DIO_ELEVATOR_BOTTOM_LIMIT= 9;
	// SYS DRIVETRAIN PARAMETERS
	public static final double DRIVE_WHEEL_DIAMETER = 5.0;
	public static final double DRIVE_LOW_GEAR_MAX_SPEED_INCH_PER_SEC = 12.0 * 7.0;
	public static final double DRIVE_KP = 0.03;
	public static final double DRIVE_KI = 0.00;
	public static final double DRIVE_KD = 0.00;
	public static final double DRIVE_KF = 0.00;
	public static final double RISE = 0.7;
	public static final double LOWER = -0.1;
	public static final double ZERO = 0.0;
	
	// LOOPER PARAMETERS
	public static final double LOOPER_PERIOD_HZ = 50;
	public static final short TBD = 0;

	public static void init()
	{
	}
}
