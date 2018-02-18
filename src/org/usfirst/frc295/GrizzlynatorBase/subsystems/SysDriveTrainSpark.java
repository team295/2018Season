package org.usfirst.frc295.GrizzlynatorBase.subsystems;
import org.usfirst.frc295.GrizzlynatorBase.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
public class SysDriveTrainSpark extends SysDriveTrain {
    // DECLARE COMPONENTS OF THE DRIVETRAIN
    
    private Spark _escMaster;
    private Spark _escBlank;
    
    public SysDriveTrainSpark()
    {
        super();
        
        // ==========================================================
        // SYS DRIVE TRAIN SPARKS (FOR ELEVATOR)
        // ==========================================================
        _escMaster = new Spark(RobotMap.PWM_ESC_LIFT);
        _escBlank = new Spark(RobotMap.PWM_ESC_BLANK);

        _robotDrive = new DifferentialDrive(_escMaster, _escBlank);

        _robotDrive.setSafetyEnabled(true);
        _robotDrive.setExpiration(0.25);
        _robotDrive.setMaxOutput(1.0);
    }
}
