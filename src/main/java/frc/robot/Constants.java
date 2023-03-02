// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  // Ports
  public static final int leftFrontPort = 7;
  public static final int leftRearPort = 5;
  public static final int rightFrontPort = 9;
  public static final int rightRearPort = 4;

  //Non-drive Ports
  public static final int rotationPort = 8;
  public static final int clampPort = 6;
  //public static final int winchPort = 2;
  public static final int Flight2Port = 0;
  public static final int Flight1Port = 1;

  //Speeds
  public static final int stopSpeed = 0;
  public static final int winchSpeed = 1;
  public static final int winchSpeed2 = 1;
  public static final double speed = .5;
  public static final double driveSpeed = .5;


  public static final int move = 1;
  public static final int turn = 2;


  
}
