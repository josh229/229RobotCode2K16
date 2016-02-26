package org.usfirst.frc.team229.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team229.robot.commands.ShiftUp;
import org.usfirst.frc.team229.robot.commands.ShiftDown;
import org.usfirst.frc.team229.robot.commands.Shoot;
import org.usfirst.frc.team229.robot.commands.Feed_In;
import org.usfirst.frc.team229.robot.commands.Feed_Out;
import org.usfirst.frc.team229.robot.commands.ReverseShooter;
//import org.usfirst.frc.team229.robot.commands.ToTarget;

public class OI {
	Joystick Left = new Joystick(0);
	Joystick Right = new Joystick(1);
	Joystick Operator = new Joystick(2);
	Button shiftUp;
	Button shiftDown;
	Button shootBall;
	Button reverseShooter;
	Button feedIn;
	Button feederOut;
	Button Aim;
	static NetworkTable table;

public OI(){
	table = NetworkTable.getTable("datatable");
	
	shiftUp = new JoystickButton(Left,5);
	shiftUp.whenPressed(new ShiftUp());
	
	shiftDown = new JoystickButton(Right, 6);
	shiftDown.whenPressed(new ShiftDown());
	
	shootBall = new JoystickButton(Operator, 6);
	shootBall.whileHeld(new Shoot());
	
	reverseShooter = new JoystickButton(Operator,7);
	reverseShooter.whileActive(new ReverseShooter());
	
	feedIn = new JoystickButton(Operator,1);
	feedIn.whileHeld(new Feed_In());
	
	feederOut = new JoystickButton(Operator,2);
	feederOut.whileHeld(new Feed_Out());
	
	//Aim = new JoystickButton(Right,1);
	//Aim.whenPressed(new ToTarget());
	
}
public double setIntake(){
	return Operator.getRawAxis(5);
}
public double getLeft() {

	return Left.getRawAxis(1);
}
public double getRight() {
	
	return Right.getRawAxis(1);
}
public double getIntakeRoller(){
	return Operator.getRawAxis(1);
}
public static double VisionX(){
	
	double X = 0;
	System.out.println(X);

	try{ 
	
	X = table.getNumber("X", X);
	
	} catch (Exception ex){
		System.out.println("CAUGHT");
		ex.printStackTrace();
		
	}
	System.out.println(X);
	
	return X;
}
}

