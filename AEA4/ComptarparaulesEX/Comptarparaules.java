package AEA4.ComptarparaulesEX;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Comptarparaules {
    public static void main(String[] args) {
        int paraules = 0;

        try{
            File entrada = new File("AEA4/ComptarparaulesEX/entrada.txt");
            Scanner lector = new Scanner(entrada);

            while(lector.hasNext()){
                lector.next();
                paraules++;
            }

            PrintWriter escriptor = new PrintWriter("AEA4/ComptarparaulesEX/sortida.txt");
            escriptor.println("Nombre total de paraules: " + paraules);
            escriptor.close();
            System.out.println("Nombre total de paraules: " + paraules);
        }
        catch(FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer entrada.txt.");
        }
    }
}
