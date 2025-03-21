package AEA3.Reserves;

public class Apartament extends Allotjament{
    private int habitacions;
    private boolean te_cuina;


    public Apartament(String nom, int capacitat, boolean disponible, int habitacions, boolean te_cuina) {
        super(nom, capacitat, disponible);
        this.habitacions = habitacions;
        this.te_cuina = te_cuina;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public boolean isTe_cuina() {
        return te_cuina;
    }

    public void setTe_cuina(boolean te_cuina) {
        this.te_cuina = te_cuina;
    }

    @Override
    public String getTipus() {
        return "Apartament";
    }

    @Override
    public double Calcular_Preu_Nit() {
        return 100 + (getHabitacions() * 10);
    }

    @Override
    public String Mostrar_Informacio() {
        super.Mostrar_Informacio();
        return "Nom: " + getNom() + ", Habitacions: " + getHabitacions() + ", Cuina: " + (te_cuina ? "Sí" : "No") + ", Preu per nit: " + Calcular_Preu_Nit() + " euros.";
    }
}
