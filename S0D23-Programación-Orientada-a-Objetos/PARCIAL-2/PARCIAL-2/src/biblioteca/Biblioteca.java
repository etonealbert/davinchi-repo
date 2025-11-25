// FILE: PARCIAL-2/src/biblioteca/Biblioteca.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Clase principal que coordina todas las operaciones de la biblioteca.

package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Biblioteca
 * Es la clase coordinadora/controladora del sistema.
 * Administra las colecciones de autores, libros, copias, lectores y préstamos.
 * Implementa las reglas de negocio del sistema de biblioteca.
 * Demuestra el uso de:
 * - Encapsulamiento
 * - Colecciones múltiples (List/ArrayList)
 * - Métodos sobrecargados (overloading) en buscarLibros()
 * - Coordinación de objetos
 */
public class Biblioteca {

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================

    // Variable de referencia (String) - nombre de la biblioteca
    private String nombre;

    // Variable de referencia (String) - dirección de la biblioteca
    private String direccion;

    // Variable de referencia (List<Autor>) - colección de autores registrados
    // Almacena referencias a objetos Autor en el heap
    private List<Autor> autores;

    // Variable de referencia (List<Libro>) - colección de libros catalogados
    private List<Libro> libros;

    // Variable de referencia (List<Copia>) - colección de copias físicas
    private List<Copia> copias;

    // Variable de referencia (List<Lector>) - colección de lectores registrados
    private List<Lector> lectores;

    // Variable de referencia (List<Prestamo>) - colección de todos los préstamos (histórico)
    private List<Prestamo> prestamos;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================

    /**
     * Constructor completo de Biblioteca.
     * @param nombre Nombre de la biblioteca.
     * @param direccion Dirección física de la biblioteca.
     */
    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.autores = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.copias = new ArrayList<>();
        this.lectores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    /**
     * Constructor simplificado.
     * @param nombre Nombre de la biblioteca.
     */
    public Biblioteca(String nombre) {
        this(nombre, "Sin dirección especificada");
    }

    // =====================================================
    // GETTERS
    // =====================================================

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Copia> getCopias() {
        return copias;
    }

