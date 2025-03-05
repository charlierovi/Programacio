package AEA3.Herencia;

public class Estudiant extends Persona {

    private static String curs;
    private static String assignatures;
    private static String escola;
    private static double notes;
    

    public String getCurs() {
        return curs;
    }

    public String getAssignatures() {
        return assignatures;
    }

    public String getEscola() {
        return escola;
    }

    public double getNotes() {
        return notes;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public void setAssignatures(String assignatures) {
        this.assignatures = assignatures;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public void setNotes(double notes) {
        this.notes = notes;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Estudiant " + '\n' + "Curs: " + getCurs() + '\n'
                + "Assignatures: " + getAssignatures() + '\n' + "Escola: "
                + getEscola() + '\n' + "Notes: " + getNotes());
    }
}
