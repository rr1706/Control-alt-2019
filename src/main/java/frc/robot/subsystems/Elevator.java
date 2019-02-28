package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.*;
//import com.kauailabs.navx.*;
//import java.util.*;
import com.revrobotics.*;
import frc.robot.*;

public class Elevator{

    private static CANSparkMax ElMotor;
    private static CANEncoder ElEncoder;
    private static CANPIDController ElPID;

    private static double ElP = 0.001;
    private static double ElI = 0.0;
    private static double ElD = 0.0;
    private static double ElF = 0.0;
    private static double ElMax = 1;
    private static double ElMin = -1;
//    public static int ElCase = 0;

//    private static double ElSet = 0.0;

    private static boolean manual = false;
//    private static int manualToggle = 0;
//    private static boolean manualToggled = false;
    
    public static void init(int port){
        ElMotor = new CANSparkMax(port, CANSparkMaxLowLevel.MotorType.kBrushless);

        ElEncoder = new CANEncoder(ElMotor);

        ElMotor.setInverted(false);

        ElPID = ElMotor.getPIDController();
        ElPID.setP(ElP);
        ElPID.setI(ElI);
        ElPID.setD(ElD);
        ElPID.setIZone(0.0);
        ElPID.setFF(ElF);
        ElPID.setOutputRange(ElMin, ElMax);
    }

    public static void set(int ElCase){
        manual = false;
        int manualToggle = 0;
        switch(manualToggle){
            case 0 :
                System.out.println("manual T");
                if((Robot.xbox2.LStickButton() == true) && (Robot.xbox2.RStickButton() == true)){
                    manual = true;
                    manualToggle = 1;
                }
                break;
            case 1 :
                System.out.println("manual F");
                if((Robot.xbox2.LStickButton() == true) && (Robot.xbox2.RStickButton() == true)){
                    manual = false;
                    manualToggle = 0;
                }
            break;
            }

        if(manual == false){
            // if(Robot.xbox2.LStickY() == 1){ //Left stick/Bumper = Hatch
            //     if(Robot.xbox2.LB() == true){ //High
            //         ElCase = 2;
            //     }
            // }
            // if(Robot.xbox2.LStickY() == -1){ 
            //     if(Robot.xbox2.LB() == true){ //Mid
            //         ElCase = 1;
            //     }
            //     else if(Robot.xbox2.LB() == false){ //Low
            //         ElCase = 0;
            //     }
            // }
            // if(Robot.xbox2.RStickY() == 1){ //Right stick/bumper = Ball
            //     if(Robot.xbox2.RB() == true){ //High
            //         ElCase = 5;
            //     }
            // }
            // if(Robot.xbox2.RStickY() == -1){ 
            //     if(Robot.xbox2.RB() == false){ //Mid
            //         ElCase = 4;
            //     }
            //     else if(Robot.xbox2.RB() == false){ //Low
            //         ElCase = 3;
            //     }
            // }

            switch(ElCase){
                case 0 : //Hatch: low
                    ElPID.setReference(7.07, ControlType.kPosition); 
                    break;
                case 1 : //Hatch: mid
                    ElPID.setReference(33.26, ControlType.kPosition);
                    break;
                case 2 : //Hatch: high
                    ElPID.setReference(60, ControlType.kPosition);
                    break;
                case 3 : //Ball: low
                    ElPID.setReference(12.4, ControlType.kPosition);
                    break;
                case 4 : //Ball: mid
                    ElPID.setReference(39.5, ControlType.kPosition);
                    break;
                case 5 : //Ball: high
                    ElPID.setReference(65, ControlType.kPosition);
                    break;
            }
        }

        if(manual == true){
            ElMotor.set(Robot.xbox2.LStickY());
        }

        System.out.println(ElEncoder.getPosition());
    }
}