package org.usfirst.frc295.GrizzlynatorBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Different Joysticks have different button and Axis ID numbers The
 * JoystickOPERATOR and JoystickOperator allows a call to get the proper button or
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
	public static final short OPERATOR_BUTTON_ELEVATOR_BOTTOM_XBOX = 1; //BUTTON A OPERATOR
	public static final short OPERATOR_BUTTON_ELEVATOR_VAULT_XBOX = 2; //BUTTON B OPERATOR
	public static final short OPERATOR_BUTTON_ELEVATOR_SWITCH_XBOX = 3; //BUTTON B OPERATOR
	public static final short OPERATOR_BUTTON_ELEVATOR_SCALE_XBOX = 4; //BUTTON B OPERATOR
	public static final short OPERATOR_BUTTON_ELEVATOR_RISE_XBOX = 5;
	public static final short OPERATOR_BUTTON_ELEVATOR_LOWER_XBOX = 6;
	
	public static final short OPERATOR_BUTTON_AUTOINTAKE_XBOX =      7;
	public static final short OPERATOR_BUTTON_MANUALINTAKECUBE_XBOX = 8;
	public static final short OPERATOR_BUTTON_MANUALDROPCUBE_XBOX =   9;
	public static final short OPERATOR_BUTTON_CORRECTCUBEPLACEMENT_XBOX = 10;
	
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

	JoystickButton getElevatorBottomButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_BOTTOM_XBOX));
			
		default:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_BOTTOM_XBOX));		
		}
	}

	JoystickButton getElevatorVaultButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_VAULT_XBOX));
		
		default:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_VAULT_XBOX));		
		}
	}

	JoystickButton getElevatorSwitchButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
		
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_SWITCH_XBOX));

		default:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_SWITCH_XBOX));		
		}
	}
	
	JoystickButton getElevatorScaleButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_SCALE_XBOX));
		
		default:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_SCALE_XBOX));		
		}

	}
	JoystickButton getElevatorRiseButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_RISE_XBOX));
		
		default:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_RISE_XBOX));		
		}

	}
	JoystickButton getElevatorLowerButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_LOWER_XBOX));
		
		default:
			
			return (new JoystickButton(this, OPERATOR_BUTTON_ELEVATOR_LOWER_XBOX));		
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
	
	JoystickButton getManualIntakeCubeButton() 
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALINTAKECUBE_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALINTAKECUBE_XBOX));
		}
	}
	
	JoystickButton getManualDropCubeButton() 
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALDROPCUBE_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_MANUALDROPCUBE_XBOX));
		}
	}

	JoystickButton getCorrectCubePlacement() 
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_CORRECTCUBEPLACEMENT_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_CORRECTCUBEPLACEMENT_XBOX));
		}
	}
}

