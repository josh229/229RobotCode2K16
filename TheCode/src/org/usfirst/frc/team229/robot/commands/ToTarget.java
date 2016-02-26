package org.usfirst.frc.team229.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


import org.usfirst.frc.team229.robot.commands.Aim;
import org.usfirst.frc.team229.robot.OI;

/**
 *
 */
public class ToTarget extends CommandGroup {
    
    public  ToTarget() {
        addSequential(new Aim(OI.VisionX(),.5));
    }
}
