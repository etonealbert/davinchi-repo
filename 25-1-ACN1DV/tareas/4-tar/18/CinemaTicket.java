import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double BASE_PRICE = 6700.00;

        System.out.print("Ingrese la edad: ");
        int age = scanner.nextInt();

        if (age < 7) {
            System.out.println("Ingreso gratuito");
        } else if (age <= 12) {
            double price = BASE_PRICE * 0.6;
            System.out.printf("Pagar: %.2f pesos%n", price);
        } else if (age <= 55) {
            System.out.printf("Pagar: %.2f pesos%n", BASE_PRICE);
        } else {
            double price = BASE_PRICE * 0.5;
            System.out.printf("Pagar: %.2f pesos%n", price);
        }

        scanner.close();
    }
}
