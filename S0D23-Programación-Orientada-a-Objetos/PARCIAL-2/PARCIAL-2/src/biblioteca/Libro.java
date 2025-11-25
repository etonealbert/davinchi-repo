// FILE: PARCIAL-2/src/biblioteca/Libro.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Clase que representa un libro en el sistema de biblioteca.

package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Libro
 * Representa un libro con su información bibliográfica y sus copias físicas.
 * Demuestra el uso de:
 * - Encapsulamiento
 * - Constructores sobrecargados (overloading)
 * - Colecciones (List/ArrayList)
 * - Variables primitivas y de referencia
 */
public class Libro {

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    private String nombre;

    // Variable de referencia (TipoLibro) - almacena una referencia a un enum en el heap
    private TipoLibro tipo;

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    private String editorial;

    // Variable PRIMITIVA (int) - su valor se almacena directamente en la pila (stack)
    // Los tipos primitivos como int, boolean, char, etc. almacenan el valor real, no una referencia
    private int anioPublicacion;

    // Variable de referencia (Autor) - almacena una referencia a un objeto Autor en el heap
    private Autor autor;

    // Variable de referencia (List<Copia>) - almacena una referencia a una colección en el heap
    // La lista contiene referencias a objetos Copia
    private List<Copia> copias;

    // =====================================================
    // CONSTRUCTORES SOBRECARGADOS (Overloading)
    // =====================================================

    /**
     * Constructor básico con parámetros mínimos.
     * Demuestra sobrecarga de constructores (overloading).
     * @param nombre Título del libro.
     * @param tipo Categoría del libro (NOVELA, TEATRO, POESIA).
     * @param autor Autor del libro.
     */
    public Libro(String nombre, TipoLibro tipo, Autor autor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.autor = autor;
        this.editorial = "Sin especificar";
        this.anioPublicacion = 0;
        this.copias = new ArrayList<>();
    }

    /**
     * Constructor completo con todos los parámetros.
     * Demuestra sobrecarga de constructores (overloading).
     * @param nombre Título del libro.
     * @param tipo Categoría del libro (NOVELA, TEATRO, POESIA).
     * @param editorial Editorial que publicó el libro.
     * @param anioPublicacion Año de publicación.
     * @param autor Autor del libro.
     */
    public Libro(String nombre, TipoLibro tipo, String editorial, int anioPublicacion, Autor autor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.copias = new ArrayList<>();
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    /**
     * Obtiene el nombre (título) del libro.
     * @return Título del libro.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre (título) del libro.
     * @param nombre Nuevo título del libro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de libro.
     * @return Tipo de libro (NOVELA, TEATRO, POESIA).
     */
    public TipoLibro getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de libro.
     * @param tipo Nuevo tipo de libro.
     */
    public void setTipo(TipoLibro tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la editorial del libro.
     * @return Nombre de la editorial.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del libro.
     * @param editorial Nueva editorial.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene el año de publicación.
     * @return Año de publicación.
     */
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    /**
     * Establece el año de publicación.
     * @param anioPublicacion Nuevo año de publicación.
     */
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Obtiene el autor del libro.
     * @return Objeto Autor.
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     * @param autor Nuevo autor.
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la lista de copias del libro.
     * @return Lista de copias.
     */
    public List<Copia> getCopias() {
        return copias;
    }

    // =====================================================
    // MÉTODOS DE DOMINIO
    // =====================================================

    /**
     * Agrega una copia a este libro.
     * @param copia Copia a agregar.
     */
    public void agregarCopia(Copia copia) {
        if (copia != null && !copias.contains(copia)) {
            copias.add(copia);
        }
    }

    /**
     * Cuenta las copias disponibles (no prestadas) de este libro.
     * @return Cantidad de copias disponibles.
     */
    public int contarCopiasDisponibles() {
        // Variable primitiva (int) - contador almacenado directamente
        int contador = 0;
        for (Copia copia : copias) {
            if (copia.estaDisponible()) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Obtiene el total de copias de este libro.
     * @return Cantidad total de copias.
     */
    public int getTotalCopias() {
        return copias.size();
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================

    /**
     * Devuelve una representación en texto del libro.
     * @return Cadena con los datos del libro.
     */
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

