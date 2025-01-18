package AEA3.Examen;
//EJ2. Escribe un programa en Java que permita al usuario ingresar un valor. El programa deberá buscar ese valor en un vector de números enteros. Si el valor se encuentra en el vector, el programa deberá indicar la posición y terminar. Si el valor no se encuentra, mostrar un mensaje indicando que no se encontró.
import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Indica quin element vols trobar:");
        int element = lector.nextInt();

        int[] vector = {3,5,6,7};
        
        boolean trobat = false;

        for(int i = 0; i < vector.length; i++) {
            if(vector[i] == element) {
                System.out.println("El valor es troba a la posició " + i + " del vector.");
                trobat = true;
                break;
            }
        
        }
        if(!trobat) {
            System.out.println("El teu valor no es troba dins del vector.");
        }
    }
}
