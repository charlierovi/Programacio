import java.util.Scanner;

public class Prova1 {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Fins a quina taula de multiplicar vols saber?");
		int numero = lector.nextInt();

		for (int i = 1; i<=numero; i++) {
			System.out.println("La taula del " + i + ":");
			for (int j = 1; j<=10; j++) {
			System.out.println(i + "X" + j + "=" + (i*j));
			}
		}
	}
}