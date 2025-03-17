package AEA3.Sistema_reserves;

public class CasaRural extends Allotjament{
    private boolean teJardi;
    private boolean tePiscina;

    public CasaRural() {

    }

    public CasaRural(String nom, int capacitat, boolean disponible, boolean teJardi, boolean tePiscina) {
        super(nom, capacitat, disponible);
        this.teJardi = teJardi;
        this.tePiscina = tePiscina;
    }

    public boolean isTeJardi() {
        return teJardi;
    }

    public void setTeJardi(boolean teJardi) {
        this.teJardi = teJardi;
    }

    public boolean isTePiscina() {
        return tePiscina;
    }

    public void setTePiscina(boolean tePiscina) {
        this.tePiscina = tePiscina;
    }

    @Override
    public double calcularPreuPerNit() {
        double preubase = 100;
        if(teJardi) {
            preubase += 20;
        } 
        if(tePiscina) {
            preubase += 50;
        }
        return preubase;
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio(); 
        System.out.println(", Té jardí: " + (teJardi ? "Sí" : "No") + ", Té piscina: " + (tePiscina ? "Sí" : "No") + ", Preu per nit: " + calcularPreuPerNit() + " euros.");
    }
}



/*else if(opcio.equals("2")) {
                System.out.print("Introdueix el nom de l'allotjament a reservar: ");
                String nom = sc.nextLine();
                boolean trobat = false;
                for (Allotjament a : allotjaments) {
                    if (a.getNom().equalsIgnoreCase(nom)) {
                        trobat = true;
                        if (a.reservar()) {
                            System.out.println("Reservat correctament.");
                        } 
                        else {
                            System.out.println("Ja està reservat.");
                        }
                    }
                }
            }
                 /*    
                case "2":
                    System.out.print("Introdueix el nom de l'allotjament a reservar: ");
                    String nom = sc.nextLine();
                    for (Allotjament a : allotjaments) {
                        if (a.getNom().equalsIgnoreCase(nom)) {
                            if (a.reservar()) {
                                System.out.println("Reservat correctament.");
                            } 
                            else {
                                System.out.println("Ja està reservat.");
                            }
                        }
                    }
                    break;
                    
                case "3":
                    System.out.print("Introdueix el nom de l'allotjament a alliberar: ");
                    nom = sc.nextLine();
                    for (Allotjament a : allotjaments) {
                        if (a.getNom().equalsIgnoreCase(nom)) {
                            a.alliberar();
                            System.out.println("Alliberat correctament.");
                        }
                    }
                    break;*/