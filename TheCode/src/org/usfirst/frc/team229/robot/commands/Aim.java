package org.usfirst.frc.team229.robot.commands;

import org.usfirst.frc.team229.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command drives the robot over a given distance with simple proportional
 * control This command will drive a given distance limiting to a maximum speed.
 */
public class Aim extends Command {
	private double driveForwardSpeed;
	private double distance;
	private double error;
	private final double TOLERANCE = .1;
	private final double KP = -1.0 / 5.0;

	public Aim() {
		this(10, 0.5);
	}

	public Aim(double dist) {
		this(dist, 0.5);
	}

	public Aim(double dist, double maxSpeed) {
		requires(Robot.drivetrain);
		distance = dist;
		driveForwardSpeed = maxSpeed;
	}

	protected void initialize() {
		Robot.drivetrain.reset();
		setTimeout(2);
	}

	protected void execute() {
		error = (distance - Robot.drivetrain.getRight());
		if (driveForwardSpeed * KP * error >= driveForwardSpeed) {
			Robot.drivetrain.turn(driveForwardSpeed);
		} else {
			Robot.drivetrain.turn(driveForwardSpeed * KP * error);
		}
	}

	protected boolean isFinished() {
		return (Math.abs(error) <= TOLERANCE) || isTimedOut();
	}

	protected void end() {
		Robot.drivetrain.tank(0,0);
	}

	protected void interrupted() {
		end();
	}
}
