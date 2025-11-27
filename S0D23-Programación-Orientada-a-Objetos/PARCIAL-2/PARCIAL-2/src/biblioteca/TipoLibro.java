// Autor: Albert Lukmanov 
// Descripción: Enumeración que representa los tipos de libros disponibles en la biblioteca.

package biblioteca;

public enum TipoLibro {
    NOVELA("Novela"),
    TEATRO("Teatro"),
    POESIA("Poesía");

    private final String descripcion;


    TipoLibro(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

