// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Claw;

public class ArmPID extends PIDCommand {
  /** Creates a new ArmPID. */
  public ArmPID(double distance, Claw claw) {
    
    // Use addRequirements() here to declare subsystem dependencies.
    super(
      new PIDController(.001, 0, 0), 
      claw:: getArmPosition,
      distance, 
      output -> claw.runArm(output * Constants.armSpeedU),
      claw);
      getController().setTolerance(200);
      System.out.println("Im working");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ARM Initialize");
  }

  // Called every time the scheduler runs while the command is scheduled.
  // @Override
  // public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
