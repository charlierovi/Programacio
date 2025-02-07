package AEA3;
import java.util.Scanner;

public class CalculAreas {
    public static void main (String[] args){

        Scanner s = new Scanner(System.in);

        System.out.println("De quina figura vols calcular l'area?\n");
        System.out.println("Tens les següents opcions: triangle, quadrat, rectangle, trapezi, rombe, paralelogram o cercle.\n");

        String figura = s.nextLine();
        double area = 0;
        boolean noexisteix = false; 
       

        if (figura.equals("triangle")){ 
            double b = 23.0;
            double h = 8.0;
            area = (b*h)/2;
        }

        else if (figura.equals("quadrat")){
            double costat = 37.0;
            area = Math.pow(costat, 2);
        }

        else if (figura.equals("rectangle")){

            double a = 68.0;
            double b = 39.0;
            area = a*b;
        }

        else if (figura.equals("trapezi")){
            double a = 35.0;
            double b = 16.0;
            double h = 5.0;
            area = ((a*b)*h)/2;
        }

        else if (figura.equals("rombe")){
            double dM = 75.0;
            double dm = 30.0;
            area = (dM*dm)/2;
        }

        else if (figura.equals("paralelogram")){
            double b = 45.0;
            double h = 13.0;
            area = b*h;
        }

        else if (figura.equals("cercle")){
            System.out.println("Quin es el radi del cercle?");
            double r = s.nextDouble();
            area = Math.pow(r, 2)*Math.PI; 
        }
        else{ 
            noexisteix = true;
        }

        if (noexisteix){ 
            System.out.println("No és cap figura de les que toquen");
        }
        else{ 
            System.out.println("L'area del " + figura + " es " + area);
        }
    }
}
