import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt and read quantities
        System.out.print("Ingrese la cantidad de galletas: ");
        int cantidadGalletas = scanner.nextInt();
        System.out.print("Ingrese la cantidad de alfajores: ");
        int cantidadAlfajores = scanner.nextInt();
        System.out.print("Ingrese la cantidad de gaseosas: ");
        int cantidadGaseosas = scanner.nextInt();

        // Determine prices based on quantities
        int precioGalletas;
        if (cantidadGalletas < 12) {
            precioGalletas = 2000;
        } else {
            precioGalletas = 1700;
        }

        int precioAlfajores;
        if (cantidadAlfajores < 12) {
            precioAlfajores = 1000;
        } else {
            precioAlfajores = 850;
        }

        int precioGaseosas;
        if (cantidadGaseosas < 12) {
            precioGaseosas = 2500;
        } else {
            precioGaseosas = 2300;
        }

        // Calculate total
        int total = (cantidadGalletas * precioGalletas) + 
                    (cantidadAlfajores * precioAlfajores) + 
                    (cantidadGaseosas * precioGaseosas);

        // Output result
        System.out.println("Total a abonar: " + total);

        scanner.close();
    }
}
