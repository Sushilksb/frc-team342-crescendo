// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.LED_Constants.*;

public class LED_Subsystem extends SubsystemBase {
  /** Creates a new LED_Subsystem. **/

  private final AddressableLED LED;
  private final AddressableLEDBuffer LEDBuffer;

  public LED_Subsystem()
  {
    LED = new AddressableLED(PWM_Port);
    LEDBuffer = new AddressableLEDBuffer(LENGTH);
    LED.setLength(LEDBuffer.getLength());
    LED.setData(LEDBuffer);
    LED.start();
  }

  public void LED_Off()
  {
    for(int i = 0; i < LEDBuffer.getLength(); i++)
    {
      LEDBuffer.setHSV(i, 0, 0, 0);
    }
    LED.setData(LEDBuffer);
  }

    public void LED_RED()
    {
      for(int i = 0; i < LEDBuffer.getLength(); i++)
      {
        LEDBuffer.setHSV(i, RED_H, RED_S, RED_V);
      }
      LED.setData(LEDBuffer);
    }

    public void LED_GREEN()
    {
      for(int i = 0; i < LEDBuffer.getLength(); i++)
      {
        LEDBuffer.setHSV(i, GREEN_H, GREEN_S, GREEN_V);
      }
      LED.setData(LEDBuffer);
    }

    public Command LED_RED_Command()
    {
      return runEnd(() -> LED_RED(), this::LED_Off); 
    }

    public Command LED_GREEN_Command()
    {
      return runEnd(() -> LED_GREEN(), this::LED_Off);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
