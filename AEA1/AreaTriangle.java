import java.util.Scanner;

public class AreaTriangle {
	public static void main(String[] args) {
		Scanner Lector = new Scanner(System.in);
		System.out.println("Defineix l'alçada del triangle:");
		double Alçada=Lector.nextDouble();
		System.out.println("Defineix l'amplada del triangle: ");
		double Amplada=Lector.nextDouble();
		double Area=(Alçada*Amplada)/2;

		System.out.println("L'àrea del triangle és " + Area + "cm^2");
	}
}
