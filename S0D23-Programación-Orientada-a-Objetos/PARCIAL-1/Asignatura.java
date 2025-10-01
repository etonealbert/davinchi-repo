/**
 * Asignatura 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Asignatura {
    private String nombre;    
    private String codigo;  
    private int semestre;   


    public Asignatura(String nombre, String codigo, int semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
    }

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

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}

