// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Claw;

public class ClampPID extends PIDCommand {
  /** Creates a new ClampPID. */
  public ClampPID(double distance, Claw claw) {
    // Use addRequirements() here to declare subsystem dependencies.
    super(
      new PIDController(.01, 0, 0), 
      claw :: getClampPosition,
      distance, 
      output -> claw.runClamp(output * Constants.clampSpeed),
      claw);
    getController().setTolerance(.7);
    System.out.println("poopopopop");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Clamp Init");
  }

  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
