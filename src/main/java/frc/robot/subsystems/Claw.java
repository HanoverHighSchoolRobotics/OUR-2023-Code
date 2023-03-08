// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
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
  

  public Claw() {

    rotationMotor = new CANSparkMax(Constants.rotationPort, MotorType.kBrushed);
    clampMotor = new CANSparkMax(Constants.clampPort, MotorType.kBrushless);
    armMotor = new CANSparkMax(Constants.armPort, MotorType.kBrushed);

    rotationMotor.setIdleMode(IdleMode.kBrake);
    clampMotor.setIdleMode(IdleMode.kBrake);
    armMotor.setIdleMode(IdleMode.kCoast);

    armEncoder = new Encoder(8,9, false, Encoder.EncodingType.k4X);

   

  }
 
  public void runClamp(double speed) {

    clampMotor.set(speed);

  }

  public void runRotation(double speed) {

    rotationMotor.set(speed);

  }
   public void runArm(double speed) {
   System.out.println("inim" + speed);
   armMotor.set(speed);
   }
   public double getArmPosition() {
    return armEncoder.get();

   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Arm Encoder Ticks", armEncoder.get());
  }
}
