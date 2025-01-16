package AEA3;

public class ExMatriusRepas {
    public static void main(String[] args) {
        char[][] matriu = new char[5][20];

        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < matriu[i].length; j++) {
                if(i % 2 == 0 & j % 2 == 0) {
                    matriu[i][j] = 'a';
                }
                else if(i % 2 == 0 & j % 2 != 0) {
                    matriu[i][j] = 'z';
                }
                else if(i % 2 != 0 & j % 2 == 0) {
                    matriu[i][j] = '2';
                }
                else if(i % 2 != 0 & j % 2 != 0) {
                    matriu[i][j] = '-';
                }
                System.out.println("La posició " + i + " " + j + " de la matriu matriuParells val: " + matriu[i][j]);
            }
            System.out.println("La fila " + i + " de la matriu matriuParells ja està tota plena");
           System.out.println();
        }
    }
}
