// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6016.Frida.subsystems;

import org.usfirst.frc6016.Frida.RobotMap;
import org.usfirst.frc6016.Frida.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivetrain extends Subsystem {
	
	double maxrotate = 0.5;
	double currentheading = 0.0;
	double error = 0.0;
	public double accuracy = 0.5;
	double derivative = 0.0;
	double timeunit = 0.02;
	double integral, preverror = 0.0;
	//double kP = 2.0; //  1.15, 1.1
	//double kI = 2.0;
	//double kD = 0.0;
	double kP = 1.2; //  1.15, 1.1
	double kI = 1.0;
	double kD = 0.0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController speedController1 = RobotMap.drivetrainSpeedController1;
    private final SpeedController speedController2 = RobotMap.drivetrainSpeedController2;
    private final SpeedControllerGroup speedControllerGroupL = RobotMap.drivetrainSpeedControllerGroupL;
    private final SpeedController speedController3 = RobotMap.drivetrainSpeedController3;
    private final SpeedController speedController4 = RobotMap.drivetrainSpeedController4;
    private final SpeedControllerGroup speedControllerGroupR = RobotMap.drivetrainSpeedControllerGroupR;
    private final DifferentialDrive differentialDrive1 = RobotMap.drivetrainDifferentialDrive1;
    private final Encoder encoder = RobotMap.drivetrainEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ArcadeDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
    
    public void arcadeDrive(Joystick stick){
    	RobotMap.drivetrainDifferentialDrive1.arcadeDrive(stick.getRawAxis(1), stick.getRawAxis(4));
    	return;
    }
    
    public void goForward(double speed){
		differentialDrive1.arcadeDrive(speed, 0);
		return;
	}
    public void stop(){
    	differentialDrive1.stopMotor();
    	return;
    }
	
    
    public void turn(double speed){
		differentialDrive1.arcadeDrive(0, speed);
		return;
	}
    
    public void reset(){
		//RobotMap.navX.reset();
		RobotMap.navX.zeroYaw();;
		//RobotMap.navX.resetDisplacement();
		error = 0;
    	preverror = 0;
    	derivative = 0;
    	integral = 0;
    	currentheading = 0;
		Timer.delay(0.5);
		return;
	}
    public double calcPID2(double setpoint){
    	currentheading = RobotMap.navX.getYaw();
    	//System.out.println("Gyro: " + currentheading);
    	//SmartDashboard.putNumber("Gyro", currentheading);
    	error = setpoint - currentheading;
    	integral = (integral + (error*timeunit));
    	derivative = ((error-preverror) * timeunit);
    	preverror = error;
    	double rcw = (kP*error) + (kI*integral) + (kD*derivative);
    	if(rcw > 0){
    		rcw = Math.min((rcw / Math.abs(setpoint)), maxrotate);
    	} else {
    		rcw = Math.max((rcw / Math.abs(setpoint)), -maxrotate);
    	}
    	SmartDashboard.putNumber("PID Value", rcw);
    	//System.out.println("Error: " + error);
    	//System.out.println("Integral: " + integral);
    	//System.out.println("Derivative: " + derivative);
    	//System.out.println("PID Value: " + rcw);
    	//System.out.println("Gyro: " + currentheading);
		return rcw;
    	
    }
    public void curvatureDrive(Joystick stick){
		differentialDrive1.curvatureDrive(stick.getRawAxis(1), stick.getRawAxis(4), false);
		return;
		
	}
    /*public double getRightInches(){
    	return RobotMap.drivetrainQuadratureEncoder1.getDistance();
    	//RobotMap.drivetrainQuadratureEncoder1.
    }
    public double getLeftInches(){
    	return RobotMap.drivetrainQuadratureEncoder2.getDistance();
    	//RobotMap.drivetrainQuadratureEncoder1.
    }*/
    public void driveStraight(double speed){
    	RobotMap.drivetrainDifferentialDrive1.arcadeDrive(speed, 0);
    	return;
    }


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

