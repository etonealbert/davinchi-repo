// FILE: PARCIAL-2/src/biblioteca/Lector.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Clase que representa a un lector/usuario de la biblioteca.

package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Lector
 * Representa a una persona que puede solicitar préstamos de libros.
 * Implementa las reglas de negocio:
 * - Máximo 3 libros prestados simultáneamente.
 * - No puede pedir préstamos si tiene multa activa.
 * Demuestra el uso de:
 * - Encapsulamiento
 * - Colecciones (List/ArrayList)
 * - Variables primitivas y de referencia
 * - Reglas de negocio en métodos
 */
public class Lector {

    // =====================================================
    // CONSTANTES
    // =====================================================

    // Variable primitiva (int) - constante que define el máximo de préstamos permitidos
    // Se almacena directamente en la pila (stack) y es compartida por todas las instancias
    public static final int MAXIMO_PRESTAMOS = 3;

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================

    // Variable de referencia (String) - almacena una referencia a un objeto String en el heap
    private String nombre;

    // Variable de referencia (String) - DNI del lector como String para mantener ceros a la izquierda
    private String dni;

    // Variable de referencia (String) - correo electrónico del lector
    private String email;

    // Variable de referencia (List<Prestamo>) - lista de préstamos activos del lector
    // Almacena referencias a objetos Prestamo en el heap
    private List<Prestamo> prestamosActivos;

    // Variable PRIMITIVA (boolean) - indica si el lector tiene multa pendiente
    // Los tipos primitivos como boolean almacenan el valor directamente (true/false)
    private boolean tieneMulta;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================

    /**
     * Constructor completo de Lector.
     * @param nombre Nombre completo del lector.
     * @param dni Documento Nacional de Identidad.
     * @param email Correo electrónico.
     */
    public Lector(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.prestamosActivos = new ArrayList<>();
        this.tieneMulta = false;
    }

    /**
     * Constructor simplificado sin email.
     * @param nombre Nombre completo del lector.
     * @param dni Documento Nacional de Identidad.
     */
    public Lector(String nombre, String dni) {
        this(nombre, dni, "No especificado");
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    /**
     * Obtiene el nombre del lector.
     * @return Nombre del lector.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del lector.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI del lector.
     * @return DNI del lector.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del lector.
     * @param dni Nuevo DNI.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el email del lector.
     * @return Email del lector.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del lector.
     * @param email Nuevo email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Verifica si el lector tiene multa activa.
     * @return true si tiene multa, false en caso contrario.
     */
    public boolean getTieneMulta() {
        return tieneMulta;
    }

    /**
     * Establece el estado de multa del lector.
     * @param tieneMulta Nuevo estado de multa.
     */
    public void setTieneMulta(boolean tieneMulta) {
        this.tieneMulta = tieneMulta;
    }

    /**
     * Obtiene la lista de préstamos activos.
     * @return Lista de préstamos activos.
     */
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    // =====================================================
    // MÉTODOS DE DOMINIO (Reglas de Negocio)
    // =====================================================

    /**
     * Cuenta la cantidad de préstamos activos del lector.
     * @return Número de préstamos activos.
     */
    public int cantidadPrestamosActivos() {
        // Variable primitiva (int) - almacena directamente el resultado
        int cantidad = 0;
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.estaActivo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Verifica si el lector puede solicitar un nuevo préstamo.
     * Reglas:
     * 1. No debe tener multa activa.
     * 2. No debe tener más de 3 préstamos activos.
     * @return true si puede pedir préstamo, false en caso contrario.
     */
    public boolean puedePrestar() {
        // Verificar si tiene multa
        if (tieneMulta) {
            return false;
        }
        // Verificar si no excede el máximo de préstamos
        return cantidadPrestamosActivos() < MAXIMO_PRESTAMOS;
    }

    /**
     * Agrega un préstamo a la lista de préstamos activos del lector.
     * @param prestamo Préstamo a agregar.
     * @return true si se agregó correctamente, false si no pudo agregarse.
     */
    public boolean agregarPrestamo(Prestamo prestamo) {
        if (prestamo != null && !prestamosActivos.contains(prestamo)) {
            prestamosActivos.add(prestamo);
            return true;
        }
        return false;
    }

    /**
     * Quita un préstamo de la lista de préstamos activos.
     * @param prestamo Préstamo a quitar.
     * @return true si se quitó correctamente, false si no estaba en la lista.
     */
    public boolean quitarPrestamo(Prestamo prestamo) {
        return prestamosActivos.remove(prestamo);
    }

    /**
     * Regulariza la situación del lector (quita la multa).
     * Simula el pago de la multa.
     */
    public void regularizarMulta() {
        this.tieneMulta = false;
        System.out.println(">>> Multa regularizada para el lector: " + nombre);
    }

    /**
     * Aplica una multa al lector.
     */
    public void aplicarMulta() {
        this.tieneMulta = true;
        System.out.println(">>> MULTA aplicada al lector: " + nombre);
    }

    /**
     * Verifica si alguno de los préstamos está vencido y aplica multa si corresponde.
     * @return true si se aplicó multa, false si no había préstamos vencidos.
     */
    public boolean verificarPrestamosVencidos() {
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.estaVencido()) {
                aplicarMulta();
                return true;
            }
        }
        return false;
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================

    /**
     * Devuelve una representación en texto del lector.
     * @return Cadena con los datos del lector.
     */
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

