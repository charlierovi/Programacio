import java.util.Scanner;

public class Areas {
	public static void main(String[] args) {
		inici();
	}
	public static void inici(){
	Scanner lector = new Scanner(System.in);
		Calculareasmod calculador = new Calculareasmod();
		System.out.println("Tria entre les següents opcions: triangle, cercle, trapezi, rombe, parallelogram.");
		String figura = lector.nextLine();
		boolean pregunta = false;
		while (!pregunta){
			if ("triangle".equalsIgnoreCase(figura)) {
			calculador.AreaTriangle();
			pregunta = true;
	    	}
	    	else if ("cercle".equalsIgnoreCase(figura)) {
	    	calculador.AreaCercle();
			pregunta = true;
	    	}
	    	else if ("trapezi".equalsIgnoreCase(figura)) {
	    	calculador.AreaTrapezi();
			pregunta = true;
	    	}
	    	else if ("rombe".equalsIgnoreCase(figura)) {
	    	calculador.AreaRombe();
			pregunta = true;
	    	}
	    	else if ("parallelogram".equalsIgnoreCase(figura)) {
	    	calculador.AreaParallelogram();
			pregunta = true;
	    	}
	    	else {
	    	System.out.println("Has d'escollir una de les formes de l'enunciat.");
			inici();
			}
		}
	}
}