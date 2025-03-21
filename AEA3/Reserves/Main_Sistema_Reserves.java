package AEA3.Reserves;

public class Main_Sistema_Reserves {
    public static void main(String[] args) {
        LectorDatosTerminal lector = new LectorDatosTerminal();

        // Demanar a l'usuari la quantitat d'allotjaments a afegir
        System.out.println("Quants allotjaments vols afegir?");
        int numAllotjaments = lector.leerInt();
        Allotjament[] allotjaments = new Allotjament[numAllotjaments];

        int index = 0;  //Controla quants allotjaments hem afegit correctament

        //Bucle per registrar els allotjaments afegits
        for (int i = 0; i < numAllotjaments; i++) {
            System.out.println("Selecciona el tipus d'allotjament: ");
            System.out.println("1. Habitació");
            System.out.println("2. Apartament");
            System.out.println("3. Casa Rural");
            int tipus = lector.leerInt();

            System.out.println("Nom de l'allotjament:");
            String nom = lector.leerString();
            System.out.println("Capacitat de l'allotjament:");
            int capacitat = lector.leerInt();
            boolean disponible = true; // Obviament, tots comencen entant disponibles

            //Switch pel tipus de Allotjament afegit
            switch (tipus) {
                case 1:  // Habitació
                    System.out.println("Número de llits:");
                    int llits = lector.leerInt();
                    allotjaments[index++] = new Habitacio(nom, capacitat, disponible, llits);       //Afegeix l'habitació amb les dades
                    break;

                case 2:  // Apartament
                    System.out.println("Número d'habitacions:");
                    int habitacions = lector.leerInt();
                    System.out.println("Té cuina? (si/no)");
                    String respostaCuina = lector.leerString().trim().toLowerCase();
                    boolean teCuina = respostaCuina.equals("si");
                    allotjaments[index++] = new Apartament(nom, capacitat, disponible, habitacions, teCuina);       //Afegeix l'apartament amb les dades en una posició més
                    break;

                case 3:  // Casa Rural
                    System.out.println("Té jardí? (si/no)");
                    String respostaJardi = lector.leerString().trim().toLowerCase();
                    boolean teJardi = respostaJardi.equals("si");
                    System.out.println("Té piscina? (si/no)");
                    String respostaPiscina = lector.leerString().trim().toLowerCase();
                    boolean tePiscina = respostaPiscina.equals("si");
                    allotjaments[index++] = new Casa_Rural(nom, capacitat, disponible, teJardi, tePiscina);     //Afegeix la casa rural amb les dades en una posició més
                    break;

                default:
                    System.out.println("ERROR, torna a intentar-ho.");
                    i--;  // Retrocedim la casella que ha quedat buida per l'error
                    break;
            }
        }

        // Menú per gestionar reserves
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("\nBenvingut al menú!");
            System.out.println("1. Mostrar Allotjaments Disponibles");
            System.out.println("2. Reservar Allotjament");
            System.out.println("3. Alliberar Allotjament");
            System.out.println("4. Cerca Personalitzada");
            System.out.println("5. Sortir");

            int resposta = lector.leerInt();

            switch (resposta) {
                case 1: //Mostrar Allotjaments Disponibles
                    System.out.println("Aquí té els allotjaments disponibles:");
                    boolean mostrar = false;

                    for (int i = 0; i < index; i++) {
                        if (allotjaments[i].isDisponible()) {       // Recorrem les posicións amb allotjaments disponibles
                            System.out.println(allotjaments[i].Mostrar_Informacio());
                            mostrar = true;
                        }
                    }
                    if(!mostrar) {
                        System.out.println("Ho sentim, no hi ha allotjaments disponibles.");
                    }
                    break;

                case 2:     //Reservar Allotjament
                    System.out.println("Quin allotjament vol reservar?:");
                    String nomReserva = lector.leerString();
                    boolean reservat = false;

                    for (int i = 0; i < index; i++) {
                        if (allotjaments[i].getNom().equalsIgnoreCase(nomReserva) && allotjaments[i].isDisponible()) {      // Recorrem les posicións amb allotjaments disponibles
                            System.out.println("Quantes nits vols reservar?");
                            int numNits = lector.leerInt();

                            double preuTotal = allotjaments[i].Calcular_Preu_Nit() * numNits;
                            System.out.println("Preu total per " + numNits + " nits: " + preuTotal + " euros.");
                            
                            allotjaments[i].setDisponible(false);
                            System.out.println("Allotjament reservat amb èxit!");
                            reservat = true;
                            break;
                        }
                    }
                    if (!reservat) {
                        System.out.println("No s'ha pogut reservar, pot ser que ja estigui ocupat.");
                    }
                    break;

                case 3:     //Alliberar Allotjament
                    System.out.println("Quin Allotjament vol alliberar?:");
                    String nomAlliberar = lector.leerString();
                    boolean alliberat = false;
                    for (int i = 0; i < index; i++) {
                        if (allotjaments[i].getNom().equalsIgnoreCase(nomAlliberar) && !allotjaments[i].isDisponible()) {       // Recorrem les posicións amb allotjaments NO disponibles
                            allotjaments[i].setDisponible(true);
                            System.out.println("Allotjament alliberat amb èxit!");
                            alliberat = true;
                            break;
                        }
                    }
                    if (!alliberat) {
                        System.out.println("No s'ha trobat la reserva per alliberar.");
                    }
                    break;

                case 4:
                    System.out.println("Opcions de cerca personalitzada:");
                    System.out.println("1. Tipus d'allotjament");
                    System.out.println("2. Capacitat mínima");
                    System.out.println("3. Característiques especials");
                    int opcioCerca = lector.leerInt();

                    switch (opcioCerca) {
                        case 1:
                            System.out.println("Selecciona el tipus:");
                            System.out.println("1. Habitació");
                            System.out.println("2. Apartament");
                            System.out.println("3. Casa Rural");
                            int tipusCerca = lector.leerInt();

                            String tipusSeleccionat = "";
                            if (tipusCerca == 1) {
                                tipusSeleccionat = "Habitació"; 
                            }
                            else if (tipusCerca == 2) {
                                tipusSeleccionat = "Apartament";
                            }
                            else if (tipusCerca == 3) {
                                tipusSeleccionat = "Casa Rural";
                            }

                            for (int i = 0; i < index; i++) {
                                if (allotjaments[i].getTipus().equals(tipusSeleccionat)) {
                                    System.out.println(allotjaments[i].Mostrar_Informacio());
                                }
                                else {
                                    System.out.println("No hi ha resultats. Tornant al menú...");
                                }
                            }
                            break;

                        case 2: 
                            System.out.println("Indica la capacitat mínima:");
                            int capacitatMin = lector.leerInt();
                            boolean trobat = false;
                
                            for (int i = 0; i < index; i++) {
                                if (allotjaments[i].getCapacitat() >= capacitatMin && allotjaments[i].isDisponible() ) {
                                    System.out.println(allotjaments[i].Mostrar_Informacio());
                                    trobat = true;
                                }
                            }
                            if (!trobat) {
                                System.out.println("No hi ha resultats per a la teva cerca. Ho sentim.");
                            }
                            break; 

                        case 3: 
                            System.out.println("Selecciona la característica:");
                            System.out.println("1. Té cuina");
                            System.out.println("2. Té jardí");
                            System.out.println("3. Té piscina");
                            int caracteristica = lector.leerInt();

                            for (int i = 0; i < index; i++) {
                                if (caracteristica == 1 && allotjaments[i].getTipus().equals("Apartament")) {
                                    if (((Apartament) allotjaments[i]).isTe_cuina()) {
                                        System.out.println(allotjaments[i].Mostrar_Informacio());
                                    }
                                } 
                                else if (allotjaments[i].getTipus().equals("Casa Rural")) {
                                    Casa_Rural casa = (Casa_Rural) allotjaments[i];
                                    if ((caracteristica == 2 && casa.isTe_Jardi()) ||
                                        (caracteristica == 3 && casa.isTe_Piscina())) {
                                        System.out.println(casa.Mostrar_Informacio());
                                    }
                                }
                            }
                            break;

                        default:
                            System.out.println("Opció no vàlida.");
                    }
                    break;

                case 5:     //Sortir
                    System.out.println("Sortint del programa...");
                    mostrar_menu = false;
                    break;

                default:
                    System.out.println("Opció no vàlida, si us plau tria una altra.");
            }
        }
    }
}
