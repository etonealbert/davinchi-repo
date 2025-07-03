import java.util.Scanner;
import java.util.Random;

public class JuegoDados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Leer nombre del usuario
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        // Inicializar acumulador de puntos
        int puntos = 12;
        System.out.println("Puntos iniciales de " + nombre + ": " + puntos);

        // Lanzar los 3 dados (valores entre 1 y 6)
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int dado3 = random.nextInt(6) + 1;
        System.out.println("Dado 1: " + dado1 + ", Dado 2: " + dado2 + ", Dado 3: " + dado3);

        // Evaluar condiciones para acumular puntos
        if (dado1 == dado2 && dado2 == dado3) {
            // Caso 1: Los 3 dados son iguales
            puntos += 40;
            System.out.println("Los 3 dados son iguales. Suma: +40 puntos");
        } else if (dado1 == dado2 || dado2 == dado3 || dado1 == dado3) {
            // Caso 2: Al menos 2 dados son iguales
            puntos += 30;
            System.out.println("Al menos 2 dados son iguales. Suma: +30 puntos");
        } else {
            // Caso 3: Los 3 dados son distintos
            int suma = dado1 + dado2 + dado3;
            if (suma > 14) {
                puntos += 20;
                System.out.println("Dados distintos y suma mayor a 14 (" + suma + "). Suma: +20 puntos");
            } else {
                // Encontrar el dado mayor
                int mayor = Math.max(dado1, Math.max(dado2, dado3));
                if (mayor % 2 == 0) {
                    puntos += mayor * 2;
                    System.out.println("Dados distintos, mayor es " + mayor + " (par). Suma: +" + (mayor * 2) + " puntos");
                } else {
                    puntos += mayor;
                    System.out.println("Dados distintos, mayor es " + mayor + " (impar). Suma: +" + mayor + " puntos");
                }
            }
        }

        // Mostrar puntos finales
        System.out.println("Puntos finales de " + nombre + ": " + puntos);
        scanner.close();
    }
}
