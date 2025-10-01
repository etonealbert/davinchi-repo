/**
 * Departamento
 * 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Departamento {
    private String nombre;    
    private String id;        
    private Profesor profesor;

    public Departamento(String nombre, String id, Profesor profesor) {
        this.nombre = nombre;
        this.id = id;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", profesor=" + profesor +
                '}';
    }

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

