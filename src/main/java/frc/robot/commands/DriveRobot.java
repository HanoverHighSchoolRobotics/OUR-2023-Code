// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveRobot extends CommandBase {
  
  public Joystick Flight2;
  public Drivetrain driveTrain;

  public DriveRobot(Drivetrain dt, Joystick fli) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    Flight2 = fli;

    addRequirements(driveTrain);

    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //  driveTrain.driveRobot(Flight2.getRawAxis(1), Flight2.getRawAxis(3));
    // if (Flight2.getRawButtonPressed(1)) {
    //   driveTrain.setDriveSpeed(Constants.TURBO_BOOST);
    // } else if (Flight2.getRawButtonReleased(1)){
    //   driveTrain.setDriveSpeed(Constants.driveSpeed);
    // }
    if (Flight2.getRawButtonPressed(2)){
      driveTrain.setDriveSpeed(Constants.SPEED_LIMITER);
    } else if (Flight2.getRawButtonReleased(2)){
      driveTrain.setDriveSpeed(Constants.driveSpeed);
    }
   driveTrain.driveRobot((-Flight2.getY()), Flight2.getZ());

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
