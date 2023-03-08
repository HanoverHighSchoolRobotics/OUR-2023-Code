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
import frc.robot.commands.DriveRobot;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  // Variables
  CANSparkMax leftFrontMotorLeader;
  CANSparkMax leftRearMotor;
  CANSparkMax rightFrontMotorLeader;
  CANSparkMax rightRearMotor;

  DifferentialDrive robotDrive;

  MotorControllerGroup leftDrive;
  MotorControllerGroup rightDrive;

  SlewRateLimiter filter;
 


  public Drivetrain() {
    
    //Assigning ports to Motors
    leftFrontMotorLeader = new CANSparkMax(Constants.leftFrontPort, MotorType.kBrushless);
    leftRearMotor = new CANSparkMax(Constants.leftRearPort, MotorType.kBrushless);
    rightFrontMotorLeader = new CANSparkMax(Constants.rightFrontPort, MotorType.kBrushless);
    rightRearMotor = new CANSparkMax(Constants.rightRearPort, MotorType.kBrushless);

    

    //Differentiating between right and left side of robot
    //leftDrive = new MotorControllerGroup(leftRearMotor, leftFrontMotorLeader);
    //rightDrive = new MotorControllerGroup(rightFrontMotorLeader, rightRearMotor);


    //filter = new SlewRateLimiter(.5);

    robotDrive = new DifferentialDrive(leftFrontMotorLeader, rightFrontMotorLeader);

    // Right side needs to be inverted
    //leftFrontMotorLeader.setInverted(true);
    rightFrontMotorLeader.setInverted(true);
    leftRearMotor.follow(leftFrontMotorLeader, false);
    rightRearMotor.follow(rightFrontMotorLeader,false);

  // Sets the motors to brake mode
    leftFrontMotorLeader.setIdleMode(IdleMode.kBrake);
    leftRearMotor.setIdleMode(IdleMode.kBrake);
    rightFrontMotorLeader.setIdleMode(IdleMode.kBrake);
    rightRearMotor.setIdleMode(IdleMode.kBrake);

  }

  public void driveRobot(double x, double y) {

    robotDrive.arcadeDrive(x * Constants.driveSpeed, (y * -1) * Constants.driveSpeed);

  }
  //public void joyStickDrive(Joystick driveRobot){
  //   robotDrive.arcadeDrive((driveRobot.getRawAxis(Constants.move) * Constants.driveSpeed), -((driveRobot.getRawAxis(Constants.turn) * -1) * Constants.driveSpeed));
  // }
  //public void driveBackward(){
//robotDrive.tankDrive(Constants.speed, Constants.speed);
 // }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop(){
    robotDrive.stopMotor();
  }
}
