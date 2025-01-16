package AEA3.RepasExamen;
//Crear una matriz de 5 filas y n columnas (se pide al usuario). Rellenarlo con números aleatorios entre 0 y 10.
import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Escriu el numero de columnes que vulguis.");
        int columnes = lector.nextInt();

        int[][] matriu = new int[5][columnes];

        Random random = new Random();
        
        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < columnes; j++) {
                matriu[i][j] = random.nextInt(11);
            }
        }
        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < columnes; j++) {
                System.out.print(matriu[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
