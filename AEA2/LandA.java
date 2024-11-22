import java.util.Scanner;

public class LandA {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        String[] cars = new String[4];
        
        System.out.println("Introdueix 4 marques: ");
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Marca " + (i+1) + ":");
            cars[i] = lector.nextLine();
        }
        System.out.println("Aquestes han sigut les teves 4 marques.");
    }   
}
