package org.usfirst.frc6016.Frida.commands;

import org.usfirst.frc6016.Frida.Robot;
import org.usfirst.frc6016.Frida.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PushOut extends Command {

    public PushOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	return;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	RobotMap.grabberGroup.set(-0.5);
    	return;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.grabber.stop();
    	return;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    	return;
    }
}
