package AEA3.Examen;
//EJ 1. Escribe un programa en Java que realice la suma de dos vectores de la misma longitud y almacene el resultado en un tercer vector.
public class Ex1 {
    public static void main(String[] args) {
        int[] array = {2,6,5};
        int[] array2 = {3,8,7};
        int[] arraysuma = new int[3];
        
        arraysuma[0] = array[0] + array2[0];
        arraysuma[1] = array[1] + array2[1];
        arraysuma[2] = array[2] + array2[2];
        
        System.out.println("La suma dels dos arrays és: " + arraysuma[0] + " " + arraysuma[1] + " " + arraysuma[2]);
    }
}
