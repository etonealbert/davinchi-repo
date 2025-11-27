// Autor: Albert Lukmanov - Escuela Da Vinci
// Descripción: Clase principal que coordina todas las operaciones de la biblioteca.

package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    // =====================================================
    // ATRIBUTOS PRIVADOS (Encapsulamiento)
    // =====================================================
    private String nombre;

    private String direccion;

    private List<Autor> autores;

    private List<Libro> libros;

    private List<Copia> copias;

    private List<Lector> lectores;

    private List<Prestamo> prestamos;

    // =====================================================
    // CONSTRUCTORES
    // =====================================================

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.autores = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.copias = new ArrayList<>();
        this.lectores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

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

    public boolean agregarAutor(Autor autor) {
        if (autor != null && !autores.contains(autor)) {
            autores.add(autor);
            System.out.println(">>> Autor agregado: " + autor.getNombre());
            return true;
        }
        return false;
    }

    public boolean agregarLibro(Libro libro) {
        if (libro != null && !libros.contains(libro)) {
            libros.add(libro);
            System.out.println(">>> Libro agregado: " + libro.getNombre());
            return true;
        }
        return false;
    }

    public boolean agregarCopia(Copia copia) {
        if (copia != null && !copias.contains(copia)) {
            copias.add(copia);
            System.out.println(">>> Copia agregada: " + copia.getIdentificador() + 
                    " del libro '" + copia.getLibro().getNombre() + "'");
            return true;
        }
        return false;
    }

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

    public List<Libro> buscarLibros(TipoLibro tipo) {
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

    public Prestamo realizarPrestamo(Copia copia, Lector lector) {
        System.out.println("\n--- Intentando préstamo ---");
        System.out.println("Libro: " + copia.getLibro().getNombre());
        System.out.println("Copia: " + copia.getIdentificador());
        System.out.println("Lector: " + lector.getNombre());

        if (!lector.puedePrestar()) {
            if (lector.getTieneMulta()) {
                System.out.println("ERROR: El lector tiene MULTA activa. No puede solicitar préstamos.");
            } else {
                System.out.println("ERROR: El lector ya tiene " + Lector.MAXIMO_PRESTAMOS + 
                        " préstamos activos. No puede solicitar más.");
            }
            return null;
        }

        if (!copia.estaDisponible()) {
            System.out.println("ERROR: La copia no está disponible, ya está prestada.");
            return null;
        }

        Prestamo nuevoPrestamo = new Prestamo(copia, lector);
        
        copia.prestar();
        lector.agregarPrestamo(nuevoPrestamo);
        prestamos.add(nuevoPrestamo);

        System.out.println("ÉXITO: Préstamo realizado correctamente.");
        System.out.println("Fecha límite de devolución: " + nuevoPrestamo.getFechaLimite());
        
        return nuevoPrestamo;
    }

    public Prestamo realizarPrestamo(Copia copia, Lector lector, LocalDate fechaInicio) {
        System.out.println("\n--- Intentando préstamo (con fecha personalizada) ---");
        System.out.println("Libro: " + copia.getLibro().getNombre());
        System.out.println("Copia: " + copia.getIdentificador());
        System.out.println("Lector: " + lector.getNombre());
        System.out.println("Fecha inicio: " + fechaInicio);

        if (!lector.puedePrestar()) {
            if (lector.getTieneMulta()) {
                System.out.println("ERROR: El lector tiene MULTA activa. No puede solicitar préstamos.");
            } else {
                System.out.println("ERROR: El lector ya tiene " + Lector.MAXIMO_PRESTAMOS + 
                        " préstamos activos. No puede solicitar más.");
            }
            return null;
        }

        if (!copia.estaDisponible()) {
            System.out.println("ERROR: La copia no está disponible, ya está prestada.");
            return null;
        }

        Prestamo nuevoPrestamo = new Prestamo(copia, lector, fechaInicio);
        
        copia.prestar();
        lector.agregarPrestamo(nuevoPrestamo);
        prestamos.add(nuevoPrestamo);

        System.out.println("ÉXITO: Préstamo realizado correctamente.");
        System.out.println("Fecha límite de devolución: " + nuevoPrestamo.getFechaLimite());
        
        return nuevoPrestamo;
    }

    public boolean registrarDevolucion(Prestamo prestamo) {
        System.out.println("\n--- Registrando devolución ---");
        System.out.println("Préstamo: " + prestamo.getCopia().getIdentificador());
        System.out.println("Lector: " + prestamo.getLector().getNombre());

        if (!prestamo.estaActivo()) {
            System.out.println("ERROR: Este préstamo ya fue devuelto anteriormente.");
            return false;
        }

        boolean estabaVencido = prestamo.estaVencido();

        prestamo.registrarDevolucion();

        prestamo.getLector().quitarPrestamo(prestamo);

        System.out.println("ÉXITO: Devolución registrada.");
        System.out.println("Días de préstamo: " + prestamo.calcularDiasPrestamo());

        if (estabaVencido) {
            System.out.println("ADVERTENCIA: El préstamo estaba VENCIDO.");
            prestamo.getLector().aplicarMulta();
        }

        return true;
    }

    public void verificarMultas() {
        System.out.println("\n--- Verificando préstamos vencidos ---");
        
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

    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> activos = new ArrayList<>();
        
        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaActivo()) {
                activos.add(prestamo);
            }
        }
        
        return activos;
    }

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
    public int contarCopiasDisponibles() {
        int contador = 0;
        for (Copia copia : copias) {
            if (copia.estaDisponible()) {
                contador++;
            }
        }
        return contador;
    }

    public int contarCopiasPrestadas() {
        return copias.size() - contarCopiasDisponibles();
    }

    // =====================================================
    // SOBRESCRITURA DE toString()
    // =====================================================

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

