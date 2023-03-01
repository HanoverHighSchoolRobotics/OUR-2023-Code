// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  // Variables
  CANSparkMax leftFrontMotor;
  CANSparkMax leftRearMotor;
  CANSparkMax rightFrontMotor;
  CANSparkMax rightRearMotor;

  DifferentialDrive robotDrive;

  MotorControllerGroup leftDrive;
  MotorControllerGroup rightDrive;

  SlewRateLimiter filter;
 


  public Drivetrain() {
    
    //Assigning ports to Motors
    leftFrontMotor = new CANSparkMax(Constants.leftFrontPort, MotorType.kBrushless);
    leftRearMotor = new CANSparkMax(Constants.leftRearPort, MotorType.kBrushless);
    rightFrontMotor = new CANSparkMax(Constants.rightFrontPort, MotorType.kBrushless);
    rightRearMotor = new CANSparkMax(Constants.rightRearPort, MotorType.kBrushless);

    //Differentiating between right and left side of robot
    leftDrive = new MotorControllerGroup(leftRearMotor, leftFrontMotor);
    rightDrive = new MotorControllerGroup(rightFrontMotor, rightRearMotor);

    filter = new SlewRateLimiter(.3);

    robotDrive = new DifferentialDrive(rightDrive, leftDrive);

    // Right side needs to be inverted
    leftFrontMotor.setInverted(false);
    rightFrontMotor.setInverted(true);
    leftRearMotor.setInverted(false);
    rightRearMotor.setInverted(true);

  // Sets the motors to brake mode
    leftFrontMotor.setIdleMode(IdleMode.kBrake);
    leftRearMotor.setIdleMode(IdleMode.kBrake);
    rightFrontMotor.setIdleMode(IdleMode.kBrake);
    rightRearMotor.setIdleMode(IdleMode.kBrake);

  }

  public void driveRobot(double x, double y) {

    robotDrive.arcadeDrive(filter.calculate(x), y);

  }
  public void joyStickDrive(Joystick driveWithJoySticks){
    robotDrive.arcadeDrive((driveWithJoySticks.getRawAxis(Constants.move) * Constants.driveSpeed), -((driveWithJoySticks.getRawAxis(Constants.turn) * -1) * Constants.driveSpeed));
  }
  public void driveBackward(){
    robotDrive.tankDrive(Constants.speed, Constants.speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
