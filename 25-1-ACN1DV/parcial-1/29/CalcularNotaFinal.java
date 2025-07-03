import java.util.Scanner;

public class CalcularNotaFinal   {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar las notas al usuario
        System.out.println("Ingrese la primera nota (examen 1, máximo 100):");
        double nota1 = scanner.nextDouble();

        System.out.println("Ingrese la segunda nota (examen 2, máximo 100):");
        double nota2 = scanner.nextDouble();

        System.out.println("Ingrese la tercera nota (TP, máximo 100):");
        double nota3 = scanner.nextDouble();

        // Calcular la nota final
        double notaFinal = (nota1 * 0.30) + (nota2 * 0.30) + (nota3 * 0.40);

        // Mostrar la nota final
        System.out.println("Nota final: " + notaFinal);

        // Determinar el estado del alumno
        if (notaFinal >= 70 && nota3 >= 60) {
            System.out.println("El alumno Promociona");
        } else if (notaFinal >= 40) {
            System.out.println("El alumno Aprueba");
        } else {
            System.out.println("El alumno Reprueba");
        }

        scanner.close();
    }
}
