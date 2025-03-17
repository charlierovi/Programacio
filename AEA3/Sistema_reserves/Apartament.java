package AEA3.Sistema_reserves;

public class Apartament extends Allotjament {
    private int habitacions;
    private boolean teCuina;

    public Apartament() {

    }

    public Apartament(String nom, int capacitat, boolean disponible, int habitacions, boolean teCuina) {
        super(nom, capacitat, disponible);
        this.habitacions = habitacions;
        this.teCuina = teCuina;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public boolean isTeCuina() {
        return teCuina;
    }

    public void setTeCuina(boolean teCuina) {
        this.teCuina = teCuina;
    }

    @Override
    public double calcularPreuPerNit() {
        double preubase = habitacions * 20;
        if(teCuina) {
            preubase += 30;
        }
        return preubase;
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio(); 
        System.out.println(", Número d'habitacions: " + habitacions + ", Té cuina: " + (teCuina ? "Sí" : "No") + ", Preu per nit: " + calcularPreuPerNit() + " euros." );
    }
}
