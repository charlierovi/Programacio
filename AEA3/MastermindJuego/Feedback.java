package AEA3.MastermindJuego;

public class Feedback {
    private static final char TOT_CORRECTE='0';
    private static final char MALA_POSICIO='X';
    private static final char INCORRECTE='-';

    public String getFeedback(String secret, String guess) {
        StringBuilder feedback=new StringBuilder();

        for(int i=0; i<secret.length(); i++) {
            char charSecret=secret.charAt(i);
            char charGuess=guess.charAt(i);

            if(charSecret==charGuess) {
                feedback.append(TOT_CORRECTE);
            }
            else if(secret.indexOf(charGuess) != -1) {
                feedback.append(MALA_POSICIO);
            }
            else {
                feedback.append(INCORRECTE);
            }
        }
        return feedback.toString();
    }
}
