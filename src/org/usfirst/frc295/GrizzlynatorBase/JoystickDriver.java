package org.usfirst.frc295.GrizzlynatorBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Different Joysticks have different button and Axis ID numbers
 * The JoystickDriver and JoystickOperator allows a call to get 
 * the proper button or read a value from a button or axis
 *
 * For Each Joystick Type that needs a different mapping,
 * Add a mapping.
 * 
 * If the mapping is the same as the XBOX, a specific mapping is 
 * not required and the default mapping (which is the same as the XBox)
 * will be utilized.
 */
public class JoystickDriver extends Joystick 
{
	
	// X-BOX DRIVER JOYSTICK BUTTONS
	public static final   short  DRIVER_AXIS_THROTTLE_XBOX            = 1;
	public static final   short  DRIVER_AXIS_TURN_XBOX                = 4;
	
	public static final   short  DRIVER_BUTTON_SHIFT_HIGH_XBOX        = 1;
	public static final   short  DRIVER_BUTTON_SHIFT_LOW_XBOX         = 2;
	public static final   short  DRIVER_BUTTON_QUICKTURN_XBOX         = 6;
	
	
	// LOGITECH (IF DIFFERENT FROM XBOX) DRIVER JOYSTICK BUTTONS
	public static final   short  DRIVER_AXIS_THROTTLE_LOGITECH        = 1;
	public static final   short  DRIVER_AXIS_TURN_LOGITECH            = 4;
	
	public static final   short  DRIVER_BUTTON_SHIFT_HIGH_LOGITECH    = 1;
	public static final   short  DRIVER_BUTTON_SHIFT_LOW_LOGITECH     = 2;
	public static final   short  DRIVER_BUTTON_QUICKTURN_LOGITECH     = 6;

	
	
	public static enum JoystickType
	{ 
		XBOX(0),
		LOGITECH(1);

 		public final int value; 

		private JoystickType(int value) 
		{ 
			this.value = value; 
		} 
	} 

	
	
	JoystickType _eJoystickType = JoystickType.XBOX;
	public JoystickDriver(int iPort, JoystickType eType) 
	{
		super(iPort);
		_eJoystickType = eType;
	}
	
	
	public JoystickButton getDriveTrainShifterSetLowButton()
	{
		switch(_eJoystickType)
		{
			case XBOX:
				return(new JoystickButton(this,DRIVER_BUTTON_SHIFT_LOW_XBOX));
			case LOGITECH:
				return(new JoystickButton(this,DRIVER_BUTTON_SHIFT_LOW_LOGITECH));
							
			default:
				return(new JoystickButton(this,DRIVER_BUTTON_SHIFT_LOW_XBOX));	
		}
	}
	
	
	public JoystickButton getDriveTrainShifterSetHighButton()
	{
		switch(_eJoystickType)
		{
			case XBOX:
				return(new JoystickButton(this,DRIVER_BUTTON_SHIFT_HIGH_XBOX));
			
			case LOGITECH:
				return(new JoystickButton(this,DRIVER_BUTTON_SHIFT_HIGH_LOGITECH));
			
			default:
				return(new JoystickButton(this,DRIVER_BUTTON_SHIFT_HIGH_XBOX));	
		}
	}


	public double getDriveTrainThrottleValue()
	{
		switch(_eJoystickType)
		{
			case XBOX:
				return(this.getRawAxis(DRIVER_AXIS_THROTTLE_XBOX));
			
			case LOGITECH:
				return(this.getRawAxis(DRIVER_AXIS_THROTTLE_LOGITECH));
			
			default:
				return(this.getRawAxis(DRIVER_AXIS_THROTTLE_XBOX));
		}
	}

	
	
	public double getDriveTrainTurnValue()
	{
		switch(_eJoystickType)
		{
			case XBOX:
				return(this.getRawAxis(DRIVER_AXIS_TURN_XBOX));
			
			case LOGITECH:
				return(this.getRawAxis(DRIVER_AXIS_TURN_LOGITECH));
			
			default:
				return(this.getRawAxis(DRIVER_AXIS_TURN_XBOX));
		}
	}
	
	
	public boolean getDriveTrainQuickTurnValue()
	{
		switch(_eJoystickType)
		{
			case XBOX:
				return(this.getRawButton(DRIVER_BUTTON_QUICKTURN_XBOX));
			
			case LOGITECH:
				return(this.getRawButton(DRIVER_BUTTON_QUICKTURN_LOGITECH));
			
			default:
				return(this.getRawButton(DRIVER_BUTTON_QUICKTURN_XBOX));
		}
	}
}
