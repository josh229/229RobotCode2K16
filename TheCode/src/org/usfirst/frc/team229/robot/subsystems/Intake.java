package org.usfirst.frc.team229.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team229.robot.RobotMap;
import org.usfirst.frc.team229.robot.commands.IntakeSet;

/**
 *
 */
public class Intake extends Subsystem {
	Talon liftingArm1;
	Talon liftingArm2;
	public Intake(){
		liftingArm1 = new Talon(RobotMap.LIFTING_ARM_1);
		liftingArm2 = new Talon(RobotMap.LIFTING_ARM_2);
		
	}
	public void SetIntake(double setSpeed){
		liftingArm1.set(-setSpeed);
		liftingArm2.set(setSpeed);
	}
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeSet());
    }
}

