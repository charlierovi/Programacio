import java.util.Scanner;

public class Descompte {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println ("Quin és el preu del producte, en euros?");
		float preu = lector.nextFloat();
		

		if (preu >= 95) {
			float descompteFet = preu * 15/100;
			float preufi = (preu - descompteFet);
			System.out.println("El preu final per pagar és de " + preufi + " euros.");
		}
	}
}