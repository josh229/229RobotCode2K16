
package org.usfirst.frc.team229.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team229.robot.RobotMap;
import org.usfirst.frc.team229.robot.commands.TankDrive;



/**
 *
 */

public class DriveTrain extends Subsystem {
	
	
	CANTalon left1;
	CANTalon left2;
	CANTalon right1;
	CANTalon right2;
	RobotDrive drivebase;
	DoubleSolenoid shifter;
	Encoder right_encoder;
	Encoder left_encoder;

	public DriveTrain() {
		
		left1 = new CANTalon(RobotMap.DRIVE_LEFT_1);
		left2 = new CANTalon(RobotMap.DRIVE_LEFT_2);
		right1 = new CANTalon(RobotMap.DRIVE_RIGHT_1);
		right2 = new CANTalon(RobotMap.DRIVE_RIGHT_2);
		drivebase = new RobotDrive(left1,left2,right1,right2);
		shifter = new DoubleSolenoid(RobotMap.CAN_BUS_CHANNEL,
				RobotMap.DOUBLE_SOLENOID_0,RobotMap.DOUBLE_SOLENOID_1);
		right_encoder = new Encoder(RobotMap.ENCODER_RIGHT_A,RobotMap.ENCODER_RIGHT_B);
		left_encoder = new Encoder(RobotMap.ENCODER_LEFT_A,RobotMap.ENCODER_LEFT_B);
		drivebase.setSafetyEnabled(false);
	
	}
	
	public void tank(double left, double right){
        drivebase.tankDrive(-left*Math.abs(left), -right*Math.abs(right)*-1); 
    }
	public void shiftUp() {
	shifter.set(DoubleSolenoid.Value.kForward);	
	}
	public void shiftDown(){
	shifter.set(DoubleSolenoid.Value.kReverse);
	}
	public int getDistance() {
		return ((right_encoder.getRaw()+left_encoder.getRaw())/2);
	}
	public int getLeft(){
		return left_encoder.getRaw();
	}
	public int getRight(){
		return right_encoder.getRaw();
	}
	
	public void turn(double turn) {
		drivebase.arcadeDrive(0, turn);
	}
	public void reset() {
		left_encoder.reset();
		right_encoder.reset();
	}
	public void stopAllDrive(){
		drivebase.arcadeDrive(0, 0);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}
