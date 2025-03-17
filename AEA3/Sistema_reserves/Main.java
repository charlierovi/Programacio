package AEA3.Sistema_reserves;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Allotjament[] allotjaments = new Allotjament[5];
    public static void main(String[] args) {
        

        allotjaments[0] = new Habitacio("Habitació 101", 2, true, 3);
        allotjaments[1] = new Apartament("Apartament Blue", 4, true, 2, true);
        allotjaments[2] = new CasaRural("Masia Verda", 3, true, false, false);
        allotjaments[3] = new Habitacio("Habitació 202", 1, false, 1);
        allotjaments[4] = new CasaRural("Can Soler", 8, true, true, true);

        String opcio = "";

        while(!opcio.equals("4")) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar allotjaments disponibles");
            System.out.println("2. Reservar allotjament");
            System.out.println("3. Alliberar allotjament");
            System.out.println("4. Sortir");
            System.out.print("Tria una opció: ");
            opcio = sc.nextLine();

            if(opcio.equals("1")) {
                for (Allotjament a : allotjaments) {
                    if (a.isDisponible()) {
                            a.mostrarInformacio();
                    }
                }
            }
        }
    }
}

