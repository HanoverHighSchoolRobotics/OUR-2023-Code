// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Claw extends SubsystemBase {
  
  CANSparkMax rotationMotor;
  CANSparkMax clampMotor;
  CANSparkMax armMotor;
  Encoder armEncoder;
  Encoder rotateEncoder;
  RelativeEncoder clampEncoder;
  private final double kTickToDeg = 360 / 512 * 26/42*18/60*18/84;
  

  public Claw() {

    rotationMotor = new CANSparkMax(Constants.rotationPort, MotorType.kBrushed);
    clampMotor = new CANSparkMax(Constants.clampPort, MotorType.kBrushless);
    //armMotor = new CANSparkMax(Constants.armPort, MotorType.kBrushed);

    rotationMotor.setIdleMode(IdleMode.kCoast);
    clampMotor.setIdleMode(IdleMode.kBrake);
    //armMotor.setIdleMode(IdleMode.kCoast);

    //armEncoder = new Encoder(8,9, false, Encoder.EncodingType.k4X);
    rotateEncoder = new Encoder(4, 5);   // wont run until we know ports so ask gabe about it
    clampEncoder = clampMotor.getEncoder();
   
    clampEncoder.setPosition(0.0);

    rotationMotor.setSoftLimit(SoftLimitDirection.kReverse, 4000);
    rotationMotor.setSoftLimit(SoftLimitDirection.kForward, -4000);

    


    

   

  }
 
  public void runClamp(double speed) {

    clampMotor.set(speed);

  }

  public void runRotation(double speed) {

    // if (rotateEncoder.get() <= -4260) {
    //   rotationMotor.set(0);
    // } else if (rotateEncoder.get() >= 4200) {
      // rotationMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
    // } else {
      rotationMotor.set(speed);
      System.out.println(speed);
    // }

  }
  //  public void runArm(double speed) {
  //  armMotor.set(speed);
  //  }
  //  public double getArmPosition() {
  //   return armEncoder.get();

  //  }

   public double getRotatePosition() {
    return rotateEncoder.get();
   }

   public double getClampPosition() {

    return clampEncoder.getPosition();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   // SmartDashboard.putNumber("Arm Encoder Ticks", armEncoder.get());
    SmartDashboard.putNumber("Rotate Encoder Ticks", rotateEncoder.get());
    SmartDashboard.putNumber("Clamp Encoder Ticks", clampEncoder.getPosition());
    //SmartDashboard.putNumber("Tick Constant", (double) 360 / 512 * 26/42*18/60*18/84);
    // SmartDashboard.putNumber("Arm Encoder Ticks Normal", armEncoder.get());
    //System.out.println("I am working Smart dashboard");
    // System.out.println(kTickToDeg);
    // System.out.println(armEncoder.get());
  }
}
