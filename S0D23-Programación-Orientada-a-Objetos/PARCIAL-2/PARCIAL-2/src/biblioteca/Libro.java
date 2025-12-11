// FILE: PARCIAL-2/src/biblioteca/Libro.java
// Autor: Albert Lukmanov 
// Descripción: Clase que representa un libro en el sistema de biblioteca.


package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private String nombre;
    private TipoLibro tipo;
    private String editorial;
    private int anioPublicacion;
    private Autor autor;
    private List<Copia> copias;

    public Libro(String nombre, TipoLibro tipo, Autor autor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.autor = autor;
        this.editorial = "Sin especificar";
        this.anioPublicacion = 0;
        this.copias = new ArrayList<>();
    }

    public Libro(String nombre, TipoLibro tipo, String editorial, int anioPublicacion, Autor autor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.copias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoLibro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLibro tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Copia> getCopias() {
        return copias;
    }

    public void agregarCopia(Copia copia) {
        if (copia != null && !copias.contains(copia)) {
            copias.add(copia);
        }
    }

    public int contarCopiasDisponibles() {
        int contador = 0;
        for (Copia copia : copias) {
            if (copia.estaDisponible()) {
                contador++;
            }
        }
        return contador;
    }

    public int getTotalCopias() {
        return copias.size();
    }

    @Override
    public String toString() {
        String anioTexto = (anioPublicacion > 0) ? String.valueOf(anioPublicacion) : "No especificado";
        
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", editorial='" + editorial + '\'' +
                ", anioPublicacion=" + anioTexto +
                ", autor=" + (autor != null ? autor.getNombre() : "Desconocido") +
                ", copiasTotal=" + copias.size() +
                ", copiasDisponibles=" + contarCopiasDisponibles() +
                '}';
    }
}
