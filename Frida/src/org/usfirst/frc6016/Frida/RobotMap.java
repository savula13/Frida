// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6016.Frida;

import edu.wpi.first.wpilibj.SPI;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.kauailabs.navx.frc.AHRS;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static AHRS navX;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainSpeedController1;
    public static SpeedController drivetrainSpeedController2;
    public static SpeedControllerGroup drivetrainSpeedControllerGroupL;
    public static SpeedController drivetrainSpeedController3;
    public static SpeedController drivetrainSpeedController4;
    public static SpeedControllerGroup drivetrainSpeedControllerGroupR;
    public static DifferentialDrive drivetrainDifferentialDrive1;
    public static Encoder drivetrainEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainSpeedController1 = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 1", (Talon) drivetrainSpeedController1);
        drivetrainSpeedController1.setInverted(false);
        drivetrainSpeedController2 = new Talon(2);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 2", (Talon) drivetrainSpeedController2);
        drivetrainSpeedController2.setInverted(false);
        drivetrainSpeedControllerGroupL = new SpeedControllerGroup(drivetrainSpeedController1, drivetrainSpeedController2  );
        LiveWindow.addActuator("Drivetrain", "Speed Controller Group L", drivetrainSpeedControllerGroupL);
        
        drivetrainSpeedController3 = new Talon(4);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 3", (Talon) drivetrainSpeedController3);
        drivetrainSpeedController3.setInverted(false);
        drivetrainSpeedController4 = new Talon(5);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 4", (Talon) drivetrainSpeedController4);
        drivetrainSpeedController4.setInverted(false);
        drivetrainSpeedControllerGroupR = new SpeedControllerGroup(drivetrainSpeedController3, drivetrainSpeedController4  );
        LiveWindow.addActuator("Drivetrain", "Speed Controller Group R", drivetrainSpeedControllerGroupR);
        
        drivetrainDifferentialDrive1 = new DifferentialDrive(drivetrainSpeedControllerGroupL, drivetrainSpeedControllerGroupR);
        LiveWindow.addActuator("Drivetrain", "Differential Drive 1", drivetrainDifferentialDrive1);
        drivetrainDifferentialDrive1.setSafetyEnabled(true);
        drivetrainDifferentialDrive1.setExpiration(0.1);
        drivetrainDifferentialDrive1.setMaxOutput(1.0);

        drivetrainEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "Encoder", drivetrainEncoder);
        drivetrainEncoder.setDistancePerPulse(0.0586);
        drivetrainEncoder.setPIDSourceType(PIDSourceType.kRate);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        //drivetrainSpeedControllerGroupLeft.setInverted(true);
        //drivetrainTalonSRX3.setInverted(true);
        navX = new AHRS(SPI.Port.kMXP);
    }
}