// Autor: Albert Lukmanov
// Descripción: Clase que representa a un lector/usuario de la biblioteca.

package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Lector {

    public static final int MAXIMO_PRESTAMOS = 3;

    private String nombre;
    private String dni;
    private String email;
    private List<Prestamo> prestamosActivos;
    private boolean tieneMulta;

    public Lector(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.prestamosActivos = new ArrayList<>();
        this.tieneMulta = false;
    }

    public Lector(String nombre, String dni) {
        this(nombre, dni, "No especificado");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getTieneMulta() {
        return tieneMulta;
    }

    public void setTieneMulta(boolean tieneMulta) {
        this.tieneMulta = tieneMulta;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public int cantidadPrestamosActivos() {
        int cantidad = 0;
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.estaActivo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public boolean puedePrestar() {
        if (tieneMulta) {
            return false;
        }
        return cantidadPrestamosActivos() < MAXIMO_PRESTAMOS;
    }

    public boolean agregarPrestamo(Prestamo prestamo) {
        if (prestamo != null && !prestamosActivos.contains(prestamo)) {
            prestamosActivos.add(prestamo);
            return true;
        }
        return false;
    }

    public boolean quitarPrestamo(Prestamo prestamo) {
        return prestamosActivos.remove(prestamo);
    }

    public void regularizarMulta() {
        this.tieneMulta = false;
        System.out.println(">>> Multa regularizada para el lector: " + nombre);
    }

    public void aplicarMulta() {
        this.tieneMulta = true;
        System.out.println(">>> MULTA aplicada al lector: " + nombre);
    }

    public boolean verificarPrestamosVencidos() {
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.estaVencido()) {
                aplicarMulta();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String estadoMulta = tieneMulta ? "SÍ (NO puede pedir préstamos)" : "NO";
        
        return "Lector{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", prestamosActivos=" + cantidadPrestamosActivos() +
                ", tieneMulta=" + estadoMulta +
                '}';
    }
}