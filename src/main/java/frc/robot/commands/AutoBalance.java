package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoBalance extends CommandBase {
    private BalanceCalc m_balancecalc;
    private DriveTrain m_drivetrain;
    public AutoBalance(BalanceCalc balanceCalc, DriveTrain driveTrain) {
        m_balancecalc = balanceCalc;
        m_drivetrain = driveTrain;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double speed = m_balancecalc.autoBalanceRoutine();
        m_drivetrain.setSpeed(speed, speed);
    }
}
