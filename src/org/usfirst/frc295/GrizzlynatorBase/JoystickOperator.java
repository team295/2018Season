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
	public static final short OPERATOR_BUTTON_SHOOT_XBOX = 1;

	public static final short OPERATOR_BUTTON_AUTOINTAKE_XBOX = 2;
	
	public static final short OPERATOR_JoyStick_INTAKECUBE_XBOX = 1;	
//	public static final short OPERATOR_BUTTON_MANUALINTAKECUBE_XBOX = 7;
//	public static final short OPERATOR_BUTTON_MANUALDROPCUBE_XBOX = 8;
	
	// LOGITECH (IF DIFFERENT FROM XBOX) OPERATOR JOYSTICK BUTTONS
	public static final short OPERATOR_BUTTON_SHOOT_LOGITECH = 1;

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


	JoystickButton getShooterShootButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_SHOOT_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_SHOOT_XBOX));
		}
	}

	JoystickButton getAutoIntake()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_AUTOINTAKE_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_AUTOINTAKE_XBOX));
		}
	}
	
//	JoystickButton getManualIntakeCubeButton() 
//	{
//		switch (_eJoystickType)
//		{
//		case XBOX:
//			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALINTAKECUBE_XBOX));
//
//		default:
//			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALINTAKECUBE_XBOX));
//		}
//	}
//	
//	JoystickButton getManualDropCubeButton() 
//	{
//		switch (_eJoystickType)
//		{
//		case XBOX:
//			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALDROPCUBE_XBOX));
//
//		default:
//			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALDROPCUBE_XBOX));
//		}
//	}
	
	public double getIntakeYAxis(){
		switch (_eJoystickType) 
		{
		case XBOX:
			return (this.getRawAxis(OPERATOR_BUTTON_SHOOT_XBOX));
		default:
			return (this.getRawAxis(OPERATOR_BUTTON_SHOOT_XBOX));
		}
	}
	
}
