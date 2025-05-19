import java.util.Scanner;

public class CafeBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Ingrese la bebida (C para Capuccino, L para Latte, A para Americano): ");
        char bebida = scanner.next().toUpperCase().charAt(0);
        System.out.print("Ingrese el tamaño (P para Pequeño, G para Grande): ");
        char tamano = scanner.next().toUpperCase().charAt(0);

        // Variables
        int precioBase = 0;
        double precioFinal = 0;
        String nombreBebida = "";
        String nombreTamano = tamano == 'P' ? "pequeño" : "grande";

        // Determine base price and drink name
        switch (bebida) {
            case 'C':
                nombreBebida = "Capuccino";
                if (tamano == 'P') precioBase = 1000;
                else if (tamano == 'G') precioBase = 1300;
                break;
            case 'L':
                nombreBebida = "Latte";
                if (tamano == 'P') precioBase = 900;
                else if (tamano == 'G') precioBase = 1000;
                break;
            case 'A':
                nombreBebida = "Americano";
                if (tamano == 'P') precioBase = 800;
                else if (tamano == 'G') precioBase = 950;
                break;
            default:
                System.out.println("Error: Bebida inválida");
                scanner.close();
                return;
        }

        // Validate size
        if (tamano != 'P' && tamano != 'G') {
            System.out.println("Error: Tamaño inválido");
            scanner.close();
            return;
        }

        // Check for discount and calculate final price
        if ((bebida == 'C' || bebida == 'A') && tamano == 'G') {
            precioFinal = precioBase * 0.5; // 50% OFF
            System.out.print(nombreBebida + " " + nombreTamano + ", precio: " + precioBase + " $. En promoción! Precio final: " + (int)precioFinal + " $");
        } else if ((bebida == 'L' || bebida == 'A') && tamano == 'P') {
            precioFinal = precioBase * 0.6; // 40% OFF (60% of original price)
            System.out.print(nombreBebida + " " + nombreTamano + ", precio: " + precioBase + " $. En promoción! Precio final: " + (int)precioFinal + " $");
        } else {
            precioFinal = precioBase;
            System.out.print(nombreBebida + " " + nombreTamano + ", precio: " + precioBase + " $");
        }
        System.out.println();

        scanner.close();
    }
}
