package frc.robot.commands;


import frc.robot.subsystems.Winch;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;



public class WinchU extends CommandBase {
  
    Winch winch;

  public WinchU(Winch w) {
    winch = w;
    addRequirements(winch);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    winch.move(Constants.winchSpeed, Constants.winchSpeed2);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    winch.stop();



  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
