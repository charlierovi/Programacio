public class TriangleNumsR {
	public static void main(String[] args) {
		
		System.out.println("Fes la forma del triangle rectangle amb numeros repetint cada linea el mateix numero.");
		
		for (int i = 1; i <= 9; i++) {
			System.out.print(i);
			for (int j = 1; j < i; j++) {
				System.out.print(i);
			}
		System.out.println();
		}
	}
}