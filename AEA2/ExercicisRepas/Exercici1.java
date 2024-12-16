package ExercicisRepas;
public class Exercici1 {
    
    public static void main(String[] args) {
        int [][] matriu = new int [5][5];

        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < matriu[i].length; j++) {
                matriu [i][j] = (int)(Math.random() * 100);
            }
        }
        System.out.println("Aquesta es la matriu de 5x5: ");
        for(int i = 0; i < matriu.length; i++) {
            for(int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
        int sumatotal = 0;
        int numeros = 0;
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                sumatotal += matriu[i][j];
                numeros++;
            }
        }
        double mitjana = sumatotal / numeros;
        System.out.println("\nAquesta es la mitjana de la matriu: " + mitjana);

        int numerogran = matriu[0][0];
        int vegades = 0;
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] > numerogran) {
                    numerogran = matriu[i][j];
                    vegades = 1;
                } 
                else if (matriu[i][j] == numerogran) {
                    vegades++;
                }
            }
        }
        System.out.println("\nAquest es el numero mes gran: " + numerogran + " i es repeteix " + vegades + " vegades.");

        System.out.println("\nAquests son els numeros parells de la matriu: ");
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] % 2 == 0) {
                    System.out.print(matriu[i][j] + " ");
                }
            }
        }
        int sumadiagonal1 = 0;
        int sumadiagonal2 = 0;
        for(int i = 0; i < matriu.length; i++) {
            sumadiagonal1 += matriu[i][i];
            sumadiagonal2 += matriu[i][4-i];
        }
        System.out.println("\n\nLa suma de la primera diagonal es: " + sumadiagonal1);
        System.out.println("\nLa suma de la segona diagonal es: " + sumadiagonal2);

        int ultimafila = 0;
        for (int j = 0; j < matriu[4].length; j++) {
            ultimafila += matriu[4][j];
        }
        System.out.println("\nAquesta es la suma de la ultima fila: " + ultimafila);
    }
}
