import java.util.Scanner;

public class DiesDelMes {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println ("Quin numero del mes vols analitzar [1 al 12].");
		int mes = lector.nextInt();
		lector.nextLine();
		

		switch (mes) {
		case 1,3,5,7,8,10,12: System.out.println("El teu mes te 31 dies.");
			break;
		case 4,6,9,11: System.out.println("El teu mes te 30 dies.");
			break;
		case 2: System.out.println("El teu mes pot tenir 28 o 29 dies.");
			break;
		default: System.out.println("Has introduit un numero de mes incorrecte.");
			break;
		}
	}
}