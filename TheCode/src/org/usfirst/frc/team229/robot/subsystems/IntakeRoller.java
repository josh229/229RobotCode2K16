package org.usfirst.frc.team229.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team229.robot.RobotMap;
import org.usfirst.frc.team229.robot.commands.RollerSet;


/**
 *
 */
public class IntakeRoller extends Subsystem {
	Talon intakeRoller;
	
	public IntakeRoller(){
		intakeRoller = new Talon(RobotMap.INTAKE_ROLLER);
		
	}
    public void setFeed(double feed){
    	intakeRoller.set(feed*.75);
    }
    

    public void initDefaultCommand() {
    	setDefaultCommand(new RollerSet()); 	
    }
}

