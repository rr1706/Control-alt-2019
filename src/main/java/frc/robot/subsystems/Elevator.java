package frc.robot.subsystems;

import java.util.*;
import java.io.*;
import com.revrobotics.*;
import edu.wpi.first.hal.*;
import edu.wpi.first.wpilibj.*;
import frc.robot.commands.*;

public class Elevator{ 
    private CANSparkMax ElMotor;
    private CANEncoder ElEncoder;
    private CANPIDController ElPID;
    private double ElmotorP = 3e-4;

}
