import java.util.Scanner;
import java.util.Random;

/**
 * Programa para manejar las calificaciones de 10 estudiantes
 * utilizando arreglos paralelos.
 * 
 * Funcionalidades:
 * - Entrada manual de nombres de estudiantes
 * - Generación aleatoria de calificaciones
 * - Cálculo de estadísticas (aprobados, promovidos, reprobados)
 * - Identificación de la calificación más alta
 * - Cálculo del promedio general
 * 
 * @author Albert Lukmanov
 * @version 1.0
 */
public class CalificacionesEstudiantes {
    
    // Constantes del programa
    private static final int CANTIDAD_ESTUDIANTES = 10;
    private static final double NOTA_MINIMA_APROBADO = 4.0;
    private static final double NOTA_MINIMA_PROMOVIDO = 7.0;
    private static final double NOTA_MINIMA = 1.0;
    private static final double NOTA_MAXIMA = 10.0;
    
    public static void main(String[] args) {
        
        // Declaración de arreglos paralelos
        String[] nombresEstudiantes = new String[CANTIDAD_ESTUDIANTES];
        double[] calificacionesEstudiantes = new double[CANTIDAD_ESTUDIANTES];
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("=== SISTEMA DE CALIFICACIONES DE ESTUDIANTES ===");
        System.out.println();
        
        // Entrada manual de nombres de estudiantes
        ingresarNombresEstudiantes(scanner, nombresEstudiantes);
        
        // Generación aleatoria de calificaciones
        generarCalificacionesAleatorias(random, calificacionesEstudiantes);
        
        // Mostrar información de todos los estudiantes
        mostrarInformacionEstudiantes(nombresEstudiantes, calificacionesEstudiantes);
        
        // Calcular y mostrar estadísticas
        calcularYMostrarEstadisticas(nombresEstudiantes, calificacionesEstudiantes);
        
        scanner.close();
    }
    
    /**
     * Método para ingresar manualmente los nombres de los estudiantes
     * @param scanner Objeto Scanner para entrada de datos
     * @param nombres Arreglo donde se almacenarán los nombres
     */
    private static void ingresarNombresEstudiantes(Scanner scanner, String[] nombres) {
        System.out.println("--- INGRESO DE NOMBRES DE ESTUDIANTES ---");
        for (int i = 0; i < CANTIDAD_ESTUDIANTES; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }
        System.out.println();
    }
    
    /**
     * Método para generar calificaciones aleatorias
     * @param random Objeto Random para generación de números aleatorios
     * @param calificaciones Arreglo donde se almacenarán las calificaciones
     */
    private static void generarCalificacionesAleatorias(Random random, double[] calificaciones) {
        System.out.println("--- GENERANDO CALIFICACIONES ALEATORIAS ---");
        for (int i = 0; i < CANTIDAD_ESTUDIANTES; i++) {
            // Generar calificación aleatoria entre 1.0 y 10.0
            calificaciones[i] = NOTA_MINIMA + (NOTA_MAXIMA - NOTA_MINIMA) * random.nextDouble();
            // Redondear a 2 decimales
            calificaciones[i] = Math.round(calificaciones[i] * 100.0) / 100.0;
        }
        System.out.println("Calificaciones generadas exitosamente.");
        System.out.println();
    }
    
