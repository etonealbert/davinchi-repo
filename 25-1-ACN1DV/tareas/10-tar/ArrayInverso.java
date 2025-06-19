import java.util.Scanner;

/**
 * Programa que solicita al usuario 5 números enteros,
 * los almacena en un arreglo y los muestra en orden inverso
 */
public class ArrayInverso {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Declarar un arreglo de 5 enteros
        int[] numeros = new int[5];
        
        // Solicitar al usuario que ingrese 5 números
        System.out.println("Por favor, ingrese 5 números enteros:");
        
        // Ciclo para llenar el arreglo con los números ingresados
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        // Mostrar los números en orden inverso
        System.out.println("\nLos números en orden inverso son:");
        
        // Ciclo que recorre el arreglo desde el último índice hasta el primero
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i]);
            
            // Agregar coma y espacio si no es el último elemento a mostrar
            if (i > 0) {
                System.out.print(", ");
            }
        }
        
        System.out.println(); // Salto de línea final
        
        // Cerrar el scanner
        scanner.close();
    }
} 