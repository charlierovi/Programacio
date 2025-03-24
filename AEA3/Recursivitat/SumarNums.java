package AEA3.Recursivitat;

import java.util.*;

public class SumarNums {
    public static int sumar(int n) {
        if (n == 0) {
            return 0;
        }
        if (n > 1) {
        System.out.print(n + " + ");
        }
        else {
            System.out.print(n);
        }
        return n + sumar(n - 1);
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Introduce un numero y te doy el resultado de la suma: ");
        int numero = lector.nextInt();
        System.out.println("La suma de los primeros " + numero + " números es: ");
        int resultado = sumar(numero);
        System.out.println(" = " + resultado);
    }
}
