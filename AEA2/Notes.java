public class Notes {
    public static void main(String[] args) {
        int notes[] = {3, 6, 2, 1, 8, 10, 6, 5};
        boolean trobat = false;
        int i = 0;

        while (i < notes.length && !trobat) {
            if (notes[i] == 10) {
                trobat = true;
            }
            i++;
        }
        if (trobat) {
            System.out.println("Algu ha tret un 10.");
        }
        else {
            System.out.println("Ningu no ha tret un 10.");
        }
    }
}
