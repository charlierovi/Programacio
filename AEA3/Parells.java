package AEA3;

public class Parells {
    public static void main(String[] args) {
        int[] parells = new int[100];
        System.out.println("Els 100 primers numeros parells son:");
        for(int i = 0; i < parells.length; i++) {
            parells[i] = 2 * i;
            System.out.print(parells[i] + " ");
        }
        System.out.println();
        int[] senars = new int[100];
        System.out.println("Els 100 primers numeros senars son:");
        for(int i = 1; i < senars.length; i++) {
            senars[i] = 2 * i - 1;
            System.out.print(senars[i] + " ");
        }
    }
}
