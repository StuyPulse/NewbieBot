/************************ PROJECT PHIL ************************/
/* Copyright (c) 2022 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot;

import com.stuypulse.robot.commands.intake.IntakeExtend;
import com.stuypulse.robot.commands.intake.IntakeRetract;
import com.stuypulse.robot.commands.intake.IntakeAcquire;
import com.stuypulse.robot.commands.intake.IntakeDeacquire;
import com.stuypulse.robot.commands.auton.DoNothingAuton;
import com.stuypulse.robot.commands.shooter.ShooterSetRPM;
import com.stuypulse.robot.constants.Ports;
import com.stuypulse.robot.subsystems.Intake;
import com.stuypulse.robot.subsystems.Shooter;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.AutoGamepad;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    // Gamepads
    public final Gamepad driver = new AutoGamepad(Ports.Gamepad.DRIVER);
    public final Gamepad operator = new AutoGamepad(Ports.Gamepad.OPERATOR);
    
    // Subsystem
    public final Intake intake = new Intake();
    public final Shooter shooter = new Shooter();

    // Autons
    private static SendableChooser<Command> autonChooser = new SendableChooser<>();

    // Robot container

    public RobotContainer() {
        configureDefaultCommands();
        configureButtonBindings();
        configureAutons();
    }

    /****************/
    /*** DEFAULTS ***/
    /****************/

    private void configureDefaultCommands() {}

    /***************/
    /*** BUTTONS ***/
    /***************/

    private void configureButtonBindings() {
        // Intake //
        operator.getRightTriggerButton()
            .whenPressed(new IntakeExtend(intake))
            .whileHeld(new IntakeAcquire(intake))
            .whenReleased(new IntakeRetract(intake));

        operator.getLeftTriggerButton()
            .whenPressed(new IntakeExtend(intake))
            .whileHeld(new IntakeDeacquire(intake))
            .whenReleased(new IntakeRetract(intake));
        
        // Shooter
        operator.getLeftBumper()
            .whenPressed(new ShooterSetRPM(shooter, 0));
        operator.getTopButton()
            .whenPressed(new ShooterSetRPM(shooter, 0));
        operator.getBottomButton()
            .whenPressed(new ShooterSetRPM(shooter, 0));
        operator.getRightBumper()
            .whenPressed(new ShooterSetRPM(shooter, 0));
    }

    /**************/
    /*** AUTONS ***/
    /**************/

    public void configureAutons() {
        autonChooser.setDefaultOption("Do Nothing", new DoNothingAuton());

        SmartDashboard.putData("Autonomous", autonChooser);
    }

    public Command getAutonomousCommand() {
        return autonChooser.getSelected();
    }
}
