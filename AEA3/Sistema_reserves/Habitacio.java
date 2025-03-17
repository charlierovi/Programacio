package AEA3.Sistema_reserves;

public class Habitacio extends Allotjament {
    private int numLlits;

    public Habitacio() {

    }

    public Habitacio(String nom, int capacitat, boolean disponible, int numLlits) {
        super(nom, capacitat, disponible);
        this.numLlits = numLlits;
    }

    public int getNumLlits() {
        return numLlits;
    }

    public void setNumLlits(int numLlits) {
        this.numLlits = numLlits;
    }

    @Override
    public double calcularPreuPerNit() {
        return numLlits * 20;
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio(); 
        System.out.println(", Número de llits: " + numLlits + ", Preu per nit: " + calcularPreuPerNit() + " euros.");
    }
}
