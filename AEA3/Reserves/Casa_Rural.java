package AEA3.Reserves;

public class Casa_Rural extends Allotjament{
    private boolean te_Jardi;
    private boolean te_Piscina;


    public Casa_Rural(String nom, int capacitat, boolean disponible, boolean te_Jardi, boolean te_Piscina) {
        super(nom, capacitat, disponible);
        this.te_Jardi = te_Jardi;
        this.te_Piscina = te_Piscina;
    }

    public boolean isTe_Jardi() {
        return te_Jardi;
    }

    public void setTe_Jardi(boolean te_Jardi) {
        this.te_Jardi = te_Jardi;
    }

    public boolean isTe_Piscina() {
        return te_Piscina;
    }

    public void setTe_Piscina(boolean te_Piscina) {
        this.te_Piscina = te_Piscina;
    }

    @Override
    public String getTipus() {
        return "Casa Rural";
    }

    @Override
    public double Calcular_Preu_Nit() {
        super.Calcular_Preu_Nit();
        if (te_Piscina) {       //Si té piscina
            return 150 + 50;
        }
        return 150;     //Si no té piscina
    }

    @Override
    public String Mostrar_Informacio() {
        super.Mostrar_Informacio();
        return "Nom: " + getNom() + ", Jardí: " + (te_Jardi ? "Sí" : "No") + ", Piscina: " + (te_Piscina ? "Sí" : "No") + ", Preu per nit: " + Calcular_Preu_Nit() + " euros.";
    }
}
