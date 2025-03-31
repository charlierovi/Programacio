package AEA3.MastermindJuego;
import java.util.Scanner;

//Un programa per jugar al MasterMind.
public class MasterMind {
    //Constants
    public final static char TOT_CORRECTE = '0';
    public final static char MALA_POSICIO = 'X';
    public final static char INCORRECTE = '-';
    public final static String ENCERTAT = "OOO";
    public final int LONG_SECRET = 3;
    public final static String abc = "abcdefghijklmnopqrstuvwxyz";
    public static String secret = "";
    public static String resposta = "";

    //Mètodes associats al problema general
    public static void main(String[] args) {
        MasterMind programa = new MasterMind();
        programa.inici();
    }

    public void inici() {
        secret = generarParaulaSecreta();
        boolean encertat = false;
        while (!encertat) {
            resposta = preguntarResposta();
            encertat = resoldreResposta(secret, resposta);
        }
    }


    //Mètodes associats al primer nivell de descomposició
    //Param. entrada: cap, tot s’obté de generarLletraAleatoria
    //Param. sortida: una paraula de 3 lletres (un String)
    public String generarParaulaSecreta() {
        String res = "";
        for (int i = 0; i < LONG_SECRET; i++) {
            res = res + generarLletraAleatoria();
        }
        return res;
    }

    //Param. entrada: cap, tot s’obté del teclat
    // Param. sortida: la paraula de resposta (un String)
    public String preguntarResposta() {
        Scanner lector = new Scanner(System.in);
        boolean lecturaOk = false;
        String res = null;
        do {
            System.out.print("Escriu " + LONG_SECRET + " lletres miníscules: ");
            res = lector.next();
            lector.nextLine();
            lecturaOk = comprovarResposta(res);
            if (!lecturaOk) {
                System.out.println("Aquesta resposta no és vàlida!");
            }
        } while (!lecturaOk);
        return res;
    }

    //Param. entrada: la resposta i el valor secret (dos String)
    //Param. sortida: si s’ha encertat (un booleà)
    public boolean resoldreResposta(String secret, String resposta) {
        String res = generarPista(secret, resposta);
        boolean fi = false;
        System.out.print("La resposta és [" + res + "]. ");
        if (resposta.equals(secret)){
            System.out.println("Has encertat!");
            fi = true;
        } else {
            System.out.println("Continua intentant!");
        }
        return fi;
    }

    //Mètodes associats al segon nivell de descomposició
    //Param. entrada: cap
    //Param. sortida: una lletra (un caràcter)
    public char generarLletraAleatoria() {
        long nano = System.nanoTime();
        int index = (int) (nano % abc.length());
        return abc.charAt(index);
    }

    //Param. entrada: text a comprovar
    //Param. sortida: si és correcte o no (un booleà. true = correcte)
    public boolean comprovarResposta(String resposta) {
        if (resposta.length() != LONG_SECRET) {
        //Ja sabem que no és correcte.
        //Podem acabar l’execució del mètode immediatament.
            return false;
        }
        for (int i = 0; i < resposta.length(); i++) {
            char c = resposta.charAt(i);
            if ( -1 == abc.indexOf(c)){
            //Ja sabem que no és correcte.
            //Podem acabar l’execució del mètode immediatament.
                return false;
            }
        }
        //Si tot es compleix, segur que és correcte
        return true;
    }

    //Param. entrada: la resposta i el secret que cal comparar (text)
    //Param. sortida: la pista que cal mostrar (un text)
    public String generarPista(String s, String r) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char charSecret = s.charAt(i);
            char charResposta = r.charAt(i);
            if (charSecret == charResposta) {
                res = res + TOT_CORRECTE;
            }
            else if (s.indexOf(charResposta) != - 1){
                res = res + MALA_POSICIO;
            }
            else {
                res = res + INCORRECTE;
            }
        }
        return res;
    }
}