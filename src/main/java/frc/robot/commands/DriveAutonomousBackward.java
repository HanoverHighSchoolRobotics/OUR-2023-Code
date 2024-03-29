// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveAutonomousBackward extends CommandBase {
  /** Creates a new DriveAutonomous. */
  private final Drivetrain drivetrain;
  private final double distance;
  private double encoderSetpoint;
  public DriveAutonomousBackward(Drivetrain dt, double dis) {
    drivetrain = dt;
    distance = dis;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
      
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Starting Auto Init drive backward: " + drivetrain.TicksToFeet() + distance);
    encoderSetpoint = drivetrain.TicksToFeet() + distance;
    //SmartDashboard.putNumber("Starting Ticks", drivetrain.TicksToFeet() + distance );

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.setMotorSpeed(-0.4,-0.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setMotorSpeed(0,0);
    System.out.println("ending " + Math.abs(drivetrain.TicksToFeet()));
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   //SmartDashboard.putNumber("end Ticks", Math.abs(drivetrain.TicksToFeet()) );
    return Math.abs(drivetrain.TicksToFeet()) >= encoderSetpoint;
    
    
  }
}
