package org.usfirst.frc6016.Frida.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc6016.Frida.RobotMap;

/**
 *
 */
public class Grabber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final SpeedController grabber1 = RobotMap.grabber1;
	private final SpeedController grabber2 = RobotMap.grabber2;
	private final SpeedControllerGroup grabberGroup = RobotMap.grabberGroup;
	
	@Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	@Override
    public void periodic() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	
    public void stop() {
    	grabberGroup.stopMotor();
    	return;
    }
}

