package AEA3.MastermindJuego;

import java.util.Random;

public class Robot extends Player {
    private final int codeLength;
    private final Random random;
    private final String[] paraulesPossibles;

    public Robot(int codeLength, String[] paraulesPossibles) {
        this.codeLength = codeLength;
        this.random = new Random();
        this.paraulesPossibles = paraulesPossibles;
    }

    @Override
    public String makeGuess() {
        String intent = paraulesPossibles[random.nextInt(paraulesPossibles.length)];
        System.out.println("El robot intenta: " + intent);
        return intent;
    }
}

