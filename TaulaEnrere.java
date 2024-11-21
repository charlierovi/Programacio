import java.util.Scanner;

public class TaulaEnrere {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Quina taula de multiplicar vols?");
		int numero = lector.nextInt();
		int i = 10;

		while (i >= 1) {
			int resultat = numero * i;
			System.out.println(numero + "X" + i + "=" + resultat);
			i --;		
		}
		System.out.println("Aquesta ha estat la taula del " + numero + ".");
	}
}