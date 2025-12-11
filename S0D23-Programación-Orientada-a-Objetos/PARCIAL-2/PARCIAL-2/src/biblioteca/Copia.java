// Autor: Albert Lukmanov
// Descripción: Clase que representa una copia física de un libro en la biblioteca.

package biblioteca;


public class Copia {

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================

    private String identificador;

    private EstadoCopia estado;

    private Libro libro;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================

    public Copia(String identificador, Libro libro) {
        this.identificador = identificador;
        this.libro = libro;
        this.estado = EstadoCopia.EN_BIBLIOTECA;
        
        if (libro != null) {
            libro.agregarCopia(this);
        }
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public EstadoCopia getEstado() {
        return estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // =====================================================
    // MÉTODOS DE DOMINIO
    // =====================================================

    public boolean estaDisponible() {
        return estado == EstadoCopia.EN_BIBLIOTECA;
    }


    public boolean prestar() {
        if (estaDisponible()) {
            this.estado = EstadoCopia.PRESTADA;
            return true;
        }
        return false;
    }


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


