package Calculadora;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Esta clase hace la ventana de la calculadora
public class CalculadoraGUI extends JFrame implements KeyListener {
    
    // Los colores que vamos a usar
    private static final Color COLOR_FONDO = new Color(240, 248, 255);        
    private static final Color COLOR_BOTONES_NUMEROS = new Color(135, 206, 250); 
    private static final Color COLOR_BOTONES_OPERACIONES = new Color(255, 165, 0); 
    private static final Color COLOR_BOTONES_FUNCIONES = new Color(144, 238, 144); 
    private static final Color COLOR_PANTALLA = Color.WHITE;                 
    private static final Color COLOR_TEXTO = Color.BLACK;                      
    
    // Las cosas que necesitamos
    private CalculadoraLogica logica;
    private Historial historial;
    
    // Las partes de la ventana
    private JTextField pantallaPrincipal;
    private JTextField pantallaOperacion;
    private JList<String> listaHistorial;
    private DefaultListModel<String> modeloHistorial;
    private JPanel panelHistorial;
    private boolean historialVisible = false;

    // Constructor - Se ejecuta cuando creamos la calculadora
    public CalculadoraGUI(CalculadoraLogica logica, Historial historial) {
        this.logica = logica;
        this.historial = historial;
        
        configurarVentana();
        crearComponentes();
        configurarTeclado();
        actualizarPantalla();
        actualizarHistorial();
    }

