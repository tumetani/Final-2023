package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDrive extends CommandBase {
  private final DriveTrain m_drive;
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_turn;

  public ArcadeDrive(DriveTrain m_driveTrain, DoubleSupplier forward, DoubleSupplier turn) {
    m_drive = m_driveTrain;
    m_forward = forward;
    m_turn = turn;
    addRequirements(m_drive);
  }

  @Override
  public void execute() {
    m_drive.arcadeDrive(m_forward.getAsDouble(), m_turn.getAsDouble());

  }
}
