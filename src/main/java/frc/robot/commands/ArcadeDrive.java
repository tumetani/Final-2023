// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  private final DriveTrain m_drive;
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_turn;
  private final BooleanSupplier m_slowMode;

  public ArcadeDrive(DriveTrain m_driveTrain, DoubleSupplier forward, DoubleSupplier turn, BooleanSupplier slowMode) {
    m_drive = m_driveTrain;
    m_forward = forward;
    m_turn = turn;
    m_slowMode = slowMode;
    addRequirements(m_drive);
  }

  @Override
  public void execute() {
    if (m_slowMode.getAsBoolean()) {
      m_drive.slowMode(m_forward.getAsDouble(), m_turn.getAsDouble());
    } else {
      m_drive.arcadeDrive(m_forward.getAsDouble(), m_turn.getAsDouble());
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  public boolean isFinished() {
    return false;
  }
}
