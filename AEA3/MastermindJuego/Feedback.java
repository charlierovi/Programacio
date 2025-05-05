package AEA3.MastermindJuego;

public class Feedback {
    private static final char TOT_CORRECTE = '0';
    private static final char MALA_POSICIO = 'X';
    private static final char INCORRECTE = '-';

    public String getFeedback(String secret, String guess) {
        if (secret == null || guess == null) {
            throw new IllegalArgumentException("Les paraules no poden ser nul·les");
        }
        if (secret.length() != guess.length()) {
            throw new IllegalArgumentException("Error: La paraula secreta té " + secret.length() + 
                                           " lletres i la teva entrada en té " + guess.length());
        }

        StringBuilder feedback = new StringBuilder();
        
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                feedback.append(TOT_CORRECTE);
            } else {
                feedback.append(' '); 
            }
        }
        
        for (int i = 0; i < secret.length(); i++) {
            if (feedback.charAt(i) == TOT_CORRECTE) continue;
            
            char currentChar = guess.charAt(i);
            if (secret.contains(String.valueOf(currentChar))) {
                feedback.setCharAt(i, MALA_POSICIO);
            } else {
                feedback.setCharAt(i, INCORRECTE);
            }
        }
        
        return feedback.toString();
    }
}