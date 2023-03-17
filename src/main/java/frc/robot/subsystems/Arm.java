// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Arm extends SubsystemBase {
  /** Creates a new Arm. */

  CANSparkMax armMotor;
  //Encoder armEncoder;

  double kDeg2Ticks;

  double armTicks;
  private int countsPerRev = 1120; 
  private int gearReduction = 100;
  private double kF;


  public Arm() {
    armMotor = new CANSparkMax(Constants.armPort, MotorType.kBrushed);
    armMotor.setIdleMode(IdleMode.kBrake);


    //armEncoder = new Encoder(8,9, false, Encoder.EncodingType.k4X);

    //armTicks = armEncoder.get();
  }
  public double deg2Ticks(double degrees){
    return degrees / 360 * (countsPerRev * gearReduction);
  }
  public double ticks2Deg(double ticks){
    
    return (ticks / (countsPerRev * gearReduction)) * 360; 
  }

  public void runArm(double speed) {
    armMotor.set(speed);

    }
    // public double getArmPosition() {
    //  return armEncoder.get() - deg2Ticks(60);
 
    // }
    public void stopMotor() {
      armMotor.set(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("Arm Encoder Ticks", getArmPosition());
    // SmartDashboard.putNumber("Arm Encoder Degrees", ticks2Deg(getArmPosition()) );
    SmartDashboard.putNumber("kF", kF);
    kF = SmartDashboard.getNumber("kF", kF);
  }
}
