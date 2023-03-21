// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class AutonomousChargeStation extends SequentialCommandGroup {
  /** Creates a new AutonomousChargeStation. */
  public AutonomousChargeStation(Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.

      addCommands(
        new DriveAutonomousBackward(drivetrain, 33),
        new AutoWait(1),
        new DriveAutonomousF(drivetrain, 18.3)
      );



  }
}