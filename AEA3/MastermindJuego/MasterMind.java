package AEA3.MastermindJuego;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
    private final CodeGenerator codeGenerator;
    private final Feedback feedback;
    private final Scanner scanner;
    private int codeLength;
    private boolean isChild;

    public MasterMind() {
        this.codeGenerator = new CodeGenerator();
        this.feedback = new Feedback();
        this.scanner = new Scanner(System.in);
    }

    public void inici() {
        determinarEdatJugador();
        this.codeLength = isChild ? 3 : 5;

        String[] paraulesRobot = isChild ? CodeGenerator.PARAULES_NENS : CodeGenerator.PARAULES_ADULTS;
        
        Player humanPlayer = new HumanPlayer(codeLength);
        Player robot = new Robot(codeLength, paraulesRobot); 
        
        jugarPartida(humanPlayer, robot);
    }

    private void determinarEdatJugador() {
        System.out.println("Ets un nen o un adult?");
        System.out.println("1. Nen - Paraules de 3 lletres");
        System.out.println("2. Adult - Paraules de 5 lletres");
        
        int opcio = 0;
        while(opcio != 1 && opcio != 2) {
            System.out.print("Selecciona 1 o 2: ");
            try {
                opcio = Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) {
                System.out.println("Si us plau, indica 1 o 2.");
            }
        }
        
        this.isChild = (opcio == 1);
    }

    private void jugarPartida(Player humanPlayer, Player robot) {
        String secretCode = codeGenerator.generateCode(isChild);
        System.out.println("\nComença el joc! Endevina la paraula de " + codeLength + " lletres.");
        System.out.println("Possibles paraules: " + 
                      (isChild ? Arrays.toString(CodeGenerator.PARAULES_NENS) 
                              : Arrays.toString(CodeGenerator.PARAULES_ADULTS)));
        
        int intents = 0;
        boolean jocAcabat = false;
        
        while (!jocAcabat) {
            intents++;
            
            // Turno del jugador humano
            System.out.println("\nTorn " + intents + " - Jugador: ");
            String intentHuma = humanPlayer.makeGuess();
            
            if (intentHuma.equalsIgnoreCase(secretCode)) {
                System.out.println("\nFelicitats! Has endevinat la paraula en " + intents + " intents!");
                System.out.println("La paraula era: " + secretCode);
                jocAcabat = true;
                continue;
            }
            
            String feedbackHuma = feedback.getFeedback(secretCode, intentHuma);
            System.out.println("Pista: " + feedbackHuma);
            
            // Turno del robot
            System.out.println("\nTorn " + intents + " - Robot:");
            String intentRobot = robot.makeGuess();
            
            if (intentRobot.equalsIgnoreCase(secretCode)) {
                System.out.println("\nEl robot ha guanyat! GAME OVER!");
                System.out.println("La paraula era: " + secretCode);
                jocAcabat = true;
                continue;
            }
            
            String feedbackRobot = feedback.getFeedback(secretCode, intentRobot);
            System.out.println("Pista: " + feedbackRobot);
        }
    }

    public static void main(String[] args) {
        MasterMind juego = new MasterMind();
        juego.inici();
    }
}