// FILE: PARCIAL-2/src/biblioteca/Main.java
// Autor: Albert Lukmanov - Escuela Da Vinci - Analista de Sistemas - CABA, Buenos Aires
// Descripción: Clase principal con escenarios de prueba del Sistema de Biblioteca.

package biblioteca;

import java.time.LocalDate;

/**
 * Clase Main
 * Punto de entrada del sistema de biblioteca.
 * Contiene escenarios de prueba que demuestran:
 * - Creación de objetos (autores, libros, copias, lectores)
 * - Préstamos exitosos
 * - Intento de préstamo con máximo de 3 libros alcanzado
 * - Préstamos vencidos que generan multas
 * - Intentos de préstamo con multa activa
 * - Uso de toString() para mostrar estados
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE BIBLIOTECA - PARCIAL 2                        ║");
        System.out.println("║     Escuela Da Vinci - Analista de Sistemas                  ║");
        System.out.println("║     Autor: Albert Lukmanov - CABA, Buenos Aires              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");

        // =====================================================
        // 1. CREAR LA BIBLIOTECA
        // =====================================================
        System.out.println("\n\n▶▶▶ 1. CREANDO LA BIBLIOTECA ◀◀◀");
        
        // Variable de referencia (Biblioteca) - almacena referencia a un objeto en el heap
        Biblioteca biblioteca = new Biblioteca(
            "Biblioteca Da Vinci", 
            "Av. Corrientes 2037, CABA, Buenos Aires"
        );

        // =====================================================
        // 2. CREAR AUTORES
        // =====================================================
        System.out.println("\n\n▶▶▶ 2. REGISTRANDO AUTORES ◀◀◀");
        
        // Variables de referencia (Autor) - cada una apunta a un objeto Autor en el heap
        Autor autorBorges = new Autor(
            "Jorge Luis Borges", 
            "Argentina", 
            LocalDate.of(1899, 8, 24)
        );
        
        Autor autorCortazar = new Autor(
            "Julio Cortázar", 
            "Argentina", 
            LocalDate.of(1914, 8, 26)
        );
        
        Autor autorGarciaMa = new Autor(
            "Gabriel García Márquez", 
            "Colombia", 
            LocalDate.of(1927, 3, 6)
        );
        
        Autor autorNeruda = new Autor(
            "Pablo Neruda", 
            "Chile", 
            LocalDate.of(1904, 7, 12)
        );
        
        // Constructor sobrecargado sin fecha de nacimiento
        Autor autorShakespeare = new Autor("William Shakespeare", "Inglaterra");

        // Agregar autores a la biblioteca
        biblioteca.agregarAutor(autorBorges);
        biblioteca.agregarAutor(autorCortazar);
        biblioteca.agregarAutor(autorGarciaMa);
        biblioteca.agregarAutor(autorNeruda);
        biblioteca.agregarAutor(autorShakespeare);

        // =====================================================
        // 3. CREAR LIBROS (con constructores sobrecargados)
        // =====================================================
        System.out.println("\n\n▶▶▶ 3. CATALOGANDO LIBROS ◀◀◀");
        
        // Constructor COMPLETO (sobrecarga con más parámetros)
        Libro libroFicciones = new Libro(
            "Ficciones", 
            TipoLibro.NOVELA, 
            "Editorial Sur", 
            1944, 
            autorBorges
        );
        
        Libro libroRayuela = new Libro(
            "Rayuela", 
            TipoLibro.NOVELA, 
            "Editorial Sudamericana", 
            1963, 
            autorCortazar
        );
        
        Libro libroCienAnios = new Libro(
            "Cien años de soledad", 
            TipoLibro.NOVELA, 
            "Editorial Sudamericana", 
            1967, 
            autorGarciaMa
        );
        
        // Constructor BÁSICO (sobrecarga con menos parámetros)
        Libro libroVeintePoemas = new Libro(
            "Veinte poemas de amor", 
            TipoLibro.POESIA, 
            autorNeruda
        );
        
        Libro libroHamlet = new Libro(
            "Hamlet", 
            TipoLibro.TEATRO, 
            "Editorial Penguin", 
            1603, 
            autorShakespeare
        );

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libroFicciones);
        biblioteca.agregarLibro(libroRayuela);
        biblioteca.agregarLibro(libroCienAnios);
        biblioteca.agregarLibro(libroVeintePoemas);
        biblioteca.agregarLibro(libroHamlet);

        // =====================================================
        // 4. CREAR COPIAS DE LIBROS
        // =====================================================
        System.out.println("\n\n▶▶▶ 4. AGREGANDO COPIAS FÍSICAS ◀◀◀");
        
        // Copias de Ficciones
        Copia copiaFicciones1 = new Copia("FIC-001", libroFicciones);
        Copia copiaFicciones2 = new Copia("FIC-002", libroFicciones);
        
        // Copias de Rayuela
        Copia copiaRayuela1 = new Copia("RAY-001", libroRayuela);
        Copia copiaRayuela2 = new Copia("RAY-002", libroRayuela);
        Copia copiaRayuela3 = new Copia("RAY-003", libroRayuela);
        
        // Copia de Cien años de soledad
        Copia copiaCienAnios1 = new Copia("CAS-001", libroCienAnios);
        
        // Copia de Veinte poemas
        Copia copiaVeintePoemas1 = new Copia("VPA-001", libroVeintePoemas);
        
        // Copias de Hamlet
        Copia copiaHamlet1 = new Copia("HAM-001", libroHamlet);
        Copia copiaHamlet2 = new Copia("HAM-002", libroHamlet);

        // Agregar copias a la biblioteca
        biblioteca.agregarCopia(copiaFicciones1);
        biblioteca.agregarCopia(copiaFicciones2);
        biblioteca.agregarCopia(copiaRayuela1);
        biblioteca.agregarCopia(copiaRayuela2);
        biblioteca.agregarCopia(copiaRayuela3);
        biblioteca.agregarCopia(copiaCienAnios1);
        biblioteca.agregarCopia(copiaVeintePoemas1);
        biblioteca.agregarCopia(copiaHamlet1);
        biblioteca.agregarCopia(copiaHamlet2);

        // =====================================================
        // 5. REGISTRAR LECTORES
        // =====================================================
        System.out.println("\n\n▶▶▶ 5. REGISTRANDO LECTORES ◀◀◀");
        
        // Constructor completo
        Lector lectorMessi = new Lector(
            "Lionel Messi", 
            "30456789", 
            "messi@davinci.edu.ar"
        );
        
        Lector lectorMaradona = new Lector(
            "Diego Maradona", 
            "12345678", 
            "diego@davinci.edu.ar"
        );
        
        // Constructor simplificado (sin email)
        Lector lectorAlbert = new Lector("Albert Lukmanov", "40123456");
        
        Lector lectorFavaloro = new Lector(
            "René Favaloro", 
            "08765432", 
            "favaloro@davinci.edu.ar"
        );

        // Agregar lectores a la biblioteca
        biblioteca.agregarLector(lectorMessi);
        biblioteca.agregarLector(lectorMaradona);
        biblioteca.agregarLector(lectorAlbert);
        biblioteca.agregarLector(lectorFavaloro);

        // =====================================================
        // 6. MOSTRAR ESTADO INICIAL DE LA BIBLIOTECA
        // =====================================================
        System.out.println("\n\n▶▶▶ 6. ESTADO INICIAL DE LA BIBLIOTECA ◀◀◀");
        System.out.println(biblioteca);
        
        // Mostrar libros catalogados
        biblioteca.mostrarLibros();
        
        // Mostrar lectores registrados
        biblioteca.mostrarLectores();

        // =====================================================
        // 7. ESCENARIO: PRÉSTAMOS EXITOSOS
        // =====================================================
        System.out.println("\n\n▶▶▶ 7. ESCENARIO: PRÉSTAMOS EXITOSOS ◀◀◀");
        
        // Lionel Messi pide 3 libros (el máximo permitido)
        biblioteca.realizarPrestamo(copiaFicciones1, lectorMessi);
        biblioteca.realizarPrestamo(copiaRayuela1, lectorMessi);
        biblioteca.realizarPrestamo(copiaCienAnios1, lectorMessi);

        // Albert pide 1 libro
        biblioteca.realizarPrestamo(copiaHamlet1, lectorAlbert);

        // =====================================================
        // 8. ESCENARIO: INTENTO DE PRÉSTAMO CON MÁXIMO ALCANZADO
        // =====================================================
        System.out.println("\n\n▶▶▶ 8. ESCENARIO: INTENTO CON MÁXIMO DE 3 LIBROS ◀◀◀");
        System.out.println("Messi intenta pedir un 4to libro (debe fallar)...");
        
        // Este préstamo debe fallar porque Messi ya tiene 3 libros
        Prestamo prestamoFallido = biblioteca.realizarPrestamo(copiaVeintePoemas1, lectorMessi);
        
        if (prestamoFallido == null) {
            System.out.println("✗ Confirmado: El préstamo fue rechazado correctamente.");
        }

        // =====================================================
        // 9. MOSTRAR ESTADO DESPUÉS DE PRÉSTAMOS
        // =====================================================
        System.out.println("\n\n▶▶▶ 9. ESTADO DESPUÉS DE PRÉSTAMOS ◀◀◀");
        System.out.println(biblioteca);
        biblioteca.mostrarPrestamosActivos();
        biblioteca.mostrarLectores();

        // =====================================================
        // 10. ESCENARIO: PRÉSTAMO VENCIDO (simulando fecha pasada)
        // =====================================================
        System.out.println("\n\n▶▶▶ 10. ESCENARIO: PRÉSTAMO VENCIDO (MULTA) ◀◀◀");
        System.out.println("Simulando un préstamo realizado hace 45 días (vencido)...");
        
        // Variable primitiva (int) - días en el pasado
        int diasEnPasado = 45;
        
        // Variable de referencia (LocalDate) - fecha de inicio simulada
        LocalDate fechaAntigua = LocalDate.now().minusDays(diasEnPasado);
        
        // Diego Maradona pide un libro con fecha antigua (simulando préstamo vencido)
        Prestamo prestamoVencido = biblioteca.realizarPrestamo(
            copiaRayuela2, 
            lectorMaradona, 
            fechaAntigua
        );
        
        // Verificar si está vencido
        if (prestamoVencido != null) {
            System.out.println("\nVerificando estado del préstamo:");
            System.out.println("  Días de préstamo: " + prestamoVencido.calcularDiasPrestamo());
            System.out.println("  ¿Está vencido?: " + (prestamoVencido.estaVencido() ? "SÍ" : "NO"));
            System.out.println("  Días de exceso: " + (prestamoVencido.calcularDiasPrestamo() - Prestamo.DIAS_MAXIMOS_PRESTAMO));
        }
        
        // Verificar y aplicar multas
        biblioteca.verificarMultas();

        // =====================================================
        // 11. ESCENARIO: INTENTO DE PRÉSTAMO CON MULTA ACTIVA
        // =====================================================
        System.out.println("\n\n▶▶▶ 11. ESCENARIO: INTENTO CON MULTA ACTIVA ◀◀◀");
        System.out.println("Maradona (con multa) intenta pedir otro libro...");
        
        // Este préstamo debe fallar porque Maradona tiene multa
        Prestamo prestamoConMulta = biblioteca.realizarPrestamo(copiaFicciones2, lectorMaradona);
        
        if (prestamoConMulta == null) {
            System.out.println("✗ Confirmado: El préstamo fue rechazado por multa activa.");
        }

        // =====================================================
        // 12. ESCENARIO: REGULARIZAR MULTA Y VOLVER A PRESTAR
        // =====================================================
        System.out.println("\n\n▶▶▶ 12. ESCENARIO: REGULARIZAR MULTA ◀◀◀");
        System.out.println("Maradona regulariza su multa (simula pago)...");
        
        lectorMaradona.regularizarMulta();
        
        System.out.println("\nMaradona intenta pedir un libro después de regularizar...");
        Prestamo prestamoPostMulta = biblioteca.realizarPrestamo(copiaFicciones2, lectorMaradona);
        
        if (prestamoPostMulta != null) {
            System.out.println("✓ Confirmado: El préstamo fue exitoso después de regularizar.");
        }

        // =====================================================
        // 13. ESCENARIO: DEVOLUCIÓN DE LIBROS
        // =====================================================
        System.out.println("\n\n▶▶▶ 13. ESCENARIO: DEVOLUCIÓN DE LIBROS ◀◀◀");
        
        // Obtener el primer préstamo de Messi y devolverlo
        if (!lectorMessi.getPrestamosActivos().isEmpty()) {
            Prestamo primerPrestamoMessi = lectorMessi.getPrestamosActivos().get(0);
            System.out.println("Messi devuelve: " + primerPrestamoMessi.getCopia().getLibro().getNombre());
            biblioteca.registrarDevolucion(primerPrestamoMessi);
        }

        // =====================================================
        // 14. DEMOSTRACIÓN DE MÉTODOS SOBRECARGADOS (Búsqueda)
        // =====================================================
        System.out.println("\n\n▶▶▶ 14. DEMOSTRACIÓN: MÉTODOS SOBRECARGADOS ◀◀◀");
        
        // Búsqueda por nombre (String)
        System.out.println("\n--- Búsqueda por nombre: 'Rayuela' ---");
        for (Libro libro : biblioteca.buscarLibros("Rayuela")) {
            System.out.println("  Encontrado: " + libro);
        }
        
        // Búsqueda por autor (Autor)
        System.out.println("\n--- Búsqueda por autor: Borges ---");
        for (Libro libro : biblioteca.buscarLibros(autorBorges)) {
            System.out.println("  Encontrado: " + libro);
        }
        
        // Búsqueda por tipo (TipoLibro)
        System.out.println("\n--- Búsqueda por tipo: NOVELA ---");
        for (Libro libro : biblioteca.buscarLibros(TipoLibro.NOVELA)) {
            System.out.println("  Encontrado: " + libro);
        }

        // =====================================================
        // 15. ESTADO FINAL DE LA BIBLIOTECA
        // =====================================================
        System.out.println("\n\n▶▶▶ 15. ESTADO FINAL DE LA BIBLIOTECA ◀◀◀");
        System.out.println(biblioteca);
        biblioteca.mostrarPrestamosActivos();
        biblioteca.mostrarLectores();

        // =====================================================
        // 16. DEMOSTRACIÓN DE toString() EN OBJETOS INDIVIDUALES
        // =====================================================
        System.out.println("\n\n▶▶▶ 16. DEMOSTRACIÓN: toString() DE OBJETOS ◀◀◀");
        
        System.out.println("\n--- Autor ---");
        System.out.println(autorBorges);
        
        System.out.println("\n--- Libro ---");
        System.out.println(libroFicciones);
        
        System.out.println("\n--- Copia ---");
        System.out.println(copiaFicciones1);
        
        System.out.println("\n--- Lector ---");
        System.out.println(lectorMessi);
        
        System.out.println("\n--- Préstamo ---");
        if (!biblioteca.getPrestamos().isEmpty()) {
            System.out.println(biblioteca.getPrestamos().get(0));
        }

        // =====================================================
        // FIN DEL PROGRAMA
        // =====================================================
        System.out.println("\n\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     FIN DE LA DEMOSTRACIÓN                                   ║");
        System.out.println("║     Sistema de Biblioteca - Parcial 2                        ║");
        System.out.println("║     Albert Lukmanov - Escuela Da Vinci                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}

