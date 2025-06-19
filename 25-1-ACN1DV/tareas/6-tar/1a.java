import java.util.Scanner;

/**
 * Ejercicio 1a - Tabla de Multiplicar
 * Objetivo: Solicitar al usuario un número entero y mostrar la tabla de multiplicar
 * de ese número del 1 al 10, utilizando un bucle for.
 * 
 * Autor: Albert Lukmanov
 */
public class MultiplicationTable {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese un número
        System.out.print("Ingrese un número entero para mostrar su tabla de multiplicar: ");
        int numero = scanner.nextInt();
        
        // Mostrar la tabla de multiplicar del número ingresado
        System.out.println("\n--- Tabla de Multiplicar del " + numero + " ---");
        
        // Bucle for para generar la tabla del 1 al 10
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
        
        scanner.close();
    }
} 