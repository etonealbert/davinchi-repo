/**
 * UniversitySystem 
 * 
 * Author: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class UniversitySystem {
    
    public static void main(String[] args) {
        Asignatura course = new Asignatura(
            "Programación Orientada a Objetos", 
            "S0D23-POO",                         
            3                                    
        );
        
        Profesor professor = new Profesor(
            "Dr. María González", 
            "PROF-001",            
            course                
        );
        
        Departamento department = new Departamento(
            "Departamento de Sistemas",  
            "DEPT-CS-001",              
            professor                  
        );
        
        System.out.println("========================================");
        System.out.println("  SISTEMA UNIVERSITARIO - DEMO");
        System.out.println("========================================\n");
        
        department.displayInfo();
        
        System.out.println("\n");
        
        System.out.println("=== USANDO toString() ===");
        System.out.println(department.toString());
        System.out.println("\n");
        
        System.out.println("=== VERIFICACIÓN DE RELACIONES ===");
        System.out.println("El departamento '" + department.getNombre() + 
                         "' tiene al profesor '" + department.getProfesor().getNombre() + "'");
        System.out.println("El profesor '" + professor.getNombre() + 
                         "' enseña la asignatura '" + professor.getAsignatura().getNombre() + "'");
        System.out.println("====================================");
    }
}

