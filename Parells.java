public class Parells {
    public static void main(String[] args) {

        int[] parells = new int[100];

        for(int i = 0; i < 100; i++) {
            parells[i] = 2 * i;
        }
        System.out.println("Els primers 100 numeros parells son: ");
        for(int numero : parells) {
            System.out.print(numero + " ");
        }
    }
}



