package org.usfirst.frc295.GrizzlynatorBase.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{

	@Override
	protected boolean isFinished() {	
		if(timeSinceInitialized()> 1){
			return true;
			
		}
		else{
			return false;
		}
	}
	protected void end(){
	
	}
	
}