    public List<Lector> getLectores() {
        return lectores;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    // =====================================================
    // MÉTODOS DE ALTA (Agregar elementos)
    // =====================================================

    /**
     * Agrega un autor al catálogo de la biblioteca.
     * @param autor Autor a agregar.
     * @return true si se agregó correctamente.
     */
    public boolean agregarAutor(Autor autor) {
        if (autor != null && !autores.contains(autor)) {
            autores.add(autor);
            System.out.println(">>> Autor agregado: " + autor.getNombre());
            return true;
        }
        return false;
    }

    /**
     * Agrega un libro al catálogo de la biblioteca.
     * @param libro Libro a agregar.
     * @return true si se agregó correctamente.
     */
    public boolean agregarLibro(Libro libro) {
        if (libro != null && !libros.contains(libro)) {
            libros.add(libro);
            System.out.println(">>> Libro agregado: " + libro.getNombre());
            return true;
        }
        return false;
    }

    /**
     * Agrega una copia física a la biblioteca.
     * @param copia Copia a agregar.
     * @return true si se agregó correctamente.
     */
    public boolean agregarCopia(Copia copia) {
        if (copia != null && !copias.contains(copia)) {
            copias.add(copia);
            System.out.println(">>> Copia agregada: " + copia.getIdentificador() + 
                    " del libro '" + copia.getLibro().getNombre() + "'");
            return true;
        }
        return false;
    }

    /**
     * Registra un nuevo lector en la biblioteca.
     * @param lector Lector a registrar.
     * @return true si se registró correctamente.
     */
    public boolean agregarLector(Lector lector) {
        if (lector != null && !lectores.contains(lector)) {
            lectores.add(lector);
            System.out.println(">>> Lector registrado: " + lector.getNombre());
            return true;
        }
        return false;
    }

    // =====================================================
    // MÉTODOS SOBRECARGADOS (Overloading) - Búsqueda de libros
    // =====================================================

    /**
     * Busca libros por nombre (título).
     * MÉTODO SOBRECARGADO - versión con String.
     * @param nombreLibro Nombre o parte del nombre del libro.
     * @return Lista de libros que coinciden.
     */
    public List<Libro> buscarLibros(String nombreLibro) {
        // Variable de referencia (List<Libro>) - nueva lista para resultados
        List<Libro> resultados = new ArrayList<>();
        
        for (Libro libro : libros) {
            // Búsqueda insensible a mayúsculas/minúsculas
            if (libro.getNombre().toLowerCase().contains(nombreLibro.toLowerCase())) {
                resultados.add(libro);
            }
        }
        
        return resultados;
    }

    /**
     * Busca libros por autor.
     * MÉTODO SOBRECARGADO - versión con Autor.
     * @param autor Autor cuyos libros se buscan.
     * @return Lista de libros del autor.
     */
    public List<Libro> buscarLibros(Autor autor) {
        // Variable de referencia (List<Libro>) - nueva lista para resultados
        List<Libro> resultados = new ArrayList<>();
        
        for (Libro libro : libros) {
            if (libro.getAutor() != null && libro.getAutor().equals(autor)) {
                resultados.add(libro);
            }
        }
        
        return resultados;
    }

    /**
     * Busca libros por tipo.
     * MÉTODO SOBRECARGADO - versión con TipoLibro.
     * @param tipo Tipo de libro (NOVELA, TEATRO, POESIA).
     * @return Lista de libros de ese tipo.
     */
    public List<Libro> buscarLibros(TipoLibro tipo) {
        // Variable de referencia (List<Libro>) - nueva lista para resultados
        List<Libro> resultados = new ArrayList<>();
        
        for (Libro libro : libros) {
            if (libro.getTipo() == tipo) {
                resultados.add(libro);
            }
        }
        
        return resultados;
    }

    // =====================================================
    // MÉTODOS DE PRÉSTAMO Y DEVOLUCIÓN
    // =====================================================

    /**
     * Realiza un préstamo de una copia a un lector.
     * Valida las reglas de negocio:
     * - El lector no debe tener multa.
     * - El lector no debe tener más de 3 préstamos activos.
     * - La copia debe estar disponible.
     * @param copia Copia a prestar.
     * @param lector Lector que solicita el préstamo.
     * @return El préstamo creado o null si no se pudo realizar.
     */
    public Prestamo realizarPrestamo(Copia copia, Lector lector) {
        System.out.println("\n--- Intentando préstamo ---");
        System.out.println("Libro: " + copia.getLibro().getNombre());
        System.out.println("Copia: " + copia.getIdentificador());
        System.out.println("Lector: " + lector.getNombre());

        // Validar que el lector pueda pedir préstamos
        if (!lector.puedePrestar()) {
            if (lector.getTieneMulta()) {
                System.out.println("ERROR: El lector tiene MULTA activa. No puede solicitar préstamos.");
            } else {
                System.out.println("ERROR: El lector ya tiene " + Lector.MAXIMO_PRESTAMOS + 
                        " préstamos activos. No puede solicitar más.");
            }
            return null;
        }

        // Validar que la copia esté disponible
        if (!copia.estaDisponible()) {
            System.out.println("ERROR: La copia no está disponible, ya está prestada.");
            return null;
        }

        // Crear el préstamo
        Prestamo nuevoPrestamo = new Prestamo(copia, lector);
        
        // Actualizar estados
        copia.prestar();
        lector.agregarPrestamo(nuevoPrestamo);
        prestamos.add(nuevoPrestamo);

        System.out.println("ÉXITO: Préstamo realizado correctamente.");
        System.out.println("Fecha límite de devolución: " + nuevoPrestamo.getFechaLimite());
        
        return nuevoPrestamo;
    }

    /**
     * Realiza un préstamo con fecha de inicio personalizada (para pruebas).
     * @param copia Copia a prestar.
     * @param lector Lector que solicita el préstamo.
     * @param fechaInicio Fecha de inicio del préstamo.
     * @return El préstamo creado o null si no se pudo realizar.
     */
    public Prestamo realizarPrestamo(Copia copia, Lector lector, LocalDate fechaInicio) {
        System.out.println("\n--- Intentando préstamo (con fecha personalizada) ---");
        System.out.println("Libro: " + copia.getLibro().getNombre());
        System.out.println("Copia: " + copia.getIdentificador());
        System.out.println("Lector: " + lector.getNombre());
        System.out.println("Fecha inicio: " + fechaInicio);

        // Validar que el lector pueda pedir préstamos
        if (!lector.puedePrestar()) {
            if (lector.getTieneMulta()) {
                System.out.println("ERROR: El lector tiene MULTA activa. No puede solicitar préstamos.");
            } else {
                System.out.println("ERROR: El lector ya tiene " + Lector.MAXIMO_PRESTAMOS + 
                        " préstamos activos. No puede solicitar más.");
            }
            return null;
        }

        // Validar que la copia esté disponible
        if (!copia.estaDisponible()) {
            System.out.println("ERROR: La copia no está disponible, ya está prestada.");
            return null;
        }

        // Crear el préstamo con fecha personalizada
        Prestamo nuevoPrestamo = new Prestamo(copia, lector, fechaInicio);
        
        // Actualizar estados
        copia.prestar();
        lector.agregarPrestamo(nuevoPrestamo);
        prestamos.add(nuevoPrestamo);

        System.out.println("ÉXITO: Préstamo realizado correctamente.");
        System.out.println("Fecha límite de devolución: " + nuevoPrestamo.getFechaLimite());
        
        return nuevoPrestamo;
    }

    /**
     * Registra la devolución de un préstamo.
     * Verifica si hay multa por devolución tardía.
     * @param prestamo Préstamo a devolver.
     * @return true si se registró la devolución, false si ya estaba devuelto.
     */
    public boolean registrarDevolucion(Prestamo prestamo) {
        System.out.println("\n--- Registrando devolución ---");
        System.out.println("Préstamo: " + prestamo.getCopia().getIdentificador());
        System.out.println("Lector: " + prestamo.getLector().getNombre());

        if (!prestamo.estaActivo()) {
            System.out.println("ERROR: Este préstamo ya fue devuelto anteriormente.");
            return false;
        }

        // Verificar si está vencido antes de devolver
        // Variable primitiva (boolean) - almacena directamente el resultado
        boolean estabaVencido = prestamo.estaVencido();

        // Registrar la devolución
        prestamo.registrarDevolucion();

        // Quitar el préstamo de la lista de activos del lector
        prestamo.getLector().quitarPrestamo(prestamo);

        System.out.println("ÉXITO: Devolución registrada.");
        System.out.println("Días de préstamo: " + prestamo.calcularDiasPrestamo());

        // Si estaba vencido, aplicar multa
        if (estabaVencido) {
            System.out.println("ADVERTENCIA: El préstamo estaba VENCIDO.");
            prestamo.getLector().aplicarMulta();
        }

        return true;
    }

    /**
     * Verifica todos los préstamos activos y aplica multas a los vencidos.
     */
    public void verificarMultas() {
        System.out.println("\n--- Verificando préstamos vencidos ---");
        
        // Variable primitiva (int) - contador de multas aplicadas
        int multasAplicadas = 0;
        
        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaActivo() && prestamo.estaVencido()) {
                Lector lector = prestamo.getLector();
                if (!lector.getTieneMulta()) {
                    lector.aplicarMulta();
                    multasAplicadas++;
                }
            }
        }
        
