package Calculadora;

//Esta clase hace las cuentas de la calculadora

public class CalculadoraLogica {
    
    // Estas variables guardan información importante
    private String numeroActual = "0";          
    private String numeroAnterior = "";         
    private String operacionPendiente = "";     
    private boolean esperandoNumero = false;    
    private boolean tieneDecimal = false;       
    private boolean recienCalculado = false;    
    private boolean hayError = false;           
    private static final int MAXIMO_DIGITOS = 15;

    //Esta clase guarda el resultado de una operación
    public static class ResultadoOperacion {
        public final String operacion;  
        public final String resultado;  
        public final boolean esError;   
        
        public ResultadoOperacion(String operacion, String resultado, boolean esError) {
            this.operacion = operacion;
            this.resultado = resultado;
            this.esError = esError;
        }
        
        public ResultadoOperacion(String operacion, String resultado) {
            this(operacion, resultado, false);
        }
    }

    // Métodos para ver qué tiene la calculadora
    public String getCurrentInput() { return numeroActual; }
    public String getPendingOperation() { return operacionPendiente; }
    public String getPreviousInput() { return numeroAnterior; }
    public boolean getWaitingForOperand() { return esperandoNumero; }
    public boolean hasError() { return hayError; }

    //Cuando pulsas un número del 0 al 9
    public void appendNumber(String numero) {
        // Si hay error, borrar todo
        if (hayError) {
            clearAll();
        }
        
        // Si acabamos de calcular, empezar de nuevo
        if (recienCalculado) {
            numeroActual = numero.equals("0") ? "0" : numero;
            recienCalculado = false;
            tieneDecimal = false;
            return;
        }
        
        // Si esperamos un número nuevo
        if (esperandoNumero) {
            numeroActual = "0";
            esperandoNumero = false;
            tieneDecimal = false;
        }
        
        // Agregar el número
        String nuevoNumero;
        if (numeroActual.equals("0") && !numero.equals("0")) {
            nuevoNumero = numero;  // Cambiar el 0 por el nuevo número
        } else if (!numeroActual.equals("0")) {
            nuevoNumero = numeroActual + numero;  // Agregar al final
        } else {
            return; // No hacer nada si ya hay 0 y agregamos otro 0
        }
        
        // Verificar que no sea muy largo
        String soloDigitos = nuevoNumero.replace(".", "").replace("-", "");
        if (soloDigitos.length() <= MAXIMO_DIGITOS) {
            numeroActual = nuevoNumero;
        }
    }

    //Cuando clickas el punto decimal
    public void addDecimalPoint() {
        if (hayError) {
            clearAll();
        }
        
        if (recienCalculado) {
            numeroActual = "0.";
            recienCalculado = false;
            tieneDecimal = true;
            return;
        }
        
        if (esperandoNumero) {
            numeroActual = "0.";
            esperandoNumero = false;
            tieneDecimal = true;
            return;
        }
        
        // Solo agregar punto si no lo tiene
        if (!tieneDecimal) {
            numeroActual += ".";
            tieneDecimal = true;
        }
    }

    //Cambiar de positivo a negativo (o al revés)
    public void toggleSign() {
        if (hayError) {
            clearAll();
            return;
        }
        
        if (!numeroActual.equals("0")) {
            if (numeroActual.startsWith("-")) {
                numeroActual = numeroActual.substring(1);  // Quitar el signo menos
            } else {
                numeroActual = "-" + numeroActual;         // Agregar el signo menos
            }
        }
    }

    //Borrar el último número 
    public void backspace() {
        if (hayError || recienCalculado) {
            clearAll();
            return;
        }
        
        // Si solo queda un número
        if (numeroActual.length() == 1 || 
            (numeroActual.length() == 2 && numeroActual.startsWith("-"))) {
            numeroActual = "0";
            tieneDecimal = false;
        } else {
            // Si borramos el punto decimal
            if (numeroActual.endsWith(".")) {
                tieneDecimal = false;
            }
            // Quitar el último carácter
            numeroActual = numeroActual.substring(0, numeroActual.length() - 1);
        }
    }

    //Borrar todo (botón AC)
    public void clearAll() {
        numeroActual = "0";
        numeroAnterior = "";
        operacionPendiente = "";
        esperandoNumero = false;
        tieneDecimal = false;
        recienCalculado = false;
        hayError = false;
    }

    //Borrar solo el número actual 
    public void clearCurrent() {
        if (hayError) {
            clearAll();
            return;
        }
        
        numeroActual = "0";
        tieneDecimal = false;
        if (operacionPendiente.isEmpty()) {
            numeroAnterior = "";
        }
    }

    //Elegir qué operación hacer
    
