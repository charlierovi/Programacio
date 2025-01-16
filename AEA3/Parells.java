package AEA3;

public class Parells {
    public static void main(String[] args) {
        int[] parells = new int[100];
        int[] senars = new int[100];
        int[] suma = new int[100];
        int j = suma.length - 1;

        for(int i = 0; i < parells.length; i++) {
            parells[i] = 2 * i;
            senars[i] = 2 * j + 1;
            suma[i] = parells[i] + senars[j];
            System.out.print(suma[i] + " ");
            j--;
        }
    }
}
