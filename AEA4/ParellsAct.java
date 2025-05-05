package AEA4;

public class ParellsAct {
    public static void main(String[] args) {
        try{
            int[] parells = new int[100];

            for(int i = 0; i < 100; i++) {
                parells[i] = 2 * i;
            }
            System.out.println("Els primers 100 numeros parells son: ");
            for(int numero : parells) {
                System.out.print(numero + " ");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: has intentat accediar a una posicio que no existeix a l'array.");
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
 