    public void setOperation(String op) {
        if (hayError) {
            clearAll();
            return;
        }
        
        // Verificar que sea una operación válida
        if (!esOperacionValida(op)) {
            return;
        }
        
        // Si ya hay una operación, calcular primero
        if (!operacionPendiente.isEmpty() && !esperandoNumero) {
            ResultadoOperacion resultado = calculate();
            if (resultado.esError) {
                return;
            }
        }
        
        operacionPendiente = op;
        numeroAnterior = numeroActual;
        esperandoNumero = true;
        tieneDecimal = false;
        recienCalculado = false;
    }

    //Hacer la cuenta 
    public ResultadoOperacion calculate() {
        if (hayError) {
            return new ResultadoOperacion("", "Error", true);
        }
        
        // Verificar que tenemos todo para hacer la cuenta
        if (operacionPendiente.isEmpty() || numeroAnterior.isEmpty() || esperandoNumero) {
            return new ResultadoOperacion("", numeroActual);
        }

        try {
            // Convertir los textos a números
            double numero1 = Double.parseDouble(numeroAnterior);
            double numero2 = Double.parseDouble(numeroActual);
            double resultado;

            // Hacer la operación
            switch (operacionPendiente) {
                case "+": 
                    resultado = numero1 + numero2; 
                    break;
                case "-": 
                    resultado = numero1 - numero2; 
                    break;
                case "*": 
                    resultado = numero1 * numero2; 
                    break;
                case "/": 
                    if (numero2 == 0) {
                        throw new ArithmeticException("No se puede dividir por cero");
                    }
                    resultado = numero1 / numero2; 
                    break;
                default:
                    return new ResultadoOperacion("", "Error", true);
            }

            // Preparar la respuesta
            String textoOperacion = numeroAnterior + " " + obtenerSimboloOperacion(operacionPendiente) + " " + numeroActual;
            String textoResultado = formatearResultado(resultado);
            
            // Actualizar la calculadora
            numeroActual = textoResultado;
            numeroAnterior = "";
            operacionPendiente = "";
            esperandoNumero = false;
            tieneDecimal = textoResultado.contains(".");
            recienCalculado = true;
            
            return new ResultadoOperacion(textoOperacion, textoResultado);
            
        } catch (NumberFormatException e) {
            hayError = true;
            numeroActual = "Error";
            limpiarOperacion();
            return new ResultadoOperacion("", "Error", true);
        } catch (ArithmeticException e) {
            hayError = true;
            numeroActual = "Error";
            limpiarOperacion();
            return new ResultadoOperacion("", "Error", true);
        } catch (Exception e) {
            hayError = true;
            numeroActual = "Error";
            limpiarOperacion();
            return new ResultadoOperacion("", "Error", true);
        }
    }
    
    //Calcular porcentaje
    public void performPercentage() {
        if (hayError) {
            clearAll();
            return;
        }
        
        try {
            double numero = Double.parseDouble(numeroActual);
            double resultado = numero / 100.0;
            numeroActual = formatearResultado(resultado);
            tieneDecimal = numeroActual.contains(".");
            recienCalculado = true;
        } catch (Exception e) {
            hayError = true;
            numeroActual = "Error";
            limpiarOperacion();
        }
    }
    
    //Calcular raíz cuadrada
    public void performSquareRoot() {
        if (hayError) {
            clearAll();
            return;
        }
        
        try {
            double numero = Double.parseDouble(numeroActual);
            if (numero < 0) {
                throw new ArithmeticException("No se puede calcular raíz de número negativo");
            }
            
            double resultado = Math.sqrt(numero);
            numeroActual = formatearResultado(resultado);
            tieneDecimal = numeroActual.contains(".");
            recienCalculado = true;
        } catch (Exception e) {
            hayError = true;
            numeroActual = "Error";
            limpiarOperacion();
        }
    }

    // Métodos que ayudan a otros métodos
    
    private void limpiarOperacion() {
        numeroAnterior = "";
        operacionPendiente = "";
        esperandoNumero = false;
        tieneDecimal = false;
        recienCalculado = false;
    }

    private boolean esOperacionValida(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    private String obtenerSimboloOperacion(String op) {
        switch (op) {
            case "*": return "×";
            case "/": return "÷";
            default: return op;
        }
    }

    private String formatearResultado(double resultado) {
        // Si es un número entero, no mostrar decimales
        if (resultado == (long) resultado) {
            return String.valueOf((long) resultado);
        } else {
            // Mostrar con decimales, pero sin muchos ceros
            String formatted = String.format("%.10f", resultado);
            // Quitar ceros del final
            formatted = formatted.replaceAll("0+$", "").replaceAll("\\.$", "");
            return formatted;
        }
    }
    
    // Métodos útiles
    public boolean canAddDecimal() {
        return !tieneDecimal && !hayError;
    }
    
    public boolean isCurrentInputZero() {
        return numeroActual.equals("0");
    }
}