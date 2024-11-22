import java.util.Scanner;

public class DescompteControlErrors {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Quin és el preu del producte en euros?");
		float preu = lector.nextFloat();


		if 	(preu >= 100) {
			float descompte = preu * 8/100;
			if (descompte > 10) {
			descompte = 10;
			}
			preu = (preu - descompte);
			System.out.println("El preu final per pagar és de " + preu + " euros.");
		}
		else if (preu < 0) {
			System.out.println("El preu no pot ser negatiu.");
		}
		else {
			System.out.println("El preu ha de ser igual o superior a 100 euros per aplicar el descompte.");
		}
	}
}