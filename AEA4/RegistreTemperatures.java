package AEA4;

import java.util.Scanner;

public class RegistreTemperatures {
  //Constants
  private static final int MAX_SETMANES = 52;

  //Variables globals
  private boolean fi = false;
  private int numTemperatures = 0;
  private float[] temperatures = new float[MAX_SETMANES * 7];
  private int dia = 1;
  private int mes = 1;

  //M todes associats al problema general
  public static void main (String[] args) {
    RegistreTemperatures programa = new RegistreTemperatures();
    programa.inici();
  }

  public void inici() {
    while (!fi) {
      mostrarMenu();
      tractarOpcio();
    }
  }

  //Mètodes associats al punt 2 
  public void mostrarMenu() {
    System.out.println("\nBenvingut al registre de temperatures");
    System .out.println("--------------------------------------");
    System.out.println("[RT] Registrar temperatures setmanals.");
    System.out.println("[MJ] Consultar temperatura mitjana.");
    System.out.println("[DF] Consultar diferència màxima.");
    System.out.println("[FI] Sortir.");
    System.out.print("Opció: ");
  }

  public void tractarOpcio() {
    Scanner lector = new Scanner(System.in);
    String opcio = lector.nextLine();
    if (opcio.equalsIgnoreCase("RT")) {
      registreTemperaturesSetmanals();
    }
    else if (opcio.equalsIgnoreCase("MJ")) {
      mostrarMitjana();
    }
    else if (opcio.equalsIgnoreCase("DF")) {
      mostrarDiferencia();
    }
    else if (opcio.equalsIgnoreCase("FI")) {
      //S’ha esborrat el m tode finalitzarExecuci  i s’ha posat el seu codi directament.
      fi = true;
    }
    else {
      System.out.println("Opció incorrecta!\n");
    }
  }

  //M todes associats al punt 3
  public void registreTemperaturesSetmanals() {
    //Cal controlar si hi haurà espai per a aquests 7 registres
    if ((numTemperatures + 7) >= temperatures.length) {
      System.out.println("No queda espai per a més temperatures.");
    }
    else {
      llegirTemperaturesTeclat();
      incrementarData();
    }
  }

  public void mostrarMitjana() {
    //if (numTemperatures > 0) {
      System.out.print("\nFins avui ");
      mostrarData();
      System.out.print(" la mitjana ha estat de ");
      calculaMitjana();
      System.out.println(" graus.");
    //}
    //else {
     // System.out.println("\nNo hi ha temperatures registrades.");
    //}
  }

  public void mostrarDiferencia() {
    //if (numTemperatures > 0) {
      System.out.print("\nFins avui ");
      mostrarData();
      System.out.print(" la diferència màxima ha estat de ");
      calculaDiferencia();
      System.out.println(" graus.");
    //}
    //else {
      //System.out.println("\nNo hi ha temperatures registrades.");
    //}
  }

  public void llegirTemperaturesTeclat() {
    System.out.println("Escriu les temperatures d’aquesta setmana:");
    Scanner lector = new Scanner(System.in);
    int numLlegides = 0;
    while (numLlegides < 7) {
      if (lector.hasNextFloat()) {
        temperatures[numTemperatures] = lector.nextFloat();
        numLlegides++;
        numTemperatures++;
      }
      else {
        lector.next();
      }
    }
  }

  public void incrementarData() {
    //Quants dies t  aquest mes?
    int diesAquestMes = 0;
    if (mes == 2) {
      diesAquestMes = 28;
    }
    else if ((mes == 4)||(mes == 6)||(mes == 9 )||(mes == 11)) {
      diesAquestMes = 30;
    }
    else {
      diesAquestMes = 31;
    }
    dia = dia + 7;
    //Hem passat de mes?
    if (dia > diesAquestMes) {
      dia = dia - diesAquestMes;
      mes++;
      //Hem passat d’any?
      if (mes > 12) {
        mes = 1;
      }
    }
  }

  public void mostrarData() {
    System.out.print(dia + " de ");
    switch(mes) {
      case 1:
        System.out.print("Gener");
        break;
      case 2:
        System.out.print("Febrer");
        break;
      case 3:
        System.out.print("Mar ");
        break;
      case 4:
        System.out.print("Abril");
        break;
      case 5:
        System.out.print("Maig");
        break;
      case 6:
        System.out.print("Juny");
        break;
      case 7:
        System.out.print("Juliol");
        break;
      case 8:
        System.out.print("Agost");
        break;
      case 9:
        System.out.print("Setembre");
        break;
      case 10:
        System.out.print("Octubre");
        break;
      case 11:
        System.out.print("Novembre");
        break;
      case 12:
        System.out.print("Desembre");
    }
  }

  public void calculaMitjana() {
    try {
      int acumulador = 0;
      int divisor = 0;
      //for(int i = 0; i < numTemperatures; i++) {
        //acumulador = acumulador + temperatures[i];
      //}
      System.out.print((acumulador / divisor));
    }
    catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }

  public void calculaDiferencia() {
    try {
      temperatures[99999] = 5;

      float error = temperatures[99999];
      float maxima = temperatures[0];
      float minima = temperatures[0];
      for(int i = 1; i < numTemperatures; i++) {
        if (temperatures[i] < minima) {
          minima = temperatures[i];
        }
        if (temperatures[i] > maxima) {
          maxima = temperatures[i];
        }
      }
      System.out.print((maxima - minima));
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Error: no hi ha temperatures registrades.");
    }
    catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }
}
