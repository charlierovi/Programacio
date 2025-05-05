package AEA4.LiniainvertidaEX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Liniainvertida {
    public static void main(String[] args) {
        try {
            File entrada = new File("AEA4/LiniainvertidaEX/entrada.txt");
            Scanner lector = new Scanner(entrada);

            PrintWriter escriptor = new PrintWriter("AEA4/LiniainvertidaEX/sortida.txt");

            while(lector.hasNextLine()) {
                String linia = lector.nextLine();
                String liniaInvertida = new StringBuilder(linia).reverse().toString();
                escriptor.println(liniaInvertida);
            }

            lector.close();
            escriptor.close();

            System.out.println("Les línies s'han invertit i s'han escrit a sortida.txt.");
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: no s'ha trobat el fitxer d'entrada.txt.");
        }
    }
}
