// Author: Albert Lukmanov
// Ejercicio 2: Cálculo de Promedio semanal9

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numero;
        double suma = 0;
        int contador = 0;
        
        System.out.println("=== Cálculo de Promedio ===");
        System.out.println("Ingrese números uno por uno. Para terminar, ingrese un número negativo.");
        
        // Bucle para leer números hasta que se ingrese un negativo
        while (true) {
            System.out.print("Ingrese un número: ");
            numero = scanner.nextDouble();
            
            // Si el número es negativo, salir del bucle
            if (numero < 0) {
                break;
            }
            
            // Acumular suma y contar números válidos
            suma += numero;
            contador++;
        }
        
        // Calcular y mostrar el promedio
        if (contador > 0) {
            double promedio = suma / contador;
            System.out.println("\n=== Resultados ===");
            System.out.println("Cantidad de números ingresados: " + contador);
            System.out.println("Suma total: " + suma);
            System.out.println("Promedio: " + String.format("%.2f", promedio));
        } else {
            System.out.println("No se ingresaron números válidos para calcular el promedio.");
        }
        
        scanner.close();
    }
} 