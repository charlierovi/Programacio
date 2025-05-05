package AEA3.MastermindJuego;

import java.util.Random;

public class CodeGenerator {
    public static final String[] PARAULES_NENS = {
        "sol", "mar", "peu", "ull", "nen", "riu", "gos", "nou", "llum", "viu"
    };
    
    public static final String[] PARAULES_ADULTS = {
        "arbre", "flors", "taula", "llibre", "corda", "porta", "mirar", "tecla", "tocar", "cotxe"
    };
    
    private final Random random = new Random();

    public String generateCode(boolean isChild) {
        if (isChild) {
            return PARAULES_NENS[random.nextInt(PARAULES_NENS.length)];
        } else {
            return PARAULES_ADULTS[random.nextInt(PARAULES_ADULTS.length)];
        }
    }
}