// Author: Albert Lukmanov
// Ejercicio 1: Validación de Edad semanal10

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edad;
        
        System.out.println("=== Validación de Edad ===");
        
        // Bucle para validar la edad
        while (true) {
            System.out.print("Ingrese su edad: ");
            edad = scanner.nextInt();
            
            // Verificar si la edad es válida (mayor de 18)
            if (edad > 18) {
                System.out.println("¡Edad válida! Usted tiene " + edad + " años y es mayor de edad.");
                break; // Salir del bucle si la edad es válida
            } else {
                System.out.println("Edad inválida. Debe ser mayor de 18 años. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
} 