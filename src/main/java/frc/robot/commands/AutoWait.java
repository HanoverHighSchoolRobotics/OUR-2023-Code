// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class AutoWait extends CommandBase {
  /** Creates a new DriveAutonomous. */
  private final double duration;
  private long startTime;

  public AutoWait(double time) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.duration = time * 1000;    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Starting Timer");
    this.startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ending Wait");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - this.startTime) >= this.duration; //this.currentTime > this.seconds;
    
  }
}
