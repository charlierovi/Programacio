public class ExMatrius3 {
    public static void main(String[] args) {
        
        int [][] matriuParells = new int[10][10];

        for(int i = 0; i < matriuParells.length; i++) {
            for(int j = 0; j < matriuParells[i].length; j++) {
                if(i % 2 == 0 & j % 2 == 0) {
                    matriuParells[i][j] = 1;
                }
            else if(i % 2 == 0 & j % 2 != 0) {
                matriuParells[i][j] = 2;
            }
            else if(i % 2 != 0 & j % 2 == 0) {
                matriuParells[i][j] = 3;
            }
            else if(i % 2 != 0 & j % 2 != 0) {
                matriuParells[i][j] = 4;
            }
            else {
                matriuParells[i][j] = i;
            }
            System.out.println("La posició " + i + " " + j + " de la matriu matriuParells val: " + matriuParells[i][j]);
           }
           System.out.println("La fila " + i + " de la matriu matriuParells ja està tota plena");
           System.out.println();
        }
    }   
}

