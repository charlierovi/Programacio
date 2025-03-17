package AEA3.Reserves;

public abstract class Allotjament {
    private String nom;
    private int capacitat;
    private boolean disponible;

    public Allotjament(String nom, int capacitat, boolean disponible) {
        this.nom = nom;
        this.capacitat = capacitat;
        this.disponible = disponible;
    }

    public abstract String getTipus();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double Calcular_Preu_Nit() {
        return 0;
    }

    public String Mostrar_Informacio() {
        return "Nom: " + nom + ", Capacitat: " + capacitat + ", Disponible: " + (disponible ? "Sí" : "No");
    }
}
