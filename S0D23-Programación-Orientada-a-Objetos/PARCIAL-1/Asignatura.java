/**
 * Asignatura (Course) class
 * Represents a university course with name, code, and semester
 * 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Asignatura {
    // Instance variables (attributes of the course)
    private String nombre;    // Name of the course
    private String codigo;    // Unique code identifying the course
    private int semestre;     // Semester number when the course is taught

    /**
     * Constructor to create a new Asignatura object
     * @param nombre - name of the course (local parameter)
     * @param codigo - course code (local parameter)
     * @param semestre - semester number (local parameter)
     */
    public Asignatura(String nombre, String codigo, int semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
    }

    // Getter methods
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getSemestre() {
        return semestre;
    }

    // Setter methods
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Override toString to provide a nice string representation of the course
     * @return formatted string with course details
     */
    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}

