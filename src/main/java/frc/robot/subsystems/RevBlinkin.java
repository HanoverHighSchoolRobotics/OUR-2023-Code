package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class RevBlinkin extends SubsystemBase {
  
  private static AddressableLED m_blinkin;
  private static AddressableLEDBuffer m_ledBuffer;
  public RevBlinkin() {
    m_blinkin = new AddressableLED(Constants.blinkinPort);
    //solid_orange();

    m_ledBuffer = new AddressableLEDBuffer(105);

    m_blinkin.setLength(m_ledBuffer.getLength());

    m_blinkin.setData(m_ledBuffer);
    m_blinkin.start();
  }

  public void rainbow() {

   int m_rainbowFirstPixelHue = 0;

  for (var i = 0; i < m_ledBuffer.getLength(); i++) {
  final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;

  m_ledBuffer.setHSV(i, hue, 255, 128);
  }

  m_rainbowFirstPixelHue += 3;

  m_rainbowFirstPixelHue %= 180;


  }

  }