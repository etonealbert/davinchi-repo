import java.util.Scanner;

/**
 * Programa que utiliza arreglos paralelos para almacenar nombres y edades
 * de 5 personas, y muestra los nombres de las personas mayores a cierta edad
 */
public class PersonasEdades {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Declarar arreglos paralelos para nombres y edades
        String[] nombres = new String[5];
        int[] edades = new int[5];
        
        // Solicitar al usuario que ingrese los datos de 5 personas
        System.out.println("Por favor, ingrese los datos de 5 personas:");
        
        // Ciclo para llenar los arreglos paralelos
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("\nPersona " + (i + 1) + ":");
            
            // Solicitar y almacenar el nombre
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();
            
            // Solicitar y almacenar la edad
            System.out.print("Edad: ");
            edades[i] = scanner.nextInt();
            
            // Limpiar el buffer del scanner después de leer un entero
            scanner.nextLine();
        }
        
        // Solicitar la edad límite para filtrar
        System.out.print("\nIngrese la edad límite para filtrar: ");
        int edadLimite = scanner.nextInt();
        
        // Buscar y mostrar las personas mayores a la edad límite
        System.out.println("\nPersonas mayores a " + edadLimite + " años:");
        
        // Variable para controlar si se encontraron personas
        boolean encontraron = false;
        
        // Ciclo que recorre los arreglos paralelos
        for (int i = 0; i < nombres.length; i++) {
            // Verificar si la edad es mayor al límite establecido
            if (edades[i] > edadLimite) {
                System.out.println("- " + nombres[i] + " (" + edades[i] + " años)");
                encontraron = true;
            }
        }
        
        // Mostrar mensaje si no se encontraron personas
        if (!encontraron) {
            System.out.println("No se encontraron personas mayores a " + edadLimite + " años.");
        }
        
        // Cerrar el scanner
        scanner.close();
    }
} 