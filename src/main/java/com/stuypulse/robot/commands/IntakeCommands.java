package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

public class IntakeCommands {

    public static CommandBase Acquire(Intake intake) {
        return new StartEndCommand(intake::acquire, intake::stop, intake);
    }

    public static CommandBase AcquireForever(Intake intake) {
        return new InstantCommand(intake::acquire, intake);
    }

    public static CommandBase Deacquire(Intake intake) {
        return new StartEndCommand(intake::deacquire, intake::stop, intake);
    }

    public static CommandBase DeacquireForever(Intake intake) {
        return new InstantCommand(intake::deacquire, intake);
    }

    public static CommandBase Extend(Intake intake) {
        return new InstantCommand(intake::extend);
    }

    public static CommandBase Retract(Intake intake) {
        return new InstantCommand(intake::retract);
    }

    public static CommandBase Stop(Intake intake) {
        return new RunCommand(intake::stop);
    }

    public static CommandBase StopForever(Intake intake) {
        return new InstantCommand(intake::stop, intake);
    }
}
