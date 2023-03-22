// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.simulation.ADXRS450_GyroSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

  RelativeEncoder rightEncoder;
  RelativeEncoder leftEncoder;

  SlewRateLimiter filter;
  public double ticksPerRotation = 42;
 
  private double driveSpeed = Constants.driveSpeed;

  private ADXRS450_Gyro gyro = new ADXRS450_Gyro(); 

  public Drivetrain() {
    
    //Assigning ports to Motors
    leftFrontMotorLeader = new CANSparkMax(Constants.leftFrontPort, MotorType.kBrushless);
    leftRearMotor = new CANSparkMax(Constants.leftRearPort, MotorType.kBrushless);
    rightFrontMotorLeader = new CANSparkMax(Constants.rightFrontPort, MotorType.kBrushless);
    rightRearMotor = new CANSparkMax(Constants.rightRearPort, MotorType.kBrushless);

    rightEncoder = rightFrontMotorLeader.getEncoder();
    leftEncoder = leftFrontMotorLeader.getEncoder();

    rightEncoder.setPosition(0.0);
    leftEncoder.setPosition(0.0);

      //new gyro

    gyro.calibrate();


    

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
  public double TicksToFeet() {
    return (getDrivePosition() * (Math.PI *6)) / ticksPerRotation;
  }

  
  
  public void driveRobot(double x, double y) {

    robotDrive.arcadeDrive(x * driveSpeed, (y * -1) * Constants.TURN_SPEED);

    //System.out.println("Podnodnsnodnsondondondsonsdondsondond");
  }

  public void setDriveSpeed(double speed) {
    driveSpeed = speed;
  }
  public double getLeftDrivePosition() {
    return leftEncoder.getPosition();  
  }
  public double getRightDrivePosition() {
    return rightEncoder.getPosition();  
  }

  public double getDrivePosition() {
    return (leftEncoder.getPosition() + rightEncoder.getPosition()) / 2;
  }
  public void setMotorSpeed(double leftDriveSpeed, double rightDriveSpeed) {
    leftFrontMotorLeader.set(leftDriveSpeed);
    rightFrontMotorLeader.set(rightDriveSpeed);
   }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Right Side Drive Ticks", rightEncoder.getPosition() );
    SmartDashboard.putNumber("Left Side Drive Ticks", leftEncoder.getPosition() );
    SmartDashboard.putNumber("Drive Ticks", getDrivePosition() );
    SmartDashboard.putNumber("Ticks to feet", TicksToFeet() );
    
    SmartDashboard.putData(gyro);



  }

  public void stop(){
    robotDrive.stopMotor();
    gyro.close();
  }
}
