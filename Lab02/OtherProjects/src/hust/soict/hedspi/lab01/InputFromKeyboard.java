package hust.soict.hedspi.lab01;//6.2
import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = keyboard.nextLine();
        System.out.println("How old are you?");
        int age = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        double height = keyboard.nextDouble();
        System.out.println("Mr/Ms. " + name + ", " + age + " years old. " + "Your height is " + height + "m.");
    }
}
