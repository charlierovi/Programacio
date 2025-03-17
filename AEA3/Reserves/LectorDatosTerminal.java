package AEA3.Reserves;

import java.util.*;

public class LectorDatosTerminal {

    private Scanner lector = new Scanner(System .in);

    public double leerDouble() {        //Pregunta constantment m'entre's no rebi el velor que volem (Double)
        Scanner lector = new Scanner(System.in);
        boolean llegit = false;
        while(!llegit) {
            if (lector.hasNextDouble()) {
                    llegit = true;
                    return lector.nextDouble();
                }
                else {
                    lector.next();
            }
        }
        return 0;
    }

    public int leerInt() {
        Scanner lector = new Scanner(System.in);
        boolean llegit = false;
        while (!llegit) {
            if (lector.hasNextInt()) {
                llegit = true;
                return lector.nextInt();
            } else {
                lector.next();
            }
        }
        return 0;
    }

    public float leerFloat() {
        Scanner lector = new Scanner(System.in);
        boolean llegit = false;
        while (!llegit) {
            if (lector.hasNextFloat()) {
                llegit = true;
                return lector.nextFloat();
            } else {
                lector.next();
            }
        }
        return 0;
    }

    public boolean leerBoolean() {
        Scanner lector = new Scanner(System.in);
        boolean llegit = false;
        while (!llegit) {
            if (lector.hasNextBoolean()) {
                llegit = true;
                return lector.nextBoolean();
            } else {
                lector.next();
            }
        }
        return false;
    }

    public String leerString() {
        Scanner lector = new Scanner(System.in);
        return lector.nextLine();
    }

    public char leerChar() {
        Scanner lector = new Scanner(System.in);
        return lector.next().charAt(0);
    }

}