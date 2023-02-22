// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.DriveRobot;
import frc.robot.commands.RotateClaw;
import frc.robot.commands.RunClamp;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Drivetrain drivetrain = new Drivetrain();
  private final Claw claw = new Claw();

  private final Joystick Flight1 = new Joystick(0);
  private final Joystick Flight2 = new Joystick(1);

  private final DriveRobot driveRobot = new DriveRobot(drivetrain, Flight2);

 
  // Replace with CommandPS4Controller or CommandJoystick if needed
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

    drivetrain.setDefaultCommand(driveRobot);
    driveRobot.addRequirements(drivetrain);

    configureBindings();

  }


  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
 
    JoystickButton Flight1Button0 = new JoystickButton(Flight1, 0);
    JoystickButton Flight1Button1 = new JoystickButton(Flight1, 1);
    JoystickButton Flight1Button5 = new JoystickButton(Flight1, 5);
    JoystickButton Flight1Button6 = new JoystickButton(Flight1, 6);

    Flight1Button0.whileTrue(new RunClamp(claw, -.5));
    Flight1Button1.whileTrue(new RunClamp(claw, .5));
    Flight1Button5.whileTrue(new RotateClaw(claw, -.5));
    Flight1Button6.whileTrue(new RotateClaw(claw, .5));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
