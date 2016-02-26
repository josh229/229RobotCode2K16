package org.usfirst.frc.team229.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team229.robot.commands.DriveForward;


/**
 *
 */
public class Auto extends CommandGroup {
    
    public  Auto() {
    	addSequential(new DriveForward(8000, .5));
    }
}
