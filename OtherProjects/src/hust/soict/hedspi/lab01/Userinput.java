package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class Userinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Second number: ");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        System.out.println("Sum is: " + sum);

        double diff = num1 - num2;
        System.out.println("Difference is: " + diff);

        double product = num1 * num2;
        System.out.println("Product is: " + product);

        double quo = num1 / num2;
        System.out.println("Quotient is: " + quo);

        scanner.close(); // Close the scanner
    }
}
