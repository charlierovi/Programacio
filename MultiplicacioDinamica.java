import java.util.Scanner;

public class MultiplicacioDinamica {
	public static void main(String[] args) {
		Scanner Lector = new Scanner(System.in);
		System.out.println("Quin serà el resultat de la multiplicació?");

		System.out.println("Escriu el 1r nombre");
		double PrimerReal= Lector.nextDouble();
		System.out.println("Escriu el 2n nombre");
		double SegonReal= Lector.nextDouble();
		System.out.println("Escriu el 3r nombre");
		double TercerReal= Lector.nextDouble();
		double Resultat=PrimerReal*SegonReal*TercerReal;

		System.out.println("La resposta correcta és " + Resultat + ".");
	}
}
