package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final CANSparkMax arm_motor = new CANSparkMax(5, MotorType.kBrushless); // read parameters from Constants.java

  public Arm() {
  }

  // Move
  public void raise(double speed) {
    arm_motor.set(speed);
  }

  public void lower(double speed) {
    arm_motor.set(speed);
  }

  public void armstop() {
    arm_motor.set(0);
  }

  @Override
  public void periodic() {
  }
}
