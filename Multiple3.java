import java.util.Scanner;

public class Multiple3 {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Fins a quin valor vols sumar multiples de 3?");
		int numero = lector.nextInt();
		int i = 0;
		int resultat = 0;
	
		while (numero >= i) {
			if (i % 3 == 0) {
				System.out.println("Afegim " + i + " ...");
				resultat = resultat + i;
			}
			++i;
		}
		System.out.println("La teva suma es: " + resultat);
		
	}
}