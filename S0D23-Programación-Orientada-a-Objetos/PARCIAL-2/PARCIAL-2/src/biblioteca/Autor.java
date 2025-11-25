// FILE: PARCIAL-2/src/biblioteca/Autor.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Clase que representa a un autor de libros en el sistema de biblioteca.

package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Autor
 * Representa a un autor de libros con sus datos personales.
 * Demuestra el uso de encapsulamiento, variables de referencia y sobrescritura de toString().
 */
public class Autor {

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    private String nombre;

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    private String nacionalidad;

    // Variable de referencia (LocalDate) - almacena una referencia a un objeto LocalDate en el heap
    private LocalDate fechaNacimiento;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================

    /**
     * Constructor completo de Autor.
     * @param nombre Nombre completo del autor.
     * @param nacionalidad País de origen del autor.
     * @param fechaNacimiento Fecha de nacimiento del autor.
     */
    public Autor(String nombre, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor simplificado sin fecha de nacimiento.
     * @param nombre Nombre completo del autor.
     * @param nacionalidad País de origen del autor.
     */
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = null;
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    /**
     * Obtiene el nombre del autor.
     * @return Nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del autor.
     * @param nombre Nuevo nombre del autor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la nacionalidad del autor.
     * @return Nacionalidad del autor.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del autor.
     * @param nacionalidad Nueva nacionalidad del autor.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene la fecha de nacimiento del autor.
     * @return Fecha de nacimiento o null si no está definida.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del autor.
     * @param fechaNacimiento Nueva fecha de nacimiento.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================

    /**
     * Devuelve una representación en texto del autor.
     * @return Cadena con los datos del autor.
     */
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaTexto = (fechaNacimiento != null) ? fechaNacimiento.format(formato) : "No especificada";
        
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaTexto +
                '}';
    }
}

