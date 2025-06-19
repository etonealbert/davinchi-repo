// Author: Albert Lukmanov
// Ejercicio 32: Promedio de Números

import java.util.Scanner;

public class Ejercicio32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double acumulador = 0;      // Acumulador para la suma de números
        int contador = 0;           // Contador de números ingresados
        final int TOTAL_NUMEROS = 8; // Cantidad fija de números a ingresar
        
        System.out.println("=== Promedio de Números ===");
        System.out.println("Ingrese exactamente " + TOTAL_NUMEROS + " números para calcular el promedio.");
        
        // Bucle para leer exactamente 8 números
        while (contador < TOTAL_NUMEROS) {
            System.out.print("Ingrese el número " + (contador + 1) + ": ");
            double numero = scanner.nextDouble();
            
            // Acumular la suma
            acumulador += numero;
            
            // Incrementar el contador
            contador++;
            
            System.out.println("Números ingresados hasta ahora: " + contador + "/" + TOTAL_NUMEROS);
        }
        
        // Calcular el promedio
        double promedio = acumulador / TOTAL_NUMEROS;
        
        // Mostrar resultados
        System.out.println("\n=== Resultados ===");
        System.out.println("Cantidad de números ingresados: " + contador);
        System.out.println("Suma total (acumulador): " + acumulador);
        System.out.println("Promedio calculado: " + String.format("%.2f", promedio));
        
        scanner.close();
    }
} 