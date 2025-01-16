package AEA3;

public class Parellsimatriu {
    public static void main(String[] args) {
        int[] senars = new int[100];
        int[] parells = new int[100];
        
        for(int i = 0; i < 100; i++) {
            parells[i] = 2 * i;
        }
        int indice = 0;
        int[][] matriu = new int[5][20];
        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < matriu[i].length; j++) {
               System.out.print(parells[indice] + "\t");
               indice++;
            }
            System.out.println();
        }
    }
}

