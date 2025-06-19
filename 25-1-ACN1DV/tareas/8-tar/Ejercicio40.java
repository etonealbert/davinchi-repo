// Author: Albert Lukmanov
// Ejercicio 40: Dígito Mayor y Menor

import java.util.Scanner;

public class Ejercicio40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Dígito Mayor y Menor ===");
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();
        
        // Trabajar con el valor absoluto para manejar números negativos
        int numeroAbsoluto = Math.abs(numero);
        
        // Verificar si el número es 0
        if (numeroAbsoluto == 0) {
            System.out.println("El número es 0.");
            System.out.println("Dígito mayor: 0");
            System.out.println("Dígito menor: 0");
            scanner.close();
            return;
        }
        
        // Inicializar variables para el dígito mayor y menor
        int digitoMayor = 0;
        int digitoMenor = 9;
        int numeroTemporal = numeroAbsoluto;
        boolean primerDigito = true;
        
        System.out.println("Analizando el número: " + numero + " (valor absoluto: " + numeroAbsoluto + ")");
        System.out.print("Dígitos encontrados: ");
        
        // Bucle para recorrer cada dígito del número
        while (numeroTemporal > 0) {
            // Extraer el último dígito
            int digito = numeroTemporal % 10;
            System.out.print(digito + " ");
            
            // Actualizar el dígito mayor y menor
            if (primerDigito) {
                digitoMayor = digito;
                digitoMenor = digito;
                primerDigito = false;
            } else {
                if (digito > digitoMayor) {
                    digitoMayor = digito;
                }
                if (digito < digitoMenor) {
                    digitoMenor = digito;
                }
            }
            
            // Eliminar el último dígito del número
            numeroTemporal = numeroTemporal / 10;
        }
        
        // Mostrar resultados
        System.out.println("\n\n=== Resultados ===");
        System.out.println("Número original: " + numero);
        System.out.println("Dígito mayor: " + digitoMayor);
        System.out.println("Dígito menor: " + digitoMenor);
        System.out.println("Diferencia entre mayor y menor: " + (digitoMayor - digitoMenor));
        
        scanner.close();
    }
} 