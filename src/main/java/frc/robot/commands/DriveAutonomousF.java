// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveAutonomousF extends CommandBase {
  /** Creates a new DriveAutonomous. */
  private final Drivetrain drivetrain;
  private final double distance;
  private double encoderSetpoint;
  public DriveAutonomousF(Drivetrain dt, double dis) {
    drivetrain = dt;
    distance = dis;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
      
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    encoderSetpoint = Math.abs((drivetrain.TicksToFeet() + distance));
    System.out.println("drive forward goal: " + encoderSetpoint);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.setMotorSpeed(0.4,0.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setMotorSpeed(0.0,0.0);
    System.out.println("end forward" +Math.abs(drivetrain.TicksToFeet()));
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(drivetrain.TicksToFeet()) <= encoderSetpoint;
    // if (drivetrain.TicksToFeet() > encoderSetpoint) {
    //   return true;
    
    // } else {
    // return false;
    // }
  }
}
