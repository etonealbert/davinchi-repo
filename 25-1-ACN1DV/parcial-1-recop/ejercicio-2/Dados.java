import java.util.Scanner;

public class Dados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el nombre del usuario
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        // Leer los valores de los 3 dados
        System.out.println("Ingrese el valor del dado 1:");
        int dado1 = scanner.nextInt();
        System.out.println("Ingrese el valor del dado 2:");
        int dado2 = scanner.nextInt();
        System.out.println("Ingrese el valor del dado 3:");
        int dado3 = scanner.nextInt();

        // Determinar el resultado según las condiciones
        String resultado;
        if (dado1 != dado2 && dado2 != dado3 && dado1 != dado3) {
            // Caso 1: Los 3 dados son distintos
            int suma = dado1 + dado2 + dado3;
            resultado = "Felicidades " + nombre + " sumaste " + suma + " puntos!";
        } else if ((dado1 == dado2 && dado1 != dado3) || (dado1 == dado3 && dado1 != dado2) || (dado2 == dado3 && dado2 != dado1)) {
            // Caso 2: Hay 2 dados iguales y 1 distinto
            int suma = dado1 + dado2 + dado3;
            resultado = "Bien " + nombre + " sumaste " + suma + " puntos";
        } else {
            // Caso 3: Cualquier otra combinación (como 3 dados iguales)
            resultado = "Mal " + nombre + ", perdiste";
        }

        // Mostrar el resultado
        System.out.println("Salida: \"" + resultado + "\"");

        scanner.close();
    }
}
