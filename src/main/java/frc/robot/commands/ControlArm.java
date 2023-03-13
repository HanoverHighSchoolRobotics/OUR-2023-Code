// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Claw;
// import frc.robot.Constants;

// public class ControlArm extends CommandBase {
  
//   public Joystick armController;
//   public Claw clawArm;

//   public ControlArm(Arm arm, Joystick controller) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     clawArm = arm;
//     armController = controller;
//     addRequirements(clawArm);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {}

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     clawArm.runArm(armController.getY() * 0.5);
//     //rotate clamp
//     if (armController.getZ() > 0.) {
//       clawArm.runRotation(Constants.rotateSpeed);
//     } else if (armController.getZ() < 0.) {
//       clawArm.runRotation(-Constants.rotateSpeed);
//     } 
//     //close clamp
//     if (armController.getTrigger()) {
//       clawArm.runClamp(Constants.clampSpeed);
//     }
//     //open clamp
//     if (armController.getRawButton(2)) {
//       clawArm.runClamp(-Constants.clampSpeed);
//     }

//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
