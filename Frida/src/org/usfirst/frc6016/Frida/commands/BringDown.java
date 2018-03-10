package org.usfirst.frc6016.Frida.commands;

import org.usfirst.frc6016.Frida.Robot;
import org.usfirst.frc6016.Frida.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BringDown extends Command {

    public BringDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	return;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.lift.set(0.1);
    	return;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    	return;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    	return;
    }
}
