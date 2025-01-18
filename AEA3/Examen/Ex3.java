package AEA3.Examen;
import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Indica cuantas filas va a tener la matriz: ");
        int filas = lector.nextInt();

        System.out.println("Indica cuantas columnas va a tener la matriz: ");
        int columnas = lector.nextInt();

        
        int[][] matriz = new int[filas][columnas];


        for(int i = 0; i < matriz.length; i++) {
            for(int j= 0; j < matriz[i].length; ++j){
                System.out.println("Introduce numero para la matriz: ");
                int numero = lector.nextInt(); 
                matriz[i][j] = numero;
            }
        }
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

