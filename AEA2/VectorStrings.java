import java.util.Scanner;

public class VectorStrings {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        String[] paraules = new String[5];
        
        System.out.println("Introdueix 5 paraules: ");
        
        for (int i = 0; i < paraules.length; i++) {
            System.out.println("Paraula " + (i+1) + ":");
            paraules[i] = lector.nextLine();
        }
        
        System.out.println("Aquestes son les teves 5 paraules.");
    }
}
