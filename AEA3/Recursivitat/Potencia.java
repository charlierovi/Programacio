package AEA3.Recursivitat;

import java.util.*;

public class Potencia {
     public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * potencia(base, exponente - 1);
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Introduce la base: ");
        int base = lector.nextInt();
        System.out.println("Introduce el exponente: ");
        int exponente = lector.nextInt();
        System.out.println(base + "^" + exponente + " = " + potencia(base, exponente));
    }
}

