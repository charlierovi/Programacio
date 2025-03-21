package AEA3.Reserves;

public class Habitacio extends Allotjament {
    private int num_llits;


    public Habitacio(String nom, int capacitat, boolean disponible, int num_llits) {
        super(nom, capacitat, disponible);
        this.num_llits = num_llits;
    }

    public int getNum_llits() {
        return num_llits;
    }

    public void setNum_llits(int num_llits) {
        this.num_llits = num_llits;
    }

    @Override
    public String getTipus() {
        return "Habitacio";
    }

    @Override
    public double Calcular_Preu_Nit() {
        if (getNum_llits() > 2) {       //Si té més de 2 llits
            return 50 + (getNum_llits() * 20);
        }
        return 50;      //Si té 2 o menys llits
    }

    @Override
    public String Mostrar_Informacio() {
        super.Mostrar_Informacio();
        return "Nom: " + getNom() + ", Llits: " + getNum_llits() + ", Preu per nit: " + Calcular_Preu_Nit() + " euros.";
    }
}
