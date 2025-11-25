// FILE: PARCIAL-2/src/biblioteca/Prestamo.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Clase que representa un préstamo de una copia de libro a un lector.

package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Clase Prestamo
 * Representa el préstamo de una copia específica de un libro a un lector.
 * Implementa la regla de negocio:
 * - Un préstamo no puede superar los 30 días sin marcarse como vencido.
 * Demuestra el uso de:
 * - Encapsulamiento
 * - Manejo de fechas con LocalDate
 * - Variables primitivas y de referencia
 * - Cálculos de negocio
 */
public class Prestamo {

    // =====================================================
    // CONSTANTES
    // =====================================================

    // Variable primitiva (int) - constante que define los días máximos de préstamo
    // Se almacena directamente y es compartida por todas las instancias
    public static final int DIAS_MAXIMOS_PRESTAMO = 30;

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================

    // Variable de referencia (Copia) - almacena una referencia al ejemplar prestado
    private Copia copia;

    // Variable de referencia (Lector) - almacena una referencia al lector que tiene el préstamo
    private Lector lector;

    // Variable de referencia (LocalDate) - fecha en que se inició el préstamo
    // LocalDate es un tipo de referencia que representa una fecha sin hora
    private LocalDate fechaInicio;

    // Variable de referencia (LocalDate) - fecha en que se devolvió el libro (puede ser null)
    // Si es null, significa que el préstamo aún está activo
    private LocalDate fechaDevolucion;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================

    /**
     * Constructor de Préstamo con fecha de inicio actual.
     * @param copia Copia del libro a prestar.
     * @param lector Lector que solicita el préstamo.
     */
    public Prestamo(Copia copia, Lector lector) {
        this.copia = copia;
        this.lector = lector;
        this.fechaInicio = LocalDate.now();
        this.fechaDevolucion = null;
    }

    /**
     * Constructor de Préstamo con fecha de inicio personalizada.
     * Útil para simular préstamos antiguos o pruebas.
     * @param copia Copia del libro a prestar.
     * @param lector Lector que solicita el préstamo.
     * @param fechaInicio Fecha de inicio del préstamo.
     */
    public Prestamo(Copia copia, Lector lector, LocalDate fechaInicio) {
        this.copia = copia;
        this.lector = lector;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = null;
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    /**
     * Obtiene la copia prestada.
     * @return Objeto Copia.
     */
    public Copia getCopia() {
        return copia;
    }

    /**
     * Establece la copia prestada.
     * @param copia Nueva copia.
     */
    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    /**
     * Obtiene el lector del préstamo.
     * @return Objeto Lector.
     */
    public Lector getLector() {
        return lector;
    }

    /**
     * Establece el lector del préstamo.
     * @param lector Nuevo lector.
     */
    public void setLector(Lector lector) {
        this.lector = lector;
    }

    /**
     * Obtiene la fecha de inicio del préstamo.
     * @return Fecha de inicio.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del préstamo.
     * @param fechaInicio Nueva fecha de inicio.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de devolución del préstamo.
     * @return Fecha de devolución o null si aún está activo.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    // =====================================================
    // MÉTODOS DE DOMINIO (Cálculos y Reglas de Negocio)
    // =====================================================

    /**
     * Calcula los días transcurridos desde el inicio del préstamo.
     * Si el préstamo está activo, calcula hasta hoy.
     * Si ya fue devuelto, calcula hasta la fecha de devolución.
     * @return Número de días del préstamo.
     */
    public long calcularDiasPrestamo() {
        // Variable de referencia (LocalDate) - fecha límite para el cálculo
        LocalDate fechaLimite = (fechaDevolucion != null) ? fechaDevolucion : LocalDate.now();
        
        // Variable primitiva (long) - días transcurridos se almacena directamente
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaLimite);
        return dias;
    }

    /**
     * Verifica si el préstamo está vencido (supera los 30 días).
     * Solo aplica a préstamos activos (no devueltos).
     * @return true si está vencido, false en caso contrario.
     */
    public boolean estaVencido() {
        // Si ya fue devuelto, verificamos si la devolución fue tardía
        if (fechaDevolucion != null) {
            return calcularDiasPrestamo() > DIAS_MAXIMOS_PRESTAMO;
        }
        
        // Si está activo, verificamos contra la fecha actual
        return calcularDiasPrestamo() > DIAS_MAXIMOS_PRESTAMO;
    }

    /**
     * Verifica si el préstamo está activo (no devuelto).
     * @return true si está activo, false si ya fue devuelto.
     */
    public boolean estaActivo() {
        // Variable primitiva (boolean) - el resultado se almacena directamente
        return fechaDevolucion == null;
    }

    /**
     * Registra la devolución del préstamo.
     * Marca la fecha de devolución como hoy y actualiza el estado de la copia.
     * @return true si se registró correctamente, false si ya estaba devuelto.
     */
    public boolean registrarDevolucion() {
        if (estaActivo()) {
            this.fechaDevolucion = LocalDate.now();
            
            // Actualizar el estado de la copia
            if (copia != null) {
                copia.devolver();
            }
            
            return true;
        }
        return false;
    }

    /**
     * Registra la devolución del préstamo con una fecha específica.
     * Útil para simular devoluciones en fechas pasadas.
     * @param fecha Fecha de devolución.
     * @return true si se registró correctamente, false si ya estaba devuelto.
     */
    public boolean registrarDevolucion(LocalDate fecha) {
        if (estaActivo()) {
            this.fechaDevolucion = fecha;
            
            // Actualizar el estado de la copia
            if (copia != null) {
                copia.devolver();
            }
            
            return true;
        }
        return false;
    }

    /**
     * Calcula los días restantes antes del vencimiento.
     * @return Días restantes (negativo si ya venció).
     */
    public long diasRestantes() {
        if (!estaActivo()) {
            return 0;
        }
        // Variable primitiva (long) - diferencia de días
        long diasTranscurridos = calcularDiasPrestamo();
        return DIAS_MAXIMOS_PRESTAMO - diasTranscurridos;
    }

    /**
     * Obtiene la fecha límite de devolución.
     * @return Fecha máxima para devolver sin multa.
     */
    public LocalDate getFechaLimite() {
        return fechaInicio.plusDays(DIAS_MAXIMOS_PRESTAMO);
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================

    /**
     * Devuelve una representación en texto del préstamo.
     * @return Cadena con los datos del préstamo.
     */
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String nombreLibro = (copia != null && copia.getLibro() != null) 
                ? copia.getLibro().getNombre() 
                : "Desconocido";
        String idCopia = (copia != null) ? copia.getIdentificador() : "N/A";
        String nombreLector = (lector != null) ? lector.getNombre() : "Desconocido";
        String fechaInicioTexto = fechaInicio.format(formato);
        String fechaDevolucionTexto = (fechaDevolucion != null) 
                ? fechaDevolucion.format(formato) 
                : "Pendiente";
        String estadoPrestamo = estaActivo() ? "ACTIVO" : "DEVUELTO";
        String estadoVencimiento = estaVencido() ? "VENCIDO" : "Al día";
        
        return "Prestamo{" +
                "libro='" + nombreLibro + '\'' +
                ", copia='" + idCopia + '\'' +
                ", lector='" + nombreLector + '\'' +
                ", fechaInicio=" + fechaInicioTexto +
                ", fechaDevolucion=" + fechaDevolucionTexto +
                ", diasPrestamo=" + calcularDiasPrestamo() +
                ", estado=" + estadoPrestamo +
                ", vencimiento=" + estadoVencimiento +
                '}';
    }
}

