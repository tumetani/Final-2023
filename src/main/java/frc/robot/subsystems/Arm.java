// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  CANSparkMax arm_motor = new CANSparkMax(5, MotorType.kBrushless);

  public Arm() {

  }

  public void setArmSpeed(double speed) {
    arm_motor.set(-speed);
  }

  public void LiftArm(double speed) {
    arm_motor.set(-speed);
  }

  public void LowerArm(double speed) {
    arm_motor.set(speed);
  }
}
