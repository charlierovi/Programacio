package AEA3.Herencia;

public class Persona {

    private static int id;
    private static int edat;
    private static String nom;
    private static String cognom;
    private static String adreça;


    public int getId() {
        return id;
    }

    public int getEdat() {
        return edat;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public void printInfo() {
        System.out.println("Persona" + '\n' + "Id: " + getId() + '\n' + "Edat: "
                + getEdat() + "Nom: " + getNom() + '\n' + "Cognom: " + getCognom() + '\n' + "Adreça: " + getAdreça() + '\n');
    }
}