        System.out.println("Total de multas aplicadas: " + multasAplicadas);
    }

    /**
     * Obtiene la lista de préstamos activos.
     * @return Lista de préstamos que aún no fueron devueltos.
     */
    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> activos = new ArrayList<>();
        
        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaActivo()) {
                activos.add(prestamo);
            }
        }
        
        return activos;
    }

    /**
     * Obtiene la lista de préstamos vencidos.
     * @return Lista de préstamos que superaron los 30 días.
     */
    public List<Prestamo> obtenerPrestamosVencidos() {
        List<Prestamo> vencidos = new ArrayList<>();
        
        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaVencido()) {
                vencidos.add(prestamo);
            }
        }
        
        return vencidos;
    }

    // =====================================================
    // MÉTODOS DE ESTADÍSTICAS
    // =====================================================

    /**
     * Cuenta el total de copias disponibles en la biblioteca.
     * @return Número de copias disponibles.
     */
    public int contarCopiasDisponibles() {
        // Variable primitiva (int) - contador almacenado directamente
        int contador = 0;
        for (Copia copia : copias) {
            if (copia.estaDisponible()) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Cuenta el total de copias prestadas.
     * @return Número de copias en préstamo.
     */
    public int contarCopiasPrestadas() {
        return copias.size() - contarCopiasDisponibles();
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================

    /**
     * Devuelve una representación en texto del estado de la biblioteca.
     * @return Cadena con el resumen de la biblioteca.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========================================\n");
        sb.append("BIBLIOTECA: ").append(nombre).append("\n");
        sb.append("Dirección: ").append(direccion).append("\n");
        sb.append("========================================\n");
        sb.append("Estadísticas:\n");
        sb.append("  - Autores registrados: ").append(autores.size()).append("\n");
        sb.append("  - Libros catalogados: ").append(libros.size()).append("\n");
        sb.append("  - Copias totales: ").append(copias.size()).append("\n");
        sb.append("  - Copias disponibles: ").append(contarCopiasDisponibles()).append("\n");
        sb.append("  - Copias prestadas: ").append(contarCopiasPrestadas()).append("\n");
        sb.append("  - Lectores registrados: ").append(lectores.size()).append("\n");
        sb.append("  - Préstamos totales (histórico): ").append(prestamos.size()).append("\n");
        sb.append("  - Préstamos activos: ").append(obtenerPrestamosActivos().size()).append("\n");
        sb.append("  - Préstamos vencidos: ").append(obtenerPrestamosVencidos().size()).append("\n");
        sb.append("========================================\n");
        
        return sb.toString();
    }

    /**
     * Muestra el detalle de todos los préstamos activos.
     */
    public void mostrarPrestamosActivos() {
        System.out.println("\n=== PRÉSTAMOS ACTIVOS ===");
        List<Prestamo> activos = obtenerPrestamosActivos();
        
        if (activos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
        } else {
            for (Prestamo prestamo : activos) {
                System.out.println(prestamo);
            }
        }
    }

    /**
     * Muestra el detalle de todos los lectores.
     */
    public void mostrarLectores() {
        System.out.println("\n=== LECTORES REGISTRADOS ===");
        
        if (lectores.isEmpty()) {
            System.out.println("No hay lectores registrados.");
        } else {
            for (Lector lector : lectores) {
                System.out.println(lector);
            }
        }
    }

    /**
     * Muestra el detalle de todos los libros.
     */
    public void mostrarLibros() {
        System.out.println("\n=== LIBROS CATALOGADOS ===");
        
        if (libros.isEmpty()) {
            System.out.println("No hay libros catalogados.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}

