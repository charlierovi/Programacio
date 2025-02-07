package AEA3;

import AEA3.GENERAL.LectorDatosTerminal;
import java.util.Scanner;

public class ModCalculAreas_Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ModCalculareas areas = new ModCalculareas();
        LectorDatosTerminal lector = new LectorDatosTerminal();

        System.out.println("De quina figura vols calcular l'area?\n");
        System.out.println("Tens les següents opcions: triangle, quadrat, rectangle, trapezi, rombe, paralelogram o cercle.\n");

        String figura = s.nextLine();
        double area = 0;

        if (figura.equals("triangle")){ 
            double a = lector.leerDouble();
            double b = lector.leerDouble();
            area = areas.triangle(a, b);    
        }

        else if (figura.equals("quadrat")){
            double c = lector.leerDouble();
            area = areas.quadrat(c);
        }

        else if (figura.equals("rectangle")){
            double c1 = lector.leerDouble();
            double c2 = lector.leerDouble();
            area = areas.rectangle(c1, c2);
        }

        else if (figura.equals("trapezi")){
            double a = lector.leerDouble();
            double b = lector.leerDouble();
            double c = lector.leerDouble();
            area = areas.trapezi(a, b, c);
        }

        else if (figura.equals("paralelogram")){
            double b = lector.leerDouble();
            double h = lector.leerDouble();
            area = areas.paralelogram(b, h);
        }

        else if (figura.equals("cercle")){
            double r = lector.leerDouble();
            area = areas.cercle(r);
        }

        if(area == 0) {
            System.out.println("Figura incorrecta.");
        }
        else{ 
            System.out.println("L'area de " + figura + " és " + area + ".");
        }
    }
}
