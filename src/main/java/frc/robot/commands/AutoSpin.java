// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoSpin extends CommandBase {
    private final Drivetrain drivetrain;
    private final double degrees;
    private double initialHeading;
    private double currentHeading;
    private double targetHeading;
    private double upperBound;
    private double lowerBound;
    private final double TOLERANCE = 5;

    public AutoSpin(double degs, Drivetrain dt) {
        this.drivetrain = dt;
        this.degrees = degs;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        this.initialHeading = this.drivetrain.getHeading();
        this.targetHeading = this.initialHeading + this.degrees;
        this.lowerBound = this.targetHeading - this.TOLERANCE;
        this.upperBound = this.targetHeading + this.TOLERANCE;
        SmartDashboard.putNumber("InitialHeading: ", this.initialHeading);
        SmartDashboard.putNumber("InitialTarget: ", this.targetHeading);
        SmartDashboard.putNumber("Init UpperBound: ", this.upperBound);
        SmartDashboard.putNumber("Init LowerBound: ", this.lowerBound);
    }

    @Override
    public void execute() {
        double progress = this.targetHeading - this.currentHeading;
        double modifier = progress / this.targetHeading;
        if (modifier < .1) {
            modifier = .1;
        }
        drivetrain.setMotorSpeed(-modifier, modifier);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.setMotorSpeed(0, 0);
    }

    @Override
    public boolean isFinished() {
        this.currentHeading = this.drivetrain.getHeading();
        //double headingProgress = this.targetHeading - this.currentHeading;
        return (this.currentHeading <= this.upperBound && this.currentHeading >= this.lowerBound);
    }
}
