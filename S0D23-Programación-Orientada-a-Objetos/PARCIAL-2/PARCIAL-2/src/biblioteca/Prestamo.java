// Autor: Albert Lukmanov 
// Descripción: Clase que representa un préstamo de una copia de libro a un lector.

package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    public static final int DIAS_MAXIMOS_PRESTAMO = 30;

    private Copia copia;
    private Lector lector;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public Prestamo(Copia copia, Lector lector) {
        this.copia = copia;
        this.lector = lector;
        this.fechaInicio = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public Prestamo(Copia copia, Lector lector, LocalDate fechaInicio) {
        this.copia = copia;
        this.lector = lector;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = null;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public long calcularDiasPrestamo() {
        LocalDate fechaLimite = (fechaDevolucion != null) ? fechaDevolucion : LocalDate.now();
        return ChronoUnit.DAYS.between(fechaInicio, fechaLimite);
    }

    public boolean estaVencido() {
        if (fechaDevolucion != null) {
            return calcularDiasPrestamo() > DIAS_MAXIMOS_PRESTAMO;
        }
        return calcularDiasPrestamo() > DIAS_MAXIMOS_PRESTAMO;
    }

    public boolean estaActivo() {
        return fechaDevolucion == null;
    }

    public boolean registrarDevolucion() {
        if (estaActivo()) {
            this.fechaDevolucion = LocalDate.now();
            if (copia != null) {
                copia.devolver();
            }
            return true;
        }
        return false;
    }

    public boolean registrarDevolucion(LocalDate fecha) {
        if (estaActivo()) {
            this.fechaDevolucion = fecha;
            if (copia != null) {
                copia.devolver();
            }
            return true;
        }
        return false;
    }

    public long diasRestantes() {
        if (!estaActivo()) {
            return 0;
        }
        long diasTranscurridos = calcularDiasPrestamo();
        return DIAS_MAXIMOS_PRESTAMO - diasTranscurridos;
    }

    public LocalDate getFechaLimite() {
        return fechaInicio.plusDays(DIAS_MAXIMOS_PRESTAMO);
    }

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