package Calculadora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//Esta clase guarda todas las cuentas que hemos hecho
 
public class Historial {
    
    // Variables importantes
    private final List<Operacion> listaOperaciones;  
    private final int maximoOperaciones;             
    private static final int MAXIMO_POR_DEFECTO = 50; 

    //Guarda hasta 50 cuentas
     
    public Historial() {
        this(MAXIMO_POR_DEFECTO);
    }

    //Constructor donde puedes elegir cuántas cuentas guardar
     
    public Historial(int maximoOperaciones) {
        if (maximoOperaciones <= 0) {
            throw new IllegalArgumentException("El máximo debe ser mayor a 0");
        }
        this.maximoOperaciones = maximoOperaciones;
        this.listaOperaciones = new ArrayList<>();
    }

    //Agregar una nueva cuenta al historial
     
    public void agregarOperacion(String operacion, String resultado) {
        if (operacion == null || operacion.trim().isEmpty()) {
            return;
        }
        if (resultado == null || resultado.trim().isEmpty()) {
            return;
        }
        
        // Si ya tenemos muchas cuentas, borrar la más vieja
        if (listaOperaciones.size() >= maximoOperaciones) {
            listaOperaciones.remove(0); 
        }
        
        // Agregar la nueva cuenta
        listaOperaciones.add(new Operacion(operacion, resultado));
    }

    //Ver todas las cuentas guardadas
     
    public List<Operacion> getOperaciones() {
        // Devolver una copia para que no la puedan cambiar
        return new ArrayList<>(listaOperaciones);
    }

    //Ver las últimas cuentas que hemos hecho
    
    public List<Operacion> getUltimasOperaciones(int cantidad) {
        if (cantidad <= 0) {
            return new ArrayList<>(); 
        }
        
        // Calcular desde dónde empezar
        int inicio = Math.max(0, listaOperaciones.size() - cantidad);
        return new ArrayList<>(listaOperaciones.subList(inicio, listaOperaciones.size()));
    }

    //Buscar cuentas que contengan cierto texto
    
    public List<Operacion> buscarOperaciones(String textoBuscar) {
        if (textoBuscar == null || textoBuscar.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        List<Operacion> operacionesEncontradas = new ArrayList<>();
        String busqueda = textoBuscar.toLowerCase(); 
        
        // Revisar cada cuenta
        for (Operacion op : listaOperaciones) {
            if (op.getOperacion().toLowerCase().contains(busqueda) ||
                op.getResultado().toLowerCase().contains(busqueda)) {
                operacionesEncontradas.add(op);
            }
        }
        
        return operacionesEncontradas;
    }

    //Borrar todas las cuentas
     
    public void limpiarHistorial() {
        listaOperaciones.clear();
    }

    //Borrar una cuenta específica
     
    public boolean eliminarOperacion(int posicion) {
        if (posicion >= 0 && posicion < listaOperaciones.size()) {
            listaOperaciones.remove(posicion);
            return true; 
        }
        return false; 
    }

    //Contar cuántas cuentas hay guardadas
     
    public int size() {
        return listaOperaciones.size();
    }

    //Ver si el historial está vacío
     
    public boolean isEmpty() {
        return listaOperaciones.isEmpty();
    }

    //Ver cuántas cuentas máximo se pueden guardar
    public int getCapacidadMaxima() {
        return maximoOperaciones;
    }

    //Convertir todo el historial a texto
    
    public String getHistorialCompleto() {
        if (listaOperaciones.isEmpty()) {
            return "No hay cuentas guardadas";
        }
        
        StringBuilder texto = new StringBuilder();
        texto.append("=== MIS CUENTAS ===\n");
        
        for (int i = 0; i < listaOperaciones.size(); i++) {
            texto.append(String.format("%d. %s\n", i + 1, listaOperaciones.get(i)));
        }
        
        return texto.toString();
    }

    @Override
    public String toString() {
        return String.format("Historial[operaciones=%d, máximo=%d]", 
                           listaOperaciones.size(), maximoOperaciones);
    }

    //Esta clase representa una cuenta que hemos hecho
    
    public static class Operacion {
        private final String operacion;   
        private final String resultado;    
        private final LocalDateTime fecha; 
        
        // Cómo mostrar la fecha
        private static final DateTimeFormatter FORMATO_FECHA = 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        //Crear una nueva cuenta
         
        public Operacion(String operacion, String resultado) {
            this.operacion = operacion;
            this.resultado = resultado;
            this.fecha = LocalDateTime.now(); // Fecha actual
        }

        //Ver la cuenta que se hizo
        
        public String getOperacion() {
            return operacion;
        }

        //Ver el resultado
    
        public String getResultado() {
            return resultado;
        }

        //Ver cuándo se hizo
        
        public LocalDateTime getFecha() {
            return fecha;
        }

        //Ver la fecha 
        
        public String getFechaFormateada() {
            return fecha.format(FORMATO_FECHA);
        }

        //Ver si el resultado es un número válido
        
        public boolean esResultadoNumerico() {
            try {
                Double.parseDouble(resultado);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        //Obtener el resultado como número
         
        public double getResultadoNumerico() throws NumberFormatException {
            return Double.parseDouble(resultado);
        }

        //Mostrar la cuenta como texto
        
        @Override
        public String toString() {
            return String.format("%s = %s [%s]", operacion, resultado, getFechaFormateada());
        }

        //Comparar si dos cuentas son iguales
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            
            Operacion otra = (Operacion) obj;
            return Objects.equals(operacion, otra.operacion) &&
                   Objects.equals(resultado, otra.resultado) &&
                   Objects.equals(fecha, otra.fecha);
        }

        @Override
        public int hashCode() {
            return Objects.hash(operacion, resultado, fecha);
        }
    }
}