import java.util.Random;

/**
 * Programa que llena un arreglo con 10 números aleatorios entre 1 y 25,
 * asegurando que no se repita ningún número
 */
public class NumerosAleatorios {
    public static void main(String[] args) {
        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();
        
        // Declarar un arreglo para almacenar 10 números únicos
        int[] numerosUnicos = new int[10];
        
        // Variable para controlar la cantidad de números generados
        int cantidadGenerados = 0;
        
        System.out.println("Generando 10 números aleatorios únicos entre 1 y 25...\n");
        
        // Ciclo que continúa hasta llenar el arreglo con 10 números únicos
        while (cantidadGenerados < 10) {
            // Generar un número aleatorio entre 1 y 25 (inclusive)
            int numeroAleatorio = random.nextInt(25) + 1;
            
            // Verificar si el número ya existe en el arreglo
            boolean yaExiste = false;
            
            // Ciclo para buscar si el número ya está en el arreglo
            for (int i = 0; i < cantidadGenerados; i++) {
                if (numerosUnicos[i] == numeroAleatorio) {
                    yaExiste = true;
                    break; // Salir del ciclo si se encuentra el número
                }
            }
            
            // Si el número no existe, agregarlo al arreglo
            if (!yaExiste) {
                numerosUnicos[cantidadGenerados] = numeroAleatorio;
                cantidadGenerados++;
                System.out.println("Número " + cantidadGenerados + ": " + numeroAleatorio);
            }
        }
        
        // Mostrar el arreglo completo
        System.out.println("\nArreglo completo con números únicos:");
        System.out.print("[");
        
        // Ciclo para mostrar todos los números del arreglo
        for (int i = 0; i < numerosUnicos.length; i++) {
            System.out.print(numerosUnicos[i]);
            
            // Agregar coma y espacio si no es el último elemento
            if (i < numerosUnicos.length - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println("]");
        
        // Mostrar estadísticas adicionales
        System.out.println("\nEstadísticas:");
        System.out.println("Total de números generados: " + numerosUnicos.length);
        System.out.println("Rango utilizado: 1 - 25");
    }
} 