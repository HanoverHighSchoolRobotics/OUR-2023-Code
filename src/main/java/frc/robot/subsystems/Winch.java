// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Winch extends SubsystemBase {
  /** Creates a new WinchDown. */
  Spark winchLift; 
  double winchPosition; 
  Spark winchLift2; 
  public Winch() {
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void move(double speed,double speed2){
    winchLift.set(speed); 
    winchLift2.set(-speed2);
  }
  public void stop(){
    winchLift.set(0);
    winchLift2.set(0); 
  }
}
