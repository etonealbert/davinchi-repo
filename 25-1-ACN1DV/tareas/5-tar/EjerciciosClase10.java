import java.util.Scanner;

/**
 * Ejercicios de la Clase 10
 * Autor: Albert Lukmanov
 * 
 * Este archivo contiene las soluciones a los ejercicios 1 y 3
 * de la práctica de la clase 10.
 */
public class EjerciciosClase10 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== EJERCICIOS CLASE 10 ===");
        System.out.println("Autor: Albert Lukmanov");
        System.out.println();
        
        // Menú para seleccionar ejercicio
        System.out.println("Seleccione el ejercicio a ejecutar:");
        System.out.println("1. Ejercicio 1 - Imprimir 'Hola' n veces");
        System.out.println("3. Ejercicio 3 - Mostrar dígitos de un número");
        System.out.print("Ingrese su opción (1 o 3): ");
        
        int opcion = scanner.nextInt();
        
        switch(opcion) {
            case 1:
                ejercicio1(scanner);
                break;
            case 3:
                ejercicio3(scanner);
                break;
            default:
                System.out.println("Opción no válida.");
        }
        
        scanner.close();
    }
    
    /**
     * EJERCICIO 1:
     * Crear un programa que imprima la palabra "Hola" un cierto número de veces.
     * El número de repeticiones debe ser definido por el usuario.
     */
    public static void ejercicio1(Scanner scanner) {
        System.out.println("\n=== EJERCICIO 1 ===");
        System.out.println("Programa que imprime 'Hola' n veces");
        
        System.out.print("Ingrese el número de veces que desea imprimir 'Hola': ");
        int numeroRepeticiones = scanner.nextInt();
        
        // Validar que el número sea positivo
        if (numeroRepeticiones <= 0) {
            System.out.println("Error: El número debe ser mayor que 0.");
            return;
        }
        
        System.out.println("\nResultado:");
        // Imprimir "Hola" el número de veces especificado
        for (int i = 1; i <= numeroRepeticiones; i++) {
            System.out.println(i + ". Hola");
        }
        
        System.out.println("\nSe imprimió 'Hola' " + numeroRepeticiones + " veces.");
    }
    
    /**
     * EJERCICIO 3:
     * Crear un programa que muestre los dígitos de un número.
     * El programa debe tomar un número como entrada, extraer cada dígito e imprimirlo.
     * Después, el programa debe imprimir el número sin el último dígito.
     */
    public static void ejercicio3(Scanner scanner) {
        System.out.println("\n=== EJERCICIO 3 ===");
        System.out.println("Programa que muestra los dígitos de un número");
        
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();
        
        // Guardar el número original para mostrar
        int numeroOriginal = numero;
        
        // Manejar el caso de número negativo
        boolean esNegativo = numero < 0;
        if (esNegativo) {
            numero = Math.abs(numero); // Trabajar con valor absoluto
            System.out.println("Número ingresado: -" + numero);
        } else {
            System.out.println("Número ingresado: " + numero);
        }
        
        // Caso especial para el número 0
        if (numero == 0) {
            System.out.println("Dígitos del número:");
            System.out.println("0");
            System.out.println("Número sin el último dígito: 0");
            return;
        }
        
        // Extraer y mostrar cada dígito
        System.out.println("Dígitos del número:");
        int numeroTemporal = numero;
        String digitos = "";
        
        // Obtener los dígitos en orden inverso primero
        while (numeroTemporal > 0) {
            int digito = numeroTemporal % 10;
            digitos = digito + " " + digitos;
            numeroTemporal = numeroTemporal / 10;
        }
        
        System.out.println(digitos.trim());
        
        // Mostrar el número sin el último dígito
        int numeroSinUltimoDigito = numero / 10;
        
        if (numeroSinUltimoDigito == 0) {
            System.out.println("Número sin el último dígito: 0");
        } else {
            if (esNegativo && numeroSinUltimoDigito > 0) {
                System.out.println("Número sin el último dígito: -" + numeroSinUltimoDigito);
            } else {
                System.out.println("Número sin el último dígito: " + numeroSinUltimoDigito);
            }
        }
        
        // Información adicional
        System.out.println("\nInformación adicional:");
        System.out.println("Último dígito removido: " + (numero % 10));
        System.out.println("Número original: " + numeroOriginal);
    }
} 