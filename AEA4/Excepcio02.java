package AEA4;

public class Excepcio02 {
    public static void main(String[] args) {
        String t[] = {"Hola", "Adéu", "Fins demà"};

        try {
            System.out.println("Abans d'executar el for");
            for(int i=0; i<=t.length; i++){
                System.out.println("Posició " + i + ": " + t[i]);
                System.out.println("Després d'executar el for");
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("El programador estava a la lluna... S'ha sortit de límits!!!");
        }
        finally {
            System.out.println("S'ha acabat el programa.");
        }
    }
}

