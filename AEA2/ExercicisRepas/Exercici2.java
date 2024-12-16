package ExercicisRepas;
import java.util.*;
public class Exercici2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Introdueix el numero de columnes: ");
        int n = lector.nextInt();

        int[][] matriu = new int[5][n];

        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = (int)(Math.random() * 11);
            }
        }
        System.out.println("Aquesta es la matriu 5X" + n + ":");
        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
    }
}
