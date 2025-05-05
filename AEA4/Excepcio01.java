package AEA4;

public class Excepcio01 {
    public static void main(String[] args) {
        String t[] = {"Hola", "Adéu", "Fins demà"};

        try {
            for(int i=0; i<=t.length; i++){
                System.out.println("Posició " + i + ": " + t[i]);
            }
        } 
        catch (Exception e) {
            System.out.println("S'ha produït una excepció: " + e);
        }
        System.out.println("El programa s'ha acabat.");
    }
}
