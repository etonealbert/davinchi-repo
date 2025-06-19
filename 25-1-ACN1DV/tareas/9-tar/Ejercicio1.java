import java.util.Scanner;

/**
 * Ejercicio 1: Programa para registrar 5 números enteros positivos,
 * mostrar los números en posiciones impares y buscar un número específico.
 * 
 * @author Albert Lukmanov
 * @version 1.0
 */
public class Ejercicio1 {
    
    /**
     * Método principal que ejecuta el programa
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // a) Registrar 5 números enteros positivos
        int[] numeros = new int[5];
        System.out.println("=== REGISTRO DE NÚMEROS ===");
        System.out.println("Por favor, ingrese 5 números enteros positivos:");
        
        for (int i = 0; i < 5; i++) {
            int numero;
            do {
                System.out.print("Número " + (i + 1) + ": ");
                numero = scanner.nextInt();
                if (numero <= 0) {
                    System.out.println("Error: Debe ingresar un número positivo.");
                }
            } while (numero <= 0);
            numeros[i] = numero;
        }
        
        // Mostrar los números registrados
        System.out.println("\nNúmeros registrados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posición " + i + ": " + numeros[i]);
        }
        
        // b) Mostrar números en posiciones impares
        System.out.println("\n=== NÚMEROS EN POSICIONES IMPARES ===");
        System.out.println("Números ubicados en posiciones impares (1, 3):");
        boolean hayImpares = false;
        
        for (int i = 0; i < numeros.length; i++) {
            // Las posiciones impares son 1, 3 (índices 1, 3)
            if (i % 2 == 1) {
                System.out.println("Posición " + i + ": " + numeros[i]);
                hayImpares = true;
            }
        }
        
        if (!hayImpares) {
            System.out.println("No hay números en posiciones impares.");
        }
        
        // c) Buscar un número específico
        System.out.println("\n=== BÚSQUEDA DE NÚMERO ===");
        System.out.print("Ingrese el número que desea buscar: ");
        int numeroBuscar = scanner.nextInt();
        
        boolean encontrado = false;
        
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroBuscar) {
                System.out.println("¡Número encontrado!");
                System.out.println("El número " + numeroBuscar + " se encuentra en la posición " + i);
                encontrado = true;
                break; // Detener la búsqueda al encontrar la primera coincidencia
            }
        }
        
        if (!encontrado) {
            System.out.println("El número " + numeroBuscar + " no se encuentra en el arreglo.");
        }
        
        System.out.println("\n¡Programa finalizado!");
        scanner.close();
    }
} 