    // Configurar cómo se ve la ventana
    private void configurarVentana() {
        setTitle("CALCULADORA FINAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null); // Poner en el centro
        setResizable(false);
        getContentPane().setBackground(COLOR_FONDO);
    }

    // Crear todas las cosas que van en la ventana
    private void crearComponentes() {
        crearPantallas();
        crearBotones();
        crearHistorial();
        organizarComponentes();
    }

    // Crear las pantallas donde salen los números
    private void crearPantallas() {
        // Pantalla grande donde salen los números
        pantallaPrincipal = new JTextField("0");
        pantallaPrincipal.setEditable(false);
        pantallaPrincipal.setHorizontalAlignment(JTextField.RIGHT);
        pantallaPrincipal.setFont(new Font("Arial", Font.BOLD, 28));
        pantallaPrincipal.setBackground(COLOR_PANTALLA);
        pantallaPrincipal.setForeground(COLOR_TEXTO);
        pantallaPrincipal.setBorder(new EmptyBorder(10, 15, 10, 15));
        pantallaPrincipal.setPreferredSize(new Dimension(0, 60));
        
        // Pantalla pequeña donde sale lo que estamos haciendo
        pantallaOperacion = new JTextField();
        pantallaOperacion.setEditable(false);
        pantallaOperacion.setHorizontalAlignment(JTextField.RIGHT);
        pantallaOperacion.setFont(new Font("Arial", Font.PLAIN, 14));
        pantallaOperacion.setBackground(COLOR_PANTALLA);
        pantallaOperacion.setForeground(Color.GRAY);
        pantallaOperacion.setBorder(new EmptyBorder(5, 15, 5, 15));
        pantallaOperacion.setPreferredSize(new Dimension(0, 30));
    }

    // Crear los botones
    private void crearBotones() {
    }

    // Hacer un botón con colores 
    private JButton crearBoton(String texto, Color color, ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(color);
        boton.setForeground(COLOR_TEXTO);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(70, 50));
        boton.addActionListener(accion);
        
        // Cambiar color cuando pasas el cursor
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(color.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(color);
            }
        });
        
        return boton;
    }

    // Crear la lista del historial
    private void crearHistorial() {
        modeloHistorial = new DefaultListModel<>();
        listaHistorial = new JList<>(modeloHistorial);
        listaHistorial.setFont(new Font("Arial", Font.PLAIN, 12));
        listaHistorial.setBackground(COLOR_PANTALLA);
        listaHistorial.setForeground(COLOR_TEXTO);
        
        // Si haces doble clic, usa ese número
        listaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    usarResultadoDelHistorial();
                }
            }
        });
        
        JScrollPane scrollHistorial = new JScrollPane(listaHistorial);
        scrollHistorial.setPreferredSize(new Dimension(0, 150));
        
        panelHistorial = new JPanel(new BorderLayout());
        panelHistorial.setBackground(COLOR_FONDO);
        panelHistorial.setBorder(BorderFactory.createTitledBorder("Historial"));
        panelHistorial.add(scrollHistorial, BorderLayout.CENTER);
        panelHistorial.setVisible(false);
    }

    // Poner todo en su lugar en la ventana
    private void organizarComponentes() {
        setLayout(new BorderLayout(10, 10));
        
        // El panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(COLOR_FONDO);
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        // Donde van las pantallas
        JPanel panelPantallas = new JPanel(new BorderLayout());
        panelPantallas.setBackground(COLOR_FONDO);
        panelPantallas.add(pantallaOperacion, BorderLayout.NORTH);
        panelPantallas.add(pantallaPrincipal, BorderLayout.CENTER);
        
        // Donde van los botones
        JPanel panelBotones = new JPanel(new GridLayout(6, 4, 5, 5));
        panelBotones.setBackground(COLOR_FONDO);
        
        // FILA 1: Botones para limpiar
        panelBotones.add(crearBoton("AC", COLOR_BOTONES_FUNCIONES, e -> {
            logica.clearAll();
            actualizarPantalla();
        }));
        panelBotones.add(crearBoton("CE", COLOR_BOTONES_FUNCIONES, e -> {
            logica.clearCurrent();
            actualizarPantalla();
        }));
        panelBotones.add(crearBoton("{x]", COLOR_BOTONES_FUNCIONES, e -> {
            logica.backspace();
            actualizarPantalla();
        }));
        panelBotones.add(crearBoton("÷", COLOR_BOTONES_OPERACIONES, e -> {
            realizarOperacion("/");
        }));
        
        // FILA 2: Más funciones
        panelBotones.add(crearBoton("%", COLOR_BOTONES_FUNCIONES, e -> {
            logica.performPercentage();
            actualizarPantalla();
        }));
        panelBotones.add(crearBoton("√", COLOR_BOTONES_FUNCIONES, e -> {
            logica.performSquareRoot();
            actualizarPantalla();
        }));
        panelBotones.add(crearBoton("H", COLOR_BOTONES_FUNCIONES, e -> {
            mostrarOcultarHistorial();
        }));
        panelBotones.add(crearBoton("×", COLOR_BOTONES_OPERACIONES, e -> {
            realizarOperacion("*");
        }));
        
        // FILA 3: Números 7-9
        panelBotones.add(crearBoton("7", COLOR_BOTONES_NUMEROS, e -> escribirNumero("7")));
        panelBotones.add(crearBoton("8", COLOR_BOTONES_NUMEROS, e -> escribirNumero("8")));
        panelBotones.add(crearBoton("9", COLOR_BOTONES_NUMEROS, e -> escribirNumero("9")));
        panelBotones.add(crearBoton("-", COLOR_BOTONES_OPERACIONES, e -> {
            realizarOperacion("-");
        }));
        
        // FILA 4: Números 4-6
        panelBotones.add(crearBoton("4", COLOR_BOTONES_NUMEROS, e -> escribirNumero("4")));
        panelBotones.add(crearBoton("5", COLOR_BOTONES_NUMEROS, e -> escribirNumero("5")));
        panelBotones.add(crearBoton("6", COLOR_BOTONES_NUMEROS, e -> escribirNumero("6")));
        panelBotones.add(crearBoton("+", COLOR_BOTONES_OPERACIONES, e -> {
            realizarOperacion("+");
        }));
        
        // FILA 5: Números 1-3
        panelBotones.add(crearBoton("1", COLOR_BOTONES_NUMEROS, e -> escribirNumero("1")));
        panelBotones.add(crearBoton("2", COLOR_BOTONES_NUMEROS, e -> escribirNumero("2")));
        panelBotones.add(crearBoton("3", COLOR_BOTONES_NUMEROS, e -> escribirNumero("3")));
        panelBotones.add(crearBoton("=", COLOR_BOTONES_OPERACIONES, e -> {
            calcular();
        }));
        
        // FILA 6: Última fila
        panelBotones.add(crearBoton("±", COLOR_BOTONES_FUNCIONES, e -> {
            logica.toggleSign();
            actualizarPantalla();
        }));
        panelBotones.add(crearBoton("0", COLOR_BOTONES_NUMEROS, e -> escribirNumero("0")));
        panelBotones.add(crearBoton(".", COLOR_BOTONES_NUMEROS, e -> {
            if (logica.canAddDecimal()) {
                logica.addDecimalPoint();
                actualizarPantalla();
            }
        }));
        panelBotones.add(crearBoton("Limpiar", COLOR_BOTONES_FUNCIONES, e -> {
            limpiarHistorial();
        }));
        
        // Juntar todo
        panelPrincipal.add(panelPantallas, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelHistorial, BorderLayout.SOUTH);
    }

    // Cuando presionas un número
    private void escribirNumero(String numero) {
        logica.appendNumber(numero);
        actualizarPantalla();
    }

    // Cuando presionas +, -, *, /
    private void realizarOperacion(String operacion) {
        if (!logica.hasError()) {
            if (!logica.getPendingOperation().isEmpty() && !logica.getWaitingForOperand()) {
                calcular();
            }
            logica.setOperation(operacion);
            actualizarPantalla();
        }
    }

    // Cuando presionas =
    private void calcular() {
        CalculadoraLogica.ResultadoOperacion resultado = logica.calculate();
        if (!resultado.operacion.isEmpty() && !resultado.esError) {
            historial.agregarOperacion(resultado.operacion, resultado.resultado);
            actualizarHistorial();
        }
        actualizarPantalla();
    }

    // Mostrar o esconder el historial
    private void mostrarOcultarHistorial() {
        historialVisible = !historialVisible;
        panelHistorial.setVisible(historialVisible);
        
        if (historialVisible) {
            setSize(getWidth(), 750);
        } else {
            setSize(getWidth(), 600);
        }
        
        revalidate();
        repaint();
    }

    // Borrar todo el historial
    private void limpiarHistorial() {
        int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Quieres borrar todo el historial?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            historial.limpiarHistorial();
            actualizarHistorial();
        }
    }

    // Usar un número del historial
    private void usarResultadoDelHistorial() {
        String seleccionado = listaHistorial.getSelectedValue();
        if (seleccionado != null) {
            // Sacar el resultado
            String[] partes = seleccionado.split(" = ");
            if (partes.length == 2) {
                logica.clearAll();
                String resultado = partes[1].split(" \\[")[0]; // Quitar la fecha
                
                // Escribir el resultado
                for (char c : resultado.toCharArray()) {
                    if (Character.isDigit(c)) {
                        logica.appendNumber(String.valueOf(c));
                    } else if (c == '.') {
                        logica.addDecimalPoint();
                    } else if (c == '-') {
                        logica.toggleSign();
                    }
                }
                actualizarPantalla();
            }
        }
    }

    // Actualizar lo que se ve en las pantallas
    private void actualizarPantalla() {
        String textoActual = logica.getCurrentInput();
        pantallaPrincipal.setText(textoActual);
        
        // Hacer las letras más pequeñas si el número es muy largo
        int tamanoLetra = textoActual.length() > 10 ? 20 : 28;
        pantallaPrincipal.setFont(new Font("Arial", Font.BOLD, tamanoLetra));
        
        // Mostrar lo que estamos calculando
        if (!logica.getPendingOperation().isEmpty() && !logica.getPreviousInput().isEmpty()) {
            String simboloOperacion = obtenerSimboloOperacion(logica.getPendingOperation());
            pantallaOperacion.setText(logica.getPreviousInput() + " " + simboloOperacion);
        } else {
            pantallaOperacion.setText("");
        }
        
        // Si hay error, poner rojo
        if (logica.hasError()) {
            pantallaPrincipal.setForeground(Color.RED);
        } else {
            pantallaPrincipal.setForeground(COLOR_TEXTO);
        }
    }

    // Cambiar * por × y / por ÷
    private String obtenerSimboloOperacion(String op) {
        switch (op) {
            case "+": return "+";
            case "-": return "-";
            case "*": return "×";
            case "/": return "÷";
            default: return op;
        }
    }

    // Actualizar la lista del historial
    private void actualizarHistorial() {
        modeloHistorial.clear();
        for (Historial.Operacion op : historial.getOperaciones()) {
            modeloHistorial.addElement(op.toString());
        }
        
        // Ir al final de la lista
        if (modeloHistorial.size() > 0) {
            listaHistorial.ensureIndexIsVisible(modeloHistorial.size() - 1);
        }
    }

    // Para que funcione el teclado
    private void configurarTeclado() {
        setFocusable(true);
        addKeyListener(this);
        
        // Poner foco en la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent e) {
                requestFocus();
            }
        });
    }

    // Cuando pulsas una tecla
    @Override
    public void keyPressed(KeyEvent e) {
        char tecla = e.getKeyChar();
        
        // Si es un número
        if (Character.isDigit(tecla)) {
            escribirNumero(String.valueOf(tecla));
        } else {
            // Otras teclas
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    calcular();
                    break;
                case KeyEvent.VK_PLUS:
                    realizarOperacion("+");
                    break;
                case KeyEvent.VK_MINUS:
                    realizarOperacion("-");
                    break;
                case KeyEvent.VK_MULTIPLY:
                    realizarOperacion("*");
                    break;
                case KeyEvent.VK_DIVIDE:
                    realizarOperacion("/");
                    break;
                case KeyEvent.VK_PERIOD:
                case KeyEvent.VK_COMMA:
                    if (logica.canAddDecimal()) {
                        logica.addDecimalPoint();
                        actualizarPantalla();
                    }
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    logica.backspace();
                    actualizarPantalla();
                    break;
                case KeyEvent.VK_ESCAPE:
                    logica.clearAll();
                    actualizarPantalla();
                    break;
                case KeyEvent.VK_H:
                    mostrarOcultarHistorial();
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {   
    }
}