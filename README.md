# NewbieBot

In this lab, you'll be learning about common robot hardware, subsystems, and how to write robot code!

## Robot Hardware

### Motors

Motors are one of the most common components on the robot. They turn voltage into a rotation on an output shaft.

#### NEO

![NEO Motor](images/neo.jpg)
We use NEOs everywhere on our robot, so its good to be familiar with how to use them in code.
### Motor Controllers

Motor controllers are how robot code interfaces with motors. They're the middleman between you and the motor, translating your instructions into voltages for the motors.

#### CANSparkMax

![CANSparkMax](images/cansparkmax.jpg)
`CANSparkMax` is the class/type in java used to control NEO motors.

### Solenoids

Solenoids are electronic components that control the air pressure in a piston, causing it to extend or retract.

There are two types of solenoids: normal solenoids and double solenoids. <b>Double</b> solenoids can force the piston to be extended and retracted. <b>Normal</b> solenoids can force the piston to extend, but when the retract they don't force the piston to stay retracted.

![piston](images/piston.webp)

## Subsystems

Subsystems represent and control mechanisms on the robot like the drivetrain, intake, and shooter. Subsystems are some of the most important parts of our robot code.

In code, a subsystem is a class that has fields for hardware that is physically on the mechanism, including motors, solenoids (pistons), and encoders. The subsystem's methods represent the behaviors that we want the real mechanism to have.

In this lab you'll be coding your own subsystems!

## Day 1: Intake

First, we're going to be coding an intake, which brings balls into the robot. The intake is has an arm that hangs in front of the robot with spinning wheels to force balls inwards, and this arm can retract to perpendicular.

The intake has one NEO to drive the wheels on the arm and a double solenoid (two-way) that controls it extending or retracting.

[Here](src/main/java/com/stuypulse/robot/subsystems/Intake.java) is your intake file.

### Methods Intake.java should have

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
            <td>extend()</td>
            <td>Extends the intake's solenoid, bringing the intake down.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>retract()</td>
            <td>Retracts the intake's solenoid, bringing the intake up.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>stop()</td>
            <td>Stops the intake's drive motor (stop intaking balls).</td>
            <td>void</td>
        </tr>
        <tr>
            <td>acquire()</td>
            <td>Run the drive motor forwards, bringing balls into the robot with the rollers.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>deacquire()</td>
            <td>Run the drive motor backwards, pushing balls out of the robot with the rollers.</td>
            <td>void</td>
        </tr>
    </tbody>
</table>


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
            <td>CANSparkMax(int port, type)</td>
            <td>Constructor, takes in a port and a type. Type is normally MotorType.kBrushless.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>get()</td>
            <td>Returns the set speed of the motor from -1.0 to 1.0.</td>
            <td>double</td>
        </tr>
        <tr>
            <td>set(double speed)</td>
            <td>Sets the speed of the motor from -1.0 to 1.0.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>setInverted(boolean inverted)</td>
            <td>Inverts the direction of the motor spinning, takes in a true/false inverted value.</td>
            <td>void</td>
        </tr>
        <!-- <tr>
            <td>setVoltage(volts)</td>
            <td>Sets the voltage of the motor directly, usually between -12.0 and 12.0 volts.</td>
            <td>void</td>
        </tr> -->
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
            <td>DoubleSolenoid(type, int extendPort, int retractPort)</td>
            <td>Constructor, takes in a type which is normally PneumaticsModuleType.CTREPCM and two ports.</td>
            <td>void</td>
        </tr>
        <tr>
            <td>get()</td>
            <td>Returns which state the solenoid is in (extended or retracted). If it is extended, the return value will be Value.kForward, otherwise Value.kReverse.</td>
            <td>Value</td>
        </tr>
        <tr>
            <td>toggle()</td>
            <td>Toggles the solenoid between extended and retracted.</td>
            <td>void</td>
        </tr>
    </tbody>
</table>
