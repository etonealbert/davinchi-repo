// Autor: Albert Lukmanov 
// Descripción: Enumeración que representa los posibles estados de una copia de libro.

package biblioteca;

public enum EstadoCopia {
    EN_BIBLIOTECA("En biblioteca"),
    PRESTADA("Prestada");

    private final String descripcion;

    EstadoCopia(String descripcion) {
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

