package AEA3.MastermindJuego;

import java.util.Random;

public class CodeGenerator {
    private static final int CODE_LENGHT = 3;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String generateCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for(int i=0; i<CODE_LENGHT; i++) {
            int index=random.nextInt(ALPHABET.length());
            code.append(ALPHABET.charAt(index));
        }
        return code.toString();
    }
}
