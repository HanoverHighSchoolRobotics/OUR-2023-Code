// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.PIDCommand;
// import frc.robot.Constants;
// import frc.robot.subsystems.Arm;
// import frc.robot.subsystems.Claw;

// public class ArmPID extends PIDCommand {
//   /** Creates a new ArmPID. */

//   public ArmPID(double distance, Arm arm, double kP, double kI, double kD) {
//     //(Math.cos(arm.ticks2Deg(arm.getArmPosition()))
//     // Use addRequirements() here to declare subsystem dependencies.
//     // super(
//     //   new PIDController(kP, kI, kD), 
//     //   arm:: getArmPosition,
//     //   distance, 
//     //   output -> arm.runArm(output * Constants.armSpeedU ),
//     //   arm);
//     //   getController().setTolerance(1000);
//       System.out.println("Im working");
//   }

  
//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     System.out.println("ARM Initialize");
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   // @Override
//   // public void execute() {}

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
