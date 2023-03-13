// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmPID;
import frc.robot.commands.ClampPID;
import frc.robot.commands.DriveAutonomous;
//import frc.robot.commands.ControlArm;
import frc.robot.commands.DriveRobot;
import frc.robot.commands.RotateClaw;
import frc.robot.commands.RunArm;
import frc.robot.commands.RunClamp;
import frc.robot.commands.RunWinch;
import frc.robot.subsystems.Arm;
// import frc.robot.commands.WinchU;
// import frc.robot.commands.WinchU;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.RevBlinkin;
//import frc.robot.subsystems.Winch;
import frc.robot.subsystems.Winch2;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  public static Joystick Flight1;
  public static Joystick Flight2;
  // public static PS4Controller driverController;
  // public static PS4Controller operatorController;
  // The robot's subsystems and commands are defined here...

  private final Drivetrain drivetrain = new Drivetrain();
  private final Claw claw = new Claw();
  private final Winch2 winch = new Winch2();
  private final Arm arm = new Arm();
  



  

  private final DriveRobot driveRobot;
  //private final ControlArm controlArm; 
 
  // Replace with CommandPS4Controller or CommandJoystick if needed
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

    // Flight1 is Driver joystick
    Flight1 = new Joystick(Constants.Flight1Port);
    Flight2 = new Joystick(Constants.Flight2Port);

    // controlArm = new ControlArm(claw, Flight2);
    // claw.setDefaultCommand(controlArm);

    driveRobot = new DriveRobot(drivetrain, Flight1);
    drivetrain.setDefaultCommand(driveRobot);
    driveRobot.addRequirements(drivetrain);

    RevBlinkin revblinkin = new RevBlinkin();
    revblinkin.rainbow();
  

    configureBindings();

  }


  private void configureBindings() {

    drivetrain.setDefaultCommand(driveRobot);
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    //Figure out assigning buttons I ran out of time I was playing with encoders too much I adjusted the 
    //PID distance to try for the clamp motor so try it but bind the buttons and
    // start more testing today
    // Also for the arm I want 0 to be it resting on the robot so you need to adjust the encoder value
    // Good luck guys thank you for covering

    //PS4Controller
    //boolean toggle = false;
    JoystickButton Flight2Button1 = new JoystickButton(Flight2, 1);
    JoystickButton Flight2Button2 = new JoystickButton(Flight2, 2);
    JoystickButton Flight2Button5 = new JoystickButton(Flight2, 5);
    JoystickButton Flight2Button6 = new JoystickButton(Flight2, 6);
    JoystickButton Flight2Button3 = new JoystickButton(Flight2, 3);
    JoystickButton Flight2Button4 = new JoystickButton(Flight2, 4);
    JoystickButton Flight2Button7 = new JoystickButton(Flight2, 7);
    JoystickButton Flight2Button8 = new JoystickButton(Flight2, 8);
    JoystickButton Flight2Button9 = new JoystickButton(Flight2, 9);
    JoystickButton Flight2Button10 = new JoystickButton(Flight2, 10);
    JoystickButton Flight2Button11 = new JoystickButton(Flight2, 11);
    JoystickButton Flight2Button12 = new JoystickButton(Flight2, 12);
 

    
    //Close Clamp
    Flight2Button1.onTrue(new RunClamp(claw, -Constants.clampSpeed));
    Flight2Button1.onFalse(new RunClamp(claw, Constants.stopSpeed));
    
    //Open Clamp
     Flight2Button2.onTrue(new RunClamp(claw, Constants.clampSpeed));
     Flight2Button2.onFalse(new RunClamp(claw, Constants.stopSpeed));

     //Pick Up
     Flight2Button3.onTrue(new ArmPID(-50666, arm, 0.00007,0.09, 0.00004));  // IMPORTANT PLEASE LOOK AT ENCODER VALUES TO ADJUST THE DISTANCE WE DO NOT WANT OUR CLAW TO GO TOO FAR THAT WOULD BREAK IT
     Flight2Button3.onFalse(new RunArm(arm, Constants.stopSpeed ));

     //Back to start
     Flight2Button4.onTrue(new ArmPID(-18666.667, arm, .005, 0.07, 0.00003));
     Flight2Button4.onFalse(new RunArm(arm, Constants.stopSpeed ));


    // Mid Cone 
     Flight2Button5.onTrue(new ArmPID(arm.deg2Ticks(-120), arm, .00004, 0.07,0.00003));
     Flight2Button5.onFalse(new RunArm(arm, Constants.stopSpeed ));

    // Rotate Left
     Flight2Button7.onTrue(new RotateClaw(claw, Constants.rotateSpeed));
     Flight2Button7.onFalse(new RotateClaw(claw, Constants.stopSpeed));

     // Rotate Right
     Flight2Button8.onTrue(new RotateClaw(claw, -Constants.rotateSpeed));
     Flight2Button8.onFalse(new RotateClaw(claw, Constants.stopSpeed));

     //Winch Up

    //Flight2Button9.onTrue(new RunWinch(winch, Constants.winchSpeed));
    //Flight2Button9.onFalse(new RunWinch(winch, Constants.stopSpeed));

    Flight2Button9.onTrue(new RunArm(arm, 0));
    Flight2Button9.onFalse( new RunArm(arm, -3));
    
    //Winch Down
    Flight2Button10.onTrue(new RunWinch(winch, -Constants.winchSpeed));
    Flight2Button10.onFalse(new RunWinch(winch, Constants.stopSpeed));
    
    // Arm Down Manual
    Flight2Button12.onTrue(new RunArm(arm, -Constants.armSpeed));
    Flight2Button12.onFalse(new RunArm(arm, Constants.stopSpeed));

    //Arm Up Manual
    Flight2Button11.onTrue(new RunArm(arm, Constants.armSpeedU));
    Flight2Button11.onFalse(new RunArm(arm, Constants.stopSpeed));

    // Flight2Button5.onTrue(new ArmPID(-19000, arm, .00005, 0.07,0.00003));
    // Flight2Button5.onFalse(new RunArm(arm, Constants.stopSpeed ));

    // if (Flight2.getRawButtonPressed(9)) {
    //    if (toggle) {
    //     new RunArm(claw, Constants.stopSpeed);
    //     toggle = false;
    //     System.out.println("Arm pid id woring Falsi");
    //    } else {
    //     new ArmPID(-19000, claw, .00005);
    //     toggle = true;
    //     System.out.println("Arm pid id woring");
    //    }
    // }

    // Flight2Button4.onTrue(new ArmPID(0, arm, .005, 0.07, 0.00003));
    // Flight2Button4.onFalse(new RunArm(arm, Constants.stopSpeed ));

    // Flight2Button10.onTrue(new ClampPID(-.9, claw));  // IMPORTANT PLEASE LOOK AT ENCODER VALUES TO ADJUST THE DISTANCE WE DO NOT WANT OUR CLAW TO GO TOO FAR THAT WOULD BREAK IT
    // Flight2Button10.onFalse(new RunClamp(claw, Constants.stopSpeed ));

    // Flight2Button3.onTrue(new ArmPID(-32000, arm, 0.00007,0.09, 0.00004));  // IMPORTANT PLEASE LOOK AT ENCODER VALUES TO ADJUST THE DISTANCE WE DO NOT WANT OUR CLAW TO GO TOO FAR THAT WOULD BREAK IT
    // Flight2Button3.onFalse(new RunArm(arm, Constants.stopSpeed ));



    //operatorController.getR2ButtonPressed(new RunClamp(claw, Constants.stopSpeed));
    //operatorController.R2(new RunClamp(claw, Constants.stopSpeed)
    //operatorController.R2(null) : new RunClamp(claw, Constants.stopSpeed));

    //operatorController.R2
    // Flight2Button1.onTrue(new RunClamp(claw, -Constants.clampSpeed));
    // Flight2Button1.onFalse(new RunClamp(claw, Constants.stopSpeed));
    
    //  Flight2Button2.onTrue(new RunClamp(claw, Constants.clampSpeed));
    //  Flight2Button2.onFalse(new RunClamp(claw, Constants.stopSpeed));

    //  Flight2Button5.onTrue(new RotateClaw(claw, Constants.rotateSpeed));
    //  Flight2Button5.onFalse(new RotateClaw(claw, Constants.stopSpeed));

    //  Flight2Button6.onTrue(new RotateClaw(claw, -Constants.rotateSpeed));
    //  Flight2Button6.onFalse(new RotateClaw(claw, Constants.stopSpeed));

    // Flight2Button4.onTrue(new RunWinch(winch, Constants.winchSpeed));
    // Flight2Button4.onFalse(new RunWinch(winch, Constants.stopSpeed));

    // Flight2Button3.onTrue(new RunWinch(winch, -Constants.winchSpeed));
    // Flight2Button3.onFalse(new RunWinch(winch, Constants.stopSpeed));

    // Flight2Button7.onTrue(new RunArm(claw, -Constants.armSpeed));
    // Flight2Button7.onFalse(new RunArm(claw, Constants.stopSpeed));

    // Flight2Button8.onTrue(new RunArm(claw, Constants.armSpeedU));
    // Flight2Button8.onFalse(new RunArm(claw, Constants.stopSpeed));

    // Flight2Button9.onTrue(new ArmPID(1500, claw));
    // Flight2Button9.onFalse(new RunArm(claw, Constants.stopSpeed ));

    // Flight2Button10.onTrue(new ClampPID(-.9, claw));  // IMPORTANT PLEASE LOOK AT ENCODER VALUES TO ADJUST THE DISTANCE WE DO NOT WANT OUR CLAW TO GO TOO FAR THAT WOULD BREAK IT
    // Flight2Button10.onFalse(new RunClamp(claw, Constants.stopSpeed )); 

    


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
    return new DriveAutonomous(149, drivetrain);
    
  }
}
