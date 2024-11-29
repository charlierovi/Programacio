import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        float descompte = 6;
        float compramin = 50;
        float descomptemax = 15;
        float descomptefet = 0;
        float totalpreu = 0;
        int i = 0;
        
        System.out.println("Benvolgut a la calculadora de preus. Has d'introduir 5 preus per saber si tenen descompte.");
        
        while(i < 5) {
            System.out.println("Introdueix el preu " + (i+1) +":");
            float preu = lector.nextFloat();
            
            if(preu>0) {
                if(preu>compramin) {
                descomptefet = preu * descompte / 100;
            
                if(descomptefet>descomptemax) {
                    descomptefet = descomptemax;
                }
                preu = preu - descomptefet;
                }
                System.out.println("El preu del teu producte és: " + preu + " euros.");
                totalpreu += preu;
            }
            else {
                System.out.println("Torna a introduir un preu vàlid.");
                i--;
            }
        i++;
        }
        System.out.println("La suma dels teus productes és: " + totalpreu + " euros.");
    }
}
            