    /**
     * Método para mostrar la información completa de todos los estudiantes
     * @param nombres Arreglo con los nombres de los estudiantes
     * @param calificaciones Arreglo con las calificaciones
     */
    private static void mostrarInformacionEstudiantes(String[] nombres, double[] calificaciones) {
        System.out.println("--- INFORMACIÓN DE ESTUDIANTES ---");
        System.out.printf("%-20s %-12s %-10s%n", "Nombre", "Calificación", "Estado");
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < CANTIDAD_ESTUDIANTES; i++) {
            String estado = determinarEstadoEstudiante(calificaciones[i]);
            System.out.printf("%-20s %-12.2f %-10s%n", nombres[i], calificaciones[i], estado);
        }
        System.out.println();
    }
    
    /**
     * Método para determinar el estado de un estudiante según su calificación
     * @param calificacion La calificación del estudiante
     * @return String indicando el estado (Promovido, Aprobado, Reprobado)
     */
    private static String determinarEstadoEstudiante(double calificacion) {
        if (calificacion >= NOTA_MINIMA_PROMOVIDO) {
            return "Promovido";
        } else if (calificacion >= NOTA_MINIMA_APROBADO) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }
    
    /**
     * Método principal para calcular y mostrar todas las estadísticas
     * @param nombres Arreglo con los nombres de los estudiantes
     * @param calificaciones Arreglo con las calificaciones
     */
    private static void calcularYMostrarEstadisticas(String[] nombres, double[] calificaciones) {
        // Contadores para diferentes tipos de calificaciones
        int cantidadAprobados = 0;
        int cantidadPromovidos = 0;
        int cantidadReprobados = 0;
        
        // Variables para encontrar la calificación más alta
        double calificacionMasAlta = calificaciones[0];
        String estudianteMejorNota = nombres[0];
        
        // Variable para calcular el promedio
        double sumaCalificaciones = 0.0;
        
        // Recorrer todas las calificaciones para calcular estadísticas
        for (int i = 0; i < CANTIDAD_ESTUDIANTES; i++) {
            double calificacion = calificaciones[i];
            
            // Contar tipos de calificaciones
            if (calificacion >= NOTA_MINIMA_PROMOVIDO) {
                cantidadPromovidos++;
                cantidadAprobados++; // Los promovidos también son aprobados
            } else if (calificacion >= NOTA_MINIMA_APROBADO) {
                cantidadAprobados++;
            } else {
                cantidadReprobados++;
            }
            
            // Verificar si es la calificación más alta
            if (calificacion > calificacionMasAlta) {
                calificacionMasAlta = calificacion;
                estudianteMejorNota = nombres[i];
            }
            
            // Acumular para el promedio
            sumaCalificaciones += calificacion;
        }
        
        // Calcular promedio
        double promedioGeneral = sumaCalificaciones / CANTIDAD_ESTUDIANTES;
        
        // Mostrar todas las estadísticas
        mostrarEstadisticasFinales(cantidadAprobados, cantidadPromovidos, cantidadReprobados,
                                  calificacionMasAlta, estudianteMejorNota, promedioGeneral);
    }
    
    /**
     * Método para mostrar las estadísticas finales del programa
     * @param aprobados Cantidad de estudiantes aprobados
     * @param promovidos Cantidad de estudiantes promovidos
     * @param reprobados Cantidad de estudiantes reprobados
     * @param mejorNota La calificación más alta
     * @param mejorEstudiante Nombre del estudiante con mejor nota
     * @param promedio Promedio general de todas las calificaciones
     */
    private static void mostrarEstadisticasFinales(int aprobados, int promovidos, int reprobados,
                                                  double mejorNota, String mejorEstudiante, double promedio) {
        System.out.println("=== ESTADÍSTICAS FINALES ===");
        System.out.println();
        
        System.out.println("📊 RESUMEN DE CALIFICACIONES:");
        System.out.println("   • Estudiantes aprobados (nota >= " + NOTA_MINIMA_APROBADO + "): " + aprobados);
        System.out.println("   • Estudiantes promovidos (nota >= " + NOTA_MINIMA_PROMOVIDO + "): " + promovidos);
        System.out.println("   • Estudiantes reprobados (nota < " + NOTA_MINIMA_APROBADO + "): " + reprobados);
        System.out.println();
        
        System.out.println("🏆 MEJOR CALIFICACIÓN:");
        System.out.printf("   • Estudiante: %s%n", mejorEstudiante);
        System.out.printf("   • Calificación: %.2f%n", mejorNota);
        System.out.println();
        
        System.out.println("📈 PROMEDIO GENERAL:");
        System.out.printf("   • Promedio de todas las calificaciones: %.2f%n", promedio);
        System.out.println();
        
        // Análisis adicional del rendimiento del grupo
        double porcentajeAprobados = (double) aprobados / CANTIDAD_ESTUDIANTES * 100;
        double porcentajePromovidos = (double) promovidos / CANTIDAD_ESTUDIANTES * 100;
        
        System.out.println("📋 ANÁLISIS DEL GRUPO:");
        System.out.printf("   • Porcentaje de aprobación: %.1f%%%n", porcentajeAprobados);
        System.out.printf("   • Porcentaje de promoción: %.1f%%%n", porcentajePromovidos);
        
        if (porcentajeAprobados >= 80) {
            System.out.println("   • ✅ Excelente rendimiento del grupo");
        } else if (porcentajeAprobados >= 60) {
            System.out.println("   • ⚠️ Rendimiento aceptable del grupo");
        } else {
            System.out.println("   • ❌ El grupo necesita apoyo adicional");
        }
    }
} 