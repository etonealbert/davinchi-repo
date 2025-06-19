// Author: Albert Lukmanov
// Ejercicio 3: Determinación de Notas de Estudiantes samanal9

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota;
        int aprobados = 0;          // Estudiantes con nota > 4
        int examenFinal = 0;        // Estudiantes con nota >= 7
        int reprobados = 0;         // Estudiantes con nota < 7
        int totalEstudiantes = 0;
        
        System.out.println("=== Determinación de Notas de Estudiantes ===");
        System.out.println("Ingrese las notas de los estudiantes uno por uno.");
        System.out.println("Para terminar, ingrese un número negativo.");
        System.out.println("Escala de notas: 0-10");
        
        // Bucle para leer notas hasta que se ingrese un número negativo
        while (true) {
            System.out.print("Ingrese la nota del estudiante: ");
            nota = scanner.nextDouble();
            
            // Si la nota es negativa, terminar el proceso
            if (nota < 0) {
                break;
            }
            
            // Validar que la nota esté en el rango válido (0-10)
            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Debe estar entre 0 y 10. Intente nuevamente.");
                continue;
            }
            
            totalEstudiantes++;
            
            // Clasificar según la nota
            if (nota > 4) {
                aprobados++;
                if (nota >= 7) {
                    examenFinal++;
                }
            }
            
            if (nota < 7) {
                reprobados++;
            }
        }
        
        // Mostrar resultados
        if (totalEstudiantes > 0) {
            System.out.println("\n=== Resultados ===");
            System.out.println("Total de estudiantes evaluados: " + totalEstudiantes);
            System.out.println("Estudiantes aprobados (nota > 4): " + aprobados);
            System.out.println("Estudiantes que necesitan examen final (nota >= 7): " + examenFinal);
            System.out.println("Estudiantes reprobados (nota < 7): " + reprobados);
            
            // Mostrar porcentajes
            System.out.println("\n=== Porcentajes ===");
            System.out.printf("Porcentaje de aprobados: %.1f%%\n", (aprobados * 100.0) / totalEstudiantes);
            System.out.printf("Porcentaje con examen final: %.1f%%\n", (examenFinal * 100.0) / totalEstudiantes);
            System.out.printf("Porcentaje de reprobados: %.1f%%\n", (reprobados * 100.0) / totalEstudiantes);
        } else {
            System.out.println("No se ingresaron notas válidas para evaluar.");
        }
        
        scanner.close();
    }
} 