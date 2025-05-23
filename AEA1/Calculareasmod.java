import java.util.*;

public class Calculareasmod {
    Scanner lector = new Scanner(System.in);
    
    public double AreaTriangle() {
        System.out.println("La formula del triangle es: Base x Altura / 2.");
		System.out.println("Introdueix l'altura en cm:");
		double Altura = lector.nextDouble();
		System.out.println("Introdueix la base en cm:");
		double Base = lector.nextDouble();
		double AreaTriangle = Altura*Base/2;
		System.out.println("L'area del triangle es: " + AreaTriangle + " cm^2.");
        return AreaTriangle;
    }

    public double AreaCercle(){
        System.out.println("La formula del cercle es: 3.14 X Radi elevat a 2");
	    System.out.println("Introdueix la mesura del radi en cm:");
	    double Radi = lector.nextDouble();
	    double AreaCercle = 3.14*Math.pow(Radi,2);
	    System.out.println("L'area del cercle es: " + AreaCercle + " cm^2.");
        return AreaCercle;
    }

    public double AreaTrapezi() {
        System.out.println("La formula del trapezi es: (Base major + Base menor) X Altura / 2.");
	    System.out.println("Introdueix la base major en cm:");
	    double BaseMajor = lector.nextDouble();
	    System.out.println("Introdueix la base menor en cm:");
	    double BaseMenor = lector.nextDouble();
	    System.out.println("Introdueix l'altura en cm:");
	    double Altura = lector.nextDouble();
	    double AreaTrapezi = (BaseMajor + BaseMenor)*Altura/2;
	    System.out.println("L'area del trapezi es " + AreaTrapezi + " cm^2.");
        return AreaTrapezi;
    }

    public double AreaRombe() {
        System.out.println("La formula del rombe es: Diagonal major X Diagonal menor / 2.");
	    System.out.println("Introdueix la diagonal major en cm: ");
	    double DiagonalMajor = lector.nextDouble();
	    System.out.println("Introdueix la diagonal menor en cm: ");
	    double DiagonalMenor = lector.nextDouble();
	    double AreaRombe = DiagonalMajor*DiagonalMenor/2;
	    System.out.println("L'area del rombe es " + AreaRombe + " cm^2.");
        return AreaRombe;
    }

    public double AreaParallelogram() {
        System.out.println("La formula del parallelogram es: Base X Altura");
	    System.out.println("Introdueix la base en cm:");
		double Base = lector.nextDouble();
    	System.out.println("Introdueix l'altura en cm:");
        double Altura = lector.nextDouble();
	    double AreaParallelogram = Base*Altura;
	    System.out.println("L'area del parallelogram es " + AreaParallelogram + " cm^2.");
        return AreaParallelogram;
    }
}

   