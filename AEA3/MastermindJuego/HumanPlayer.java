package AEA3.MastermindJuego;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;
    private final int codeLength;

    public HumanPlayer(int codeLength) {
        this.scanner = new Scanner(System.in);
        this.codeLength = codeLength;
    }

    @Override
    public String makeGuess() {
        String input;
        while (true) {
            System.out.print("Introdueix el teu intent (" + codeLength + " lletres): ");
            input = scanner.next().toLowerCase().trim();
            
            if (input.length() != codeLength) {
                System.out.println("ERROR: Has d'introduir exactament " + codeLength + " lletres");
                continue;
            }
            
            if (!input.matches("[a-z]+")) {
                System.out.println("ERROR: Només es permeten lletres minúscules (a-z)");
                continue;
            }
            
            return input;
        }
    }
}