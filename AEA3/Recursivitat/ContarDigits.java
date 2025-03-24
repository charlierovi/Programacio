package AEA3.Recursivitat;

import java.util.*;

public class ContarDigits {
    public static int contarDigits(int n) {
        if (n < 10) {
            return 1;
        }
        return 1 + contarDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Introduce el numero y te digo cuantos digitos tiene: ");
        int numero = lector.nextInt();
        System.out.println("El número " + numero + " tiene " + contarDigits(numero) + " dígitos.");
    }
}
