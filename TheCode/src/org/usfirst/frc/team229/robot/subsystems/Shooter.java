package org.usfirst.frc.team229.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;

import org.usfirst.frc.team229.robot.RobotMap;


/**
 *
 */
public class Shooter extends Subsystem {
	CANTalon shootRight;
	CANTalon shootLeft;
	
	public Shooter(){
		shootRight = new CANTalon(RobotMap.SHOOTER_RIGHT);
		shootLeft = new CANTalon(RobotMap.SHOOTER_LEFT);
	}
	public void ShootBall(double shotSpeed){
		shootRight.set(shotSpeed);
		shootLeft.set(shotSpeed*-1);	
	}
    public void initDefaultCommand() {
     
    }
}
