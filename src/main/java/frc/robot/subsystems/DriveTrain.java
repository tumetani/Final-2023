// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  WPI_TalonSRX leftA = new WPI_TalonSRX(Constants.MotorPorts.LEFT_MOTOR);
  WPI_TalonSRX leftB = new WPI_TalonSRX(Constants.MotorPorts.LEFT_MOTORA);
  WPI_TalonSRX rightA = new WPI_TalonSRX(Constants.MotorPorts.RIGHT_MOTOR);
  WPI_TalonSRX rightB = new WPI_TalonSRX(Constants.MotorPorts.RIGHT_MOTORA);

  MotorControllerGroup leftMotors = new MotorControllerGroup(leftA, leftB);
  MotorControllerGroup rightMotors = new MotorControllerGroup(rightA, rightB);
  DifferentialDrive diffDrive = new DifferentialDrive(leftMotors, rightMotors);

  public DriveTrain() {
    diffDrive.setMaxOutput(0.67);
    rightMotors.setInverted(true);
  }

  public void arcadeDrive(double forward, double turn) {
    diffDrive.arcadeDrive(forward, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
