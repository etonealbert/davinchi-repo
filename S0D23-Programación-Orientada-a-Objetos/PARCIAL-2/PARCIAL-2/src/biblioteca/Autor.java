// Autor: Albert Lukmanov 
// Descripción: Clase que representa a un autor de libros en el sistema de biblioteca.

package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Autor {

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================
    private String nombre;

    private String nacionalidad;

    private LocalDate fechaNacimiento;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================
    public Autor(String nombre, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = null;
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================
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

