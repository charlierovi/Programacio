
import java.util.Scanner;

public class LectorDatosTerminal {
    private Scanner s = new Scanner(System.in);

    public double leerDouble() {
        
        boolean noleido = true;
        while(noleido) {
            if (s.hasNextDouble()) {
                noleido = false;
                return s.nextDouble();
            }
            else {
                s.next();
            }
        }
        return 0;
    }

    public int leerInt() {
        Scanner s = new Scanner(System.in);

        boolean noleido = true;
        while(noleido) {
            if(s.hasNextInt()) {
                noleido = false;
                return s.nextInt();
            }
            else {
                s.next();
            }
        }
        return 0;
    }

    public float leerFloat() {

        boolean noleido = true;
        while(noleido) {
            if(s.hasNextFloat()) {
                noleido = false;
                return s.nextFloat();
            }
            else {
                s.next();
            }
        }
        return 0;
    }

    public String leerLineString() {

        boolean noleido = true;
        while(noleido) {
            if(s.hasNextLine()) {
                noleido = false;
                return s.nextLine();
            }
            else {
                s.next();
            }
        }
        return "";
    }
}


