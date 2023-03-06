 package frc.robot.commands;


import frc.robot.subsystems.Winch;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;



public class WinchU extends CommandBase {
  
  public Winch winch;
  
  

  public WinchU(Winch w) {
    winch = w;
    
}

public WinchU(Winch winch2, int stopspeed) {
}

public WinchU(Winch winch2, double d) {
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    winch.RunWinch(Constants.winchSpeed);


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

