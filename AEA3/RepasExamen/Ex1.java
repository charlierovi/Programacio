package AEA3.RepasExamen;
//Crear una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla, tal como aparece en la matriz.
public class Ex1 {
    public static void main(String[] args) {
        int[][] matriu = new int[3][3];
        int contador = 1;
        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = contador;
                contador++;
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
