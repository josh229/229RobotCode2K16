package org.usfirst.frc.team229.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team229.robot.RobotMap;


/**
 *
 */
public class Feeder extends Subsystem {
	Talon feederRoller;
	
	public Feeder(){
		feederRoller = new Talon(RobotMap.SHOOTER_FEEDER);
		
	}
    public void setFeed(double feed){
    	feederRoller.set(feed);
    }

    public void initDefaultCommand() {
     
    }
}

