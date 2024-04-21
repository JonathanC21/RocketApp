package org.cubas;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        double deltaVMs = 0.0;
        double dryMassKg;
        double wetMassKg;
        double exhaustVelocityMs;
        double thrustToWeightRatio = 0.0;
        Scanner scan = new Scanner(System.in);

        logger.info("Program started");

        try {
            System.out.println("Type in the wet mass");
            wetMassKg = scan.nextDouble();
            System.out.println("Type in the dry mass");
            dryMassKg = scan.nextDouble();
            System.out.println("Type in the exhaust velocity");
            exhaustVelocityMs = scan.nextDouble();
            System.out.println("Type in the thrust to weight ratio");
            thrustToWeightRatio = scan.nextDouble();
            deltaVMs = calculateDeltaV(wetMassKg + dryMassKg, dryMassKg, exhaustVelocityMs);
            System.out.println("Delta-V: " + deltaVMs + "m/s");
        }catch (Exception e) {
            logger.error("Invalid input used");
        }

        if (canGoToOrbit(deltaVMs,thrustToWeightRatio)){
            System.out.println("You will go to space today");
        }
        else {
            System.out.println("You will not go to space today");
        }

        logger.info("Program ended");
        System.exit(0);
    }


    static public double calculateInitialMass(double wetMassKg, double dryMassKg){
        return wetMassKg + dryMassKg;
    }
    static public double calculateDeltaV(double initialMassKg,double dryMassKg,double exhaustVelocity){
        return exhaustVelocity* Math.log(initialMassKg/dryMassKg);
    }

    static public boolean canGoToOrbit(double deltaV,double thrustToWeightRatio){
        return deltaV >= 9600.0 & thrustToWeightRatio > 1.0;
    }


}