/************************ PROJECT PHIL ************************/
/* Copyright (c) 2022 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartBoolean;
import com.stuypulse.stuylib.network.SmartNumber;

/*-
 * File containing tunable settings for every subsystem on the robot.
 *
 * We use StuyLib's SmartNumber / SmartBoolean in order to have tunable
 * values that we can edit on Shuffleboard.
 */
public interface Settings {

    public interface Shooter {

        SmartNumber PAD_RPM = new SmartNumber("Shooter/Pad RPM", 3650);
        SmartNumber RING_RPM = new SmartNumber("Shooter/Ring RPM", 2950);
        SmartNumber FENDER_RPM = new SmartNumber("Shooter/Fender RPM", 2500);
        SmartNumber FEEDER_MULTIPLER = new SmartNumber("Shooter/Feeder Multipler", 0.9);
	}
}
