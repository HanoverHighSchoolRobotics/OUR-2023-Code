// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

public class DrivePID extends CommandBase {
  /** Creates a new ArmPID. */
  Drivetrain drivetrain;
  // PID CONTROLLER IS NAMED JEREMY
  PIDController jeremyController;

  public DrivePID(Drivetrain dt, double distance) {
     this.drivetrain = dt;
     this.jeremyController = new PIDController(0.0001, 0, 0);
     jeremyController.setSetpoint(distance);
     addRequirements(drivetrain);
      
  }

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ARM Initialize");
    jeremyController.reset();
  }

  //Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = jeremyController.calculate(this.drivetrain.getDrivePosition());
    drivetrain.setMotorSpeed(speed,speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setMotorSpeed(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
