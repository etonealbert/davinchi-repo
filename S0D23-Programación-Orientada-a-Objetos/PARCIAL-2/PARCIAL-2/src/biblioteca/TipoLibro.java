// FILE: PARCIAL-2/src/biblioteca/TipoLibro.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Enumeración que representa los tipos de libros disponibles en la biblioteca.

package biblioteca;

/**
 * Enumeración TipoLibro
 * Define las categorías de libros que maneja la biblioteca.
 * Los enums en Java son tipos especiales que representan un conjunto fijo de constantes.
 */
public enum TipoLibro {
    NOVELA("Novela"),
    TEATRO("Teatro"),
    POESIA("Poesía");

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    private final String descripcion;

    /**
     * Constructor del enum.
     * @param descripcion Descripción legible del tipo de libro.
     */
    TipoLibro(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del tipo de libro.
     * @return Descripción del tipo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

