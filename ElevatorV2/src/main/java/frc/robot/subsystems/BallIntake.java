package frc.robot.subsystems;

import frc.robot.*;
import edu.wpi.first.wpilibj.*;
//import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class BallIntake{
    private static DoubleSolenoid ball = new DoubleSolenoid(4, 5);
    private static int state = 0;
    private static TalonSRX BallMotor = new TalonSRX(10);
    public static double speed;

    public static void set(boolean grab, boolean hold){
        if(grab == true){
            state = 1;
        }
        if(hold == true){
            state = 2;
        }
        switch (state){
            case 0 :
                break;
            case 1 :
                ball.set(DoubleSolenoid.Value.kForward);
                state = 0;
                break;
            case 2 :
                ball.set(DoubleSolenoid.Value.kReverse);
                state = 0;
                break;
        }
        if(Robot.xboxEl.RTrig() >= 0.5){
            speed = Robot.xboxEl.RTrig();
            BallMotor.set(ControlMode.PercentOutput, speed);
        }
        if(Robot.xboxEl.LTrig() >= 0.5){
            speed = Robot.xboxEl.LTrig();
            BallMotor.set(ControlMode.PercentOutput, -speed);
        }
    }
}