
package org.usfirst.frc295.GrizzlynatorBase.subsystems;

import org.usfirst.frc295.GrizzlynatorBase.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class SysCompressor extends Subsystem 
{

	private Compressor _compPrimary = new Compressor(RobotMap.CAN_PCM_MODULE);
	
    public SysCompressor()
    {
		super();
    	_compPrimary.setClosedLoopControl(true);
    }

	@Override
	protected void initDefaultCommand() 
	{
        // Set the default command for a subsystem here.
	}
	
	public void enable(boolean bEnable)
	{
    	_compPrimary.setClosedLoopControl(bEnable);
	}
}
