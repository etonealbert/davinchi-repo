/**
 * Profesor (Professor) class
 * Represents a university professor with name, ID, and the course they teach
 * 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Profesor {
    // Instance variables (attributes of the professor)
    private String nombre;        // Professor's name
    private String id;            // Unique identifier for the professor
    private Asignatura asignatura; // The course this professor teaches (composition relationship)

    /**
     * Constructor to create a new Profesor object
     * @param nombre - professor's name (local parameter)
     * @param id - unique identifier (local parameter)
     * @param asignatura - the course being taught (local parameter)
     */
    public Profesor(String nombre, String id, Asignatura asignatura) {
        this.nombre = nombre;
        this.id = id;
        this.asignatura = asignatura;
    }

    // Getter methods
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    // Setter methods
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * Override toString to provide a nice string representation of the professor
     * @return formatted string with professor details including the course they teach
     */
    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", asignatura=" + asignatura +
                '}';
    }
}

