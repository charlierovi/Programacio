package Calculadora;

// Esta clase inicia el programa de la calculadora
public class Calculadora {
    public static void main(String[] args) {
        // Hacer las partes de la calculadora
        CalculadoraLogica logica = new CalculadoraLogica();
        Historial historial = new Historial();
        
        // Crear la ventana y mostrarla
        CalculadoraGUI ventana = new CalculadoraGUI(logica, historial);
        ventana.setVisible(true);
    }
}