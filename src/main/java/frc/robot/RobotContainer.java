// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.ArmPID;
import frc.robot.commands.DriveRobot;
import frc.robot.commands.RotateClaw;
import frc.robot.commands.RunArm;
import frc.robot.commands.RunClamp;
import frc.robot.commands.RunWinch;
// import frc.robot.commands.WinchU;
// import frc.robot.commands.WinchU;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.Winch;
import frc.robot.subsystems.Winch2;
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

  public static Joystick Flight1;
  public static Joystick Flight2;
  // The robot's subsystems and commands are defined here...

  private final Drivetrain drivetrain = new Drivetrain();
  private final Claw claw = new Claw();
  private final Winch2 winch = new Winch2();



  

  private final DriveRobot driveRobot; 
 
  // Replace with CommandPS4Controller or CommandJoystick if needed
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

    // Flight2 is Driver joystick
    Flight1 = new Joystick(Constants.Flight1Port);
    Flight2 = new Joystick(Constants.Flight2Port);

    driveRobot = new DriveRobot(drivetrain, Flight1);
    drivetrain.setDefaultCommand(driveRobot);
    driveRobot.addRequirements(drivetrain);
  

    configureBindings();

  }


  private void configureBindings() {

    drivetrain.setDefaultCommand(driveRobot);
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
 
    JoystickButton Flight2Button1 = new JoystickButton(Flight2, 1);
    JoystickButton Flight2Button2 = new JoystickButton(Flight2, 2);
    JoystickButton Flight2Button5 = new JoystickButton(Flight2, 5);
    JoystickButton Flight2Button6 = new JoystickButton(Flight2, 6);
    JoystickButton Flight2Button3 = new JoystickButton(Flight2, 3);
    JoystickButton Flight2Button4 = new JoystickButton(Flight2, 4);
    JoystickButton Flight2Button7 = new JoystickButton(Flight2, 7);
    JoystickButton Flight2Button8 = new JoystickButton(Flight2, 8);
    JoystickButton Flight2Button9 = new JoystickButton(Flight2, 9);


    Flight2Button1.onTrue(new RunClamp(claw, -Constants.clampSpeed));
    Flight2Button1.onFalse(new RunClamp(claw, Constants.stopSpeed));
    
     Flight2Button2.onTrue(new RunClamp(claw, Constants.clampSpeed));
     Flight2Button2.onFalse(new RunClamp(claw, Constants.stopSpeed));

     Flight2Button5.onTrue(new RotateClaw(claw, Constants.rotateSpeed));
     Flight2Button5.onFalse(new RotateClaw(claw, Constants.stopSpeed));

     Flight2Button6.onTrue(new RotateClaw(claw, -Constants.rotateSpeed));
     Flight2Button6.onFalse(new RotateClaw(claw, Constants.stopSpeed));

    Flight2Button4.onTrue(new RunWinch(winch, Constants.winchSpeed));
    Flight2Button4.onFalse(new RunWinch(winch, Constants.stopSpeed));

    Flight2Button3.onTrue(new RunWinch(winch, -Constants.winchSpeed));
    Flight2Button3.onFalse(new RunWinch(winch, Constants.stopSpeed));

    Flight2Button7.onTrue(new RunArm(claw, -Constants.armSpeed));
    Flight2Button7.onFalse(new RunArm(claw, Constants.stopSpeed));

    Flight2Button8.onTrue(new RunArm(claw, Constants.armSpeedU));
    Flight2Button8.onFalse(new RunArm(claw, Constants.stopSpeed));

    Flight2Button9.onTrue(new ArmPID(1500, claw));
    Flight2Button9.onFalse(new RunArm(claw, Constants.stopSpeed ));


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
