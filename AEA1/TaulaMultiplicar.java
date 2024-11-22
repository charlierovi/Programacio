import java.util.Scanner;

public class TaulaMultiplicar {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Quina taula de multiplicar vols?");
		int numero = lector.nextInt();
		
		for (int i=1; i<=10; i++) {
		int resultat=numero*i;
		System.out.println(numero + "X" + i + "=" + resultat);
		}
	
		System.out.println("Aquesta ha estat la taula del " + numero + ".");
	}
}

