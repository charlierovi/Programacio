package AEA3;

public class Estrelles {
    public static void Estrella(int a) {
        for(int i = 0; i < a; i++) {
            System.out.print("*");
        }
    }

    public static void Guio(int b) {
        for(int i = 0; i < b; i++) {
            System.out.print("-");
        }
    }
    
    public static void Numero(int c, int d) {
        for(int i = 0; i < d; i++) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        Estrella(8);
        System.out.println("");
        Guio(1);
        System.out.println("");
        Numero(5,6);
        System.out.println("");
        Estrella(3);
        System.out.println("");
        Guio(4);
        System.out.println("");
        Numero(3, 2);
        System.out.println("");
    }
}

