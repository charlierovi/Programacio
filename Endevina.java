import java.util.Scanner;

public class Endevina {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Comencem el joc!");
		System.out.println("Endevina un valor enter entre el 0 i el 10.");
		
		int num_correcto = 7;
		int i = 3;

		while (i > 0) {
			System.out.println("Introdueix el numero: ");
			int numero = lector.nextInt();
			if (numero == num_correcto) {	
				System.out.println("Felicitats! Has guanyat! El teu numero era el " + num_correcto);
				break;
			}
			else if (numero < num_correcto) {
				System.out.println("Has fallat!");	
			}
			else {
				System.out.println("Has fallat!");
			}
			i--;
		}
		if (i <= 0) {
			System.out.println("GAME OVER");
		}
	}
}




	






