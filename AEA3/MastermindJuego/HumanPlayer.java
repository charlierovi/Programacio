package AEA3.MastermindJuego;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String makeGuess() {
        System.out.print("Introdueix la teva resposta: ");
        return scanner.next();
    }
}
