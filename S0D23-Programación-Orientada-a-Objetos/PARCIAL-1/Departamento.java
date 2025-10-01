/**
 * Departamento (Department) class
 * Represents a university department with name, ID, and an associated professor
 * 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Departamento {
    // Instance variables (attributes of the department)
    private String nombre;      // Department name
    private String id;          // Unique identifier for the department
    private Profesor profesor;  // Professor who belongs to this department (composition relationship)

    /**
     * Constructor to create a new Departamento object
     * @param nombre - department name (local parameter)
     * @param id - unique identifier (local parameter)
     * @param profesor - professor associated with this department (local parameter)
     */
    public Departamento(String nombre, String id, Profesor profesor) {
        this.nombre = nombre;
        this.id = id;
        this.profesor = profesor;
    }

    // Getter methods
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    // Setter methods
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * Override toString to provide a nice string representation of the department
     * @return formatted string with department details including professor and their course
     */
    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", profesor=" + profesor +
                '}';
    }

    /**
     * Display complete department information in a formatted way
     * Shows the full hierarchy: Department -> Professor -> Course
     */
    public void displayInfo() {
        System.out.println("=== INFORMACIÓN DEL DEPARTAMENTO ===");
        System.out.println("Departamento: " + nombre);
        System.out.println("ID Departamento: " + id);
        System.out.println("\nProfesor asignado:");
        System.out.println("  Nombre: " + profesor.getNombre());
        System.out.println("  ID: " + profesor.getId());
        System.out.println("\nAsignatura que imparte:");
        System.out.println("  Nombre: " + profesor.getAsignatura().getNombre());
        System.out.println("  Código: " + profesor.getAsignatura().getCodigo());
        System.out.println("  Semestre: " + profesor.getAsignatura().getSemestre());
        System.out.println("====================================");
    }
}

