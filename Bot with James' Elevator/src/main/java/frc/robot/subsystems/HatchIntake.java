package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;

public class HatchIntake{
    
    private static DoubleSolenoid hatch = new DoubleSolenoid(0, 1);
    private static DoubleSolenoid arm = new DoubleSolenoid(2, 3);
    private static double prevTime = 0;
    private static int state = 0;

    public static void set(boolean grab, boolean place){
        if(grab == true){
            state = 1;
        }
        else if(place == true){
            state = 2;
        }

        switch (state) {
            case 0 : //Do nada
                break;
            case 1 : //Grab Hatch
                arm.set(DoubleSolenoid.Value.kForward);
                if((frc.robot.subsystems.Time.get() - prevTime) == .25)
                {
                    hatch.set(DoubleSolenoid.Value.kForward);
                    if((frc.robot.subsystems.Time.get() - prevTime) == .5){
                        arm.set(DoubleSolenoid.Value.kReverse);
                    }
                }
                state = 0;
                break;    
            case 2 : //Place Hatch
                arm.set(DoubleSolenoid.Value.kForward);
                if((frc.robot.subsystems.Time.get() - prevTime) == .25)
                {
                    hatch.set(DoubleSolenoid.Value.kReverse);
                    if((frc.robot.subsystems.Time.get() - prevTime) == .5){
                        arm.set(DoubleSolenoid.Value.kReverse);
                    }
                }
                state = 0;
                break;    
        }

        prevTime = frc.robot.subsystems.Time.get();
        System.out.println(arm.get());
        System.out.println(hatch.get());
    }    
}