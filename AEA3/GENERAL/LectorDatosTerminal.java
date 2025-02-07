package AEA3.GENERAL;

import java.util.Scanner;

public class LectorDatosTerminal {
    public double leerDouble(){
        Scanner s = new Scanner(System.in);
        boolean noleido = true;
        while(noleido) {
            if (s.hasNextDouble()) {
                noleido = false;
                return s.nextDouble();
            } 
            else {
                s.next();
            }
        }
        return 0;
    }

    public int leerInt(){
        Scanner s = new Scanner(System.in);
        boolean noleido = true;
        while(noleido) {
            if (s.hasNextInt()) {
                noleido = false;
                return s.nextInt();
            } 
            else {
                s.next();
            }
        }
        return 0;
    }

    public float leerFloat(){
        Scanner s = new Scanner(System.in);
        boolean noleido = true;
        while(noleido) {
            if (s.hasNextFloat()) {
                noleido = false;
                return s.nextFloat();
            } 
            else {
                s.next();
            }
        }
        return 0;
    }
}
