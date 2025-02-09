package AEA3;

import AEA3.GENERAL.CalculArrayReals;
import AEA3.GENERAL.LectorDatosTerminal;

public class Maxminmit {
    public static void main(String[] args) {
        LectorDatosTerminal lectordades = new LectorDatosTerminal();
        CalculArrayReals maxminmit = new CalculArrayReals();  

        double[] notes = new double[5];
        
        System.out.println("Introdueix les 5 notes.");
    
        for(int i = 0; i < notes.length; i++) {
        System.out.println("Nota numero " + (i + 1) + ":");
        notes[i] = lectordades.leerDouble();
        }

        double max = maxminmit.calcularMaxim(notes);
        double min = maxminmit.calcularMinim(notes);
        double mitj = maxminmit.calcularMitjana(notes);

        System.out.println("La nota més gran és: " + max + ", la nota més petita és: " + min + " i la mitajana és: " + mitj);
    }
}