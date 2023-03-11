// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.ControllerPorts;

//import frc.robot.commands.Autos;
import frc.robot.commands.OutakeObject;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DriveTime;
import frc.robot.commands.ElevatorExtend;
import frc.robot.commands.IntakeObject;
import frc.robot.commands.LiftArm;
import frc.robot.commands.LowerArm;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.Constants.Speeds;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Intake m_intake = new Intake();
  private final Arm m_arm = new Arm();
  private final DriveTrain m_drive = new DriveTrain();
  private final Elevator m_elevator = new Elevator();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  public XboxController driverController = new XboxController(ControllerPorts.kDriverControllerPort);
  public Joystick subControllerJoystick = new Joystick(ControllerPorts.kJoystickPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_arm.setDefaultCommand(new LiftArm(m_arm, 0));
    m_intake.setDefaultCommand(new IntakeObject(m_intake, 0));
    m_elevator.setDefaultCommand(new ElevatorExtend(m_elevator, 0));
  }

  private void configureBindings() {

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.
    // driverController.getRawButton(1).whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  public void Intake() {

    if (subControllerJoystick.getRawButton(7)) {
      m_intake.setIntakeSpeed(0.8);
    } else {
      m_intake.setIntakeSpeed(0.00);
    }
  }

  public void hold() {
    if (subControllerJoystick.getRawButtonPressed(2)) {
      m_intake.setIntakeSpeed(0.02);
    } else {
      m_intake.setIntakeSpeed(0);
    }
  }

  public void Outake() {

    if (subControllerJoystick.getRawButton(3)) {
      m_intake.setIntakeSpeed(0.8);
    } else {
      m_intake.setIntakeSpeed(0.00);
    }
  }

  public void Armup() {
    if (subControllerJoystick.getRawButton(8)) {
      m_arm.setArmSpeed(-0.67);
    } else {
      m_arm.setArmSpeed(0.0);
    }
  }

  public void Armdown() {
    if (subControllerJoystick.getRawButton(5)) {
      m_arm.setArmSpeed(0.67);
    } else {
      m_arm.setArmSpeed(0.00);
    }
  }

  public void Elevator() {
    if (subControllerJoystick.isConnected()) {
      m_elevator.elevatorUp(subControllerJoystick.getRawAxis(1) * -1 * Constants.Speeds.ELEVATOR_JOYSTICK_COEFFICIENT);
    }
  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
        // new LiftArm(m_arm, Speeds.ARM_SPEED).withTimeout(1),
        //new DriveTime(Speeds.DRIVE_SPEED, 2, m_drive),
        new LiftArm(m_arm, Speeds.ARM_SPEED).withTimeout(0.5),
        new ElevatorExtend(m_elevator,Speeds.ELEVATOR_SPEED).withTimeout(1),
        new OutakeObject(m_intake, 0.80).withTimeout(1),
        new DriveTime(Speeds.DRIVE_SPEED, 2);



    // new Outake(m_intake, Constants.INTAKE_SPEED).withTimeout(3),
    // new LowerArm(m_arm, Speeds.ARM_SPEED).withTimeout(1));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {}
  // An example command will be run in autonomous
  public Command getarcadeDriveCommand() {
    return new ArcadeDrive(
        m_drive, () -> -driverController.getRawAxis(1), () -> driverController.getRawAxis(4));
  }
}
