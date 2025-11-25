// FILE: PARCIAL-2/src/biblioteca/Copia.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Clase que representa una copia física de un libro en la biblioteca.

package biblioteca;

/**
 * Clase Copia
 * Representa una copia física (ejemplar) de un libro.
 * Cada libro puede tener múltiples copias, y cada copia tiene un identificador único.
 * Demuestra el uso de:
 * - Encapsulamiento
 * - Estados mediante enum
 * - Métodos de dominio para cambiar estado
 */
public class Copia {

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    // El identificador es único para cada copia (ej: "COPIA-001")
    private String identificador;

    // Variable de referencia (EstadoCopia) - almacena una referencia a un enum en el heap
    private EstadoCopia estado;

    // Variable de referencia (Libro) - almacena una referencia al libro al que pertenece esta copia
    private Libro libro;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================

    /**
     * Constructor de Copia.
     * Por defecto, una copia nueva está disponible en biblioteca.
     * @param identificador Código único de la copia.
     * @param libro Libro al que pertenece esta copia.
     */
    public Copia(String identificador, Libro libro) {
        this.identificador = identificador;
        this.libro = libro;
        this.estado = EstadoCopia.EN_BIBLIOTECA;
        
        // Agregar esta copia a la lista de copias del libro
        if (libro != null) {
            libro.agregarCopia(this);
        }
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    /**
     * Obtiene el identificador único de la copia.
     * @return Identificador de la copia.
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador de la copia.
     * @param identificador Nuevo identificador.
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtiene el estado actual de la copia.
     * @return Estado de la copia (EN_BIBLIOTECA o PRESTADA).
     */
    public EstadoCopia getEstado() {
        return estado;
    }

    /**
     * Obtiene el libro al que pertenece esta copia.
     * @return Objeto Libro.
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Establece el libro al que pertenece esta copia.
     * @param libro Libro asociado.
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // =====================================================
    // MÉTODOS DE DOMINIO
    // =====================================================

    /**
     * Verifica si la copia está disponible para préstamo.
     * @return true si está en biblioteca, false si está prestada.
     */
    public boolean estaDisponible() {
        // Variable primitiva (boolean) - el resultado se almacena directamente
        return estado == EstadoCopia.EN_BIBLIOTECA;
    }

    /**
     * Marca la copia como prestada.
     * Cambia el estado de EN_BIBLIOTECA a PRESTADA.
     * @return true si se pudo prestar, false si ya estaba prestada.
     */
    public boolean prestar() {
        if (estaDisponible()) {
            this.estado = EstadoCopia.PRESTADA;
            return true;
        }
        return false;
    }

    /**
     * Marca la copia como devuelta.
     * Cambia el estado de PRESTADA a EN_BIBLIOTECA.
     * @return true si se pudo devolver, false si ya estaba en biblioteca.
     */
    public boolean devolver() {
        if (!estaDisponible()) {
            this.estado = EstadoCopia.EN_BIBLIOTECA;
            return true;
        }
        return false;
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================

    /**
     * Devuelve una representación en texto de la copia.
     * @return Cadena con los datos de la copia.
     */
    @Override
    public String toString() {
        String nombreLibro = (libro != null) ? libro.getNombre() : "Sin libro asignado";
        
        return "Copia{" +
                "identificador='" + identificador + '\'' +
                ", estado=" + estado +
                ", libro='" + nombreLibro + '\'' +
                '}';
    }
}

