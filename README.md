# NewbieBot

Subsystems represent and control mechanisms on the robot like the drivetrain, intake, and shooter. Subsystems are some of the most important parts of our robot code.

Each subsystem holds all of the hardware that is physically on the mechanism, including motors, solenoids (pistons), and encoders.

In this lab you'll be coding your own subsystems!

## Day 1: Intake

First, we're going to be coding an intake, which brings balls into the robot. The intake is has an arm that hangs in front of the robot with spinning wheels to force balls inwards, and this arm can retract to perpendicular.

The intake has one NEO to drive the wheels on the arm and a double solenoid (two-way) that controls it extending or retracting.

## Hardware Classes

### CANSparkMax

<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Description</th>
            <th>Returns</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>CANSparkMax(port, type)</td>
            <td>Constructor, takes in a port (int) and a type. Type can either be MotorType.kBrushed or MotorType.kBrushless.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>get()</td>
            <td>Returns the set speed of the motor from -1.0 to 1.0.</td>
            <td>double</td>
        </tr>
        <tr>
            <td>set()</td>
            <td>Sets the speed of the motor from -1.0 to 1.0.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>setInverted(inverted)</td>
            <td>Inverts the direction of the motor spinning, takes in a boolean inverted value.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>setVoltage(volts)</td>
            <td>Sets the voltage of the motor directly, usually between -12.0 and 12.0 volts.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>stopMotor()</td>
            <td>Stops the motor.</td>
            <td>void</td>
        </tr>
    </tbody>
</table>

### DoubleSolenoid

<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Description</th>
            <th>Returns</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>DoubleSolenoid(type, extendPort, retractPort)</td>
            <td>Constructor, takes in a type (normally PneumaticsModuleType.CTREPCM) and two ports (int).</td>
            <td>void</td>
        </tr>
        <tr>
            <td>get()</td>
            <td>Returns which state the solenoid is in (extended or retracted).</td>
            <td>Value</td>
        </tr>
        <tr>
            <td>toggle()</td>
            <td>Toggles the solenoid between extended and retracted.</td>
            <td>void</td>
        </tr>
    </tbody>
</table>
