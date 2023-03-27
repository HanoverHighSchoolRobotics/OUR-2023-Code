// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;

public class AutoPark extends SequentialCommandGroup {
  /** Creates a new AutonomousChargeStation. */
  public AutoPark(Drivetrain drivetrain, Arm arm, Claw claw) {
    // Use addRequirements() here to declare subsystem dependencies.

      addCommands(
       new AutoDropArm(1, arm),
       new AutoOpenClamp(.01, claw),
       new AutoUpArm(1, arm),
       new AutoCloseClamp(.01, claw),
       new DriveAutonomousBackward(drivetrain, 33),
       new AutoWait(1)
      // new AutoSpin(180, drivetrain)
      );



  }
}