/**
 * UniversitySystem - Main program to test the university system
 * Demonstrates the relationships between Asignatura, Profesor, and Departamento
 * 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class UniversitySystem {
    
    public static void main(String[] args) {
        // Local variable: Create an Asignatura (Course)
        Asignatura course = new Asignatura(
            "Programación Orientada a Objetos",  // nombre
            "S0D23-POO",                          // codigo
            3                                      // semestre
        );
        
        // Local variable: Create a Profesor who teaches this course
        Profesor professor = new Profesor(
            "Dr. María González",  // nombre
            "PROF-001",            // id
            course                 // asignatura
        );
        
        // Local variable: Create a Departamento with this professor
        Departamento department = new Departamento(
            "Departamento de Sistemas",  // nombre
            "DEPT-CS-001",               // id
            professor                    // profesor
        );
        
        // Display the complete information
        System.out.println("========================================");
        System.out.println("  SISTEMA UNIVERSITARIO - DEMO");
        System.out.println("========================================\n");
        
        // Method 1: Using the custom displayInfo() method
        department.displayInfo();
        
        // Add some spacing
        System.out.println("\n");
        
        // Method 2: Using toString() method (shows the full nested structure)
        System.out.println("=== USANDO toString() ===");
        System.out.println(department.toString());
        System.out.println("\n");
        
        // Demonstrate the relationships
        System.out.println("=== VERIFICACIÓN DE RELACIONES ===");
        System.out.println("El departamento '" + department.getNombre() + 
                         "' tiene al profesor '" + department.getProfesor().getNombre() + "'");
        System.out.println("El profesor '" + professor.getNombre() + 
                         "' enseña la asignatura '" + professor.getAsignatura().getNombre() + "'");
        System.out.println("====================================");
    }
}

