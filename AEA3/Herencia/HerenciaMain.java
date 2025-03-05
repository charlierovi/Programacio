package AEA3.Herencia;

import java.util.Scanner;

public class HerenciaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Persona persona = new Persona();

        System.out.println("Id de l'alumne:");
        persona.setId(scanner.nextInt());

        System.out.println("Nom de l'alumne:");
        persona.setNom(scanner.next());

        System.out.println("Cognom de l'alumne:");
        persona.setCognom(scanner.next());

        System.out.println("Edat de l'alumne:");
        persona.setEdat(scanner.nextInt());

        System.out.println("Adreça de l'alumne:");
        persona.setAdreça(scanner.next());

        Estudiant estudiant = new Estudiant();

        System.out.println("Curs de l'alumne:");
        estudiant.setCurs(scanner.next());

        System.out.println("Assignatures de l'alumne:");
        estudiant.setAssignatures(scanner.next());

        System.out.println("Escola de l'alumne:");
        estudiant.setEscola(scanner.next());

        System.out.println("Notes de l'alumne:");
        estudiant.setNotes(scanner.nextDouble());

        persona.printInfo();
        estudiant.printInfo();

    }
}