// FILE: PARCIAL-2/src/biblioteca/EstadoCopia.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Enumeración que representa los posibles estados de una copia de libro.

package biblioteca;

/**
 * Enumeración EstadoCopia
 * Define los estados posibles de una copia física de un libro.
 * Una copia puede estar disponible en la biblioteca o prestada a un lector.
 */
public enum EstadoCopia {
    EN_BIBLIOTECA("En biblioteca"),
    PRESTADA("Prestada");

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    private final String descripcion;

    /**
     * Constructor del enum.
     * @param descripcion Descripción legible del estado.
     */
    EstadoCopia(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del estado.
     * @return Descripción del estado.
     */
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

