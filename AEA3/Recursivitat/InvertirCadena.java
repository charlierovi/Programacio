package AEA3.Recursivitat;

import java.util.*;

public class InvertirCadena {
    public static String invertir(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + invertir(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Introduce una palabra que quieras invertir: ");
        String texto = lector.nextLine();
        System.out.println(invertir(texto)); 
    }
}


