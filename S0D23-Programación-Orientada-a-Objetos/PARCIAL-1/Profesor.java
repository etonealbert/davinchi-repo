/**
 * Profesor 
 * 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Profesor {
    private String nombre;     
    private String id;           
    private Asignatura asignatura;

    public Profesor(String nombre, String id, Asignatura asignatura) {
        this.nombre = nombre;
        this.id = id;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", asignatura=" + asignatura +
                '}';
    }
}

