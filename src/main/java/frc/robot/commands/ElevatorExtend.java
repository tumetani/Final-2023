package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorExtend extends CommandBase {
    private final Elevator m_elevator;
    double m_speed;

    public ElevatorExtend(Elevator subsystem, double speed) {
        m_elevator = subsystem;
        addRequirements(m_elevator);
        m_speed = speed;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
