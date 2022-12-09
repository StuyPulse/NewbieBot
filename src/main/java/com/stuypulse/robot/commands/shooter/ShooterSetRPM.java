/************************ PROJECT DORCAS ************************/
/* Copyright (c) 2022 StuyPulse Robotics. All rights reserved.  */
/* This work is licensed under the terms of the MIT license.    */
/****************************************************************/

package com.stuypulse.robot.commands.shooter;

import com.stuypulse.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShooterSetRPM extends InstantCommand {

    private final Shooter shooter;
    private final double targetRPM;

    public ShooterSetRPM(Shooter shooter, double targetRPM) {
        this.shooter = shooter;
        this.targetRPM = targetRPM;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.setShooterRPM(targetRPM);
    }
}
