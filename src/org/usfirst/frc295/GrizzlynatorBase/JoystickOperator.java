package org.usfirst.frc295.GrizzlynatorBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Different Joysticks have different button and Axis ID numbers The
 * JoystickDriver and JoystickOperator allows a call to get the proper button or
 * read a value from a button or axis
 *
 * For Each Joystick Type that needs a different mapping, Add a mapping.
 *
 * If the mapping is the same as the XBOX, a specific mapping is not required
 * and the default mapping (which is the same as the XBox) will be utilized.
 */
public class JoystickOperator extends Joystick
{

	// X-BOX OPERATOR JOYSTICK BUTTONS 
	//public static final short OPERATOR_BUTTON_SHOOT_XBOX = 1;
	//public static final short OPERATOR_BUTTON_ELEVATOR_RISE_XBOX = 1; //BUTTON A OPERATOR
	//public static final short OPERATOR_BUTTON_ELEVATOR_LOWER_XBOX = 2; //BUTTON B OPERATOR
	public static final short OPERATOR_BUTTON_ELEVATOR_TOPPRESET_XBOX = 1; //BUTTON A OPERATOR
	public static final short OPERATOR_BUTTON_ELEVATOR_BOTTOMPRESET_XBOX = 2; //BUTTON B OPERATOR


	// LOGITECH (IF DIFFERENT FROM XBOX) OPERATOR JOYSTICK BUTTONS
	//public static final short OPERATOR_BUTTON_SHOOT_LOGITECH = 1;
	//public static final short OPERATOR_BUTTON_ELEVATOR_RISE_LOGITECH = 1; 
	//public static final short OPERATOR_BUTTON_ELEVATOR_LOWER_LOGITECH = 2; 
	public static final short OPERATOR_BUTTON_ELEVATOR_TOPPRESET_LOGITECH = 1; //BUTTON A OPERATOR
	public static final short OPERATOR_BUTTON_ELEVATOR_BOTTOMPRESET_LOGITECH = 2; //BUTTON B OPERATOR

	public static enum JoystickType
	{
		XBOX(0), LOGITECH(1);

		public final int value;


		private JoystickType(int value)
		{
			this.value = value;
		}
	}

	JoystickType _eJoystickType = JoystickType.XBOX;


	public JoystickOperator(int iPort, JoystickType eType)
	{
		super(iPort);
		_eJoystickType = eType;
	}

	/*JoystickButton getShooterShootButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_SHOOT_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_SHOOT_XBOX));
		}
	}*/
	
	JoystickButton getElevatorTopButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_TOPPRESET_LOGITECH));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_TOPPRESET_LOGITECH));		
		}
	}
	
	JoystickButton getElevatorBottomButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_BOTTOMPRESET_LOGITECH));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_BOTTOMPRESET_LOGITECH));		
		}
	}

}
