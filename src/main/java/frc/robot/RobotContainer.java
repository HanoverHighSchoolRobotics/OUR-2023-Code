// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoPark;
// import frc.robot.commands.ArmPID;
import frc.robot.commands.AutoWait;
import frc.robot.commands.AutonomousChargeStation;
import frc.robot.commands.AutonomousPark;
// import frc.robot.commands.ClampPID;
//import frc.robot.commands.DriveAutonomous;
import frc.robot.commands.DriveAutonomousBackward;
import frc.robot.commands.DriveAutonomousF;
import frc.robot.commands.DrivePID;
import frc.robot.commands.DrivePID2;
//import frc.robot.commands.ControlArm;
import frc.robot.commands.DriveRobot;
// import frc.robot.commands.RotateClaw;
import frc.robot.commands.RunArm;
import frc.robot.commands.RunClamp;
//import frc.robot.commands.RunWinch;
import frc.robot.subsystems.Arm;
// import frc.robot.commands.WinchU;
// import frc.robot.commands.WinchU;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.RevBlinkin;
//import frc.robot.subsystems.Winch;
//import frc.robot.subsystems.Winch2;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  public static Joystick Flight1;
  public static Joystick Flight2;
  double time = Timer.getFPGATimestamp();
  // public static PS4Controller driverController;
  // public static PS4Controller operatorController;
  // The robot's subsystems and commands are defined here...

  private final Drivetrain drivetrain = new Drivetrain();
  private final Claw claw = new Claw();
  //private final Winch2 winch = new Winch2();
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

    // RevBlinkin revblinkin = new RevBlinkin();
    // revblinkin.rainbow();
  

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
    // JoystickButton Flight2Button5 = new JoystickButton(Flight2, 7);
    // JoystickButton Flight2Button6 = new JoystickButton(Flight2, 8);
    JoystickButton Flight2Button3 = new JoystickButton(Flight2, 3);
    JoystickButton Flight2Button4 = new JoystickButton(Flight2, 4);
    

    

    Flight2Button1.onTrue(new RunClamp(claw, -Constants.clampSpeed));
    Flight2Button1.onFalse(new RunClamp(claw, Constants.stopSpeed));
    
    //Open Clamp
     Flight2Button2.onTrue(new RunClamp(claw, Constants.clampSpeed));
     Flight2Button2.onFalse(new RunClamp(claw, Constants.stopSpeed));

     //Arm Down
     Flight2Button3.onTrue(new RunArm(arm, Constants.armSpeed));  
     Flight2Button3.onFalse(new RunArm(arm, Constants.stopSpeed ));

     //Arm Back
     Flight2Button4.onTrue(new RunArm(arm, -Constants.armSpeed));
     Flight2Button4.onFalse(new RunArm(arm, Constants.stopSpeed ));


    // // Rotate
    //  Flight2Button5.onTrue(new RotateClaw(claw, Constants.rotateSpeed));
    //  Flight2Button5.onFalse(new RotateClaw(claw, Constants.stopSpeed ));

    // // Rotate 
    //  Flight2Button6.onTrue(new RotateClaw(claw, -Constants.rotateSpeed));
    //  Flight2Button6.onFalse(new RotateClaw(claw, Constants.stopSpeed));
    
    

    


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
    return  
     //new AutonomousChargeStation(drivetrain,arm, claw);
   new AutoPark(drivetrain,arm, claw);

  
  }
}
