// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Claw;
// //import frc.robot.subsystems.Winch;
// import frc.robot.subsystems.Winch2;

// public class RunWinch extends CommandBase {
  
//   double speed;
//   Winch2 winch;

//   public RunWinch(Winch2 win, double sp) {
     
//     winch = win;
//     speed = sp;

//     addRequirements(winch);

//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {}

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {

//     winch.RunWinch(speed);

//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {

//     winch.RunWinch(0);

//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
