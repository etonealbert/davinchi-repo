import java.util.Scanner;

/**
 * Ejercicio 3a - Primeros N Números Pares
 * Objetivo: Escribir un programa que imprima los primeros "n" números pares,
 * donde "n" es un número entero positivo ingresado por el usuario.
 * 
 * Autor: Albert Lukmanov
 */
public class EvenNumbers {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese un número positivo
        System.out.print("Ingrese un número entero positivo (n): ");
        int n = scanner.nextInt();
        
        // Validar que el número sea positivo
        if (n <= 0) {
            System.out.println("Error: Por favor ingrese un número entero positivo.");
            scanner.close();
            return;
        }
        
        // Mostrar los primeros n números pares
        System.out.println("\nLos primeros " + n + " números pares son:");
        
        int contador = 0;  // Contador de números pares encontrados
        int numero = 2;    // Comenzamos con el primer número par
        
        // Bucle para encontrar e imprimir los primeros n números pares
        while (contador < n) {
            System.out.print(numero + " ");
            numero += 2;  // Siguiente número par
            contador++;
        }
        
        System.out.println(); // Nueva línea al final
        scanner.close();
    }
} 