package hust.soict.hedspi.lab01;// 2.2.6
import java.util.Scanner;

public class Equation {
    static double determinant(double num11, double num12, double num21, double num22){
        return num11*num22 - num12*num21;
    }
    static void firstEquation(double num1, double num2){
        if(num1 == 0){
            if(num2 == 0){
                System.out.printf("Infinite solutions\n");
            }
            else{
                System.out.printf("No solution\n");
            }
        }
        else{
            double result = -num2/num1;
            String formatted = String.format("x = %.2f%n", result);
            System.out.printf(formatted);
        }
    }
    static void secondEquation(double num11, double num12, double b1, double num21, double num22, double b2){
        double deter = determinant(num11, num12, num21, num22);
        double deter_x1 = determinant(b1, num12, b2, num22);
        double deter_x2 = determinant(num11, b1, num21, b2);
        if(deter != 0){
            double x1 = deter_x1/deter;
            double x2 = deter_x2/deter;
            String formatted = String.format("x1 = %.2f%n, x2 = %.2f%n", x1, x2);
            System.out.printf(formatted);
        }
        else{
            if(deter_x1 == 0 && deter_x2 == 0){
                System.out.printf("Infinite solutions\n");
            }
            else{
                System.out.printf("No solution\n");
            }
        }
    }
    static void secondDegree(double a, double b, double c){
        if(a == 0){
            firstEquation(b, c);
        }
        else{
            double delta = b*b - 4*a*c;
            if(delta < 0){
                System.out.print("No solution\n");
            }
            else if(delta == 0){
                double result = -b / (2*a);
                String formatted = String.format("x = %.2f%n", result);
                System.out.printf(formatted);
            }
            else{
                double x1 = (-b + Math.sqrt(delta)) / (2*a);
                double x2 = (-b - Math.sqrt(delta)) / (2*a);
                String formatted = String.format("x1 = %.2f%n, x2 = %.2f%n", x1, x2);
                System.out.printf(formatted);
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1){
            System.out.print("Solving first-degree equationw with 1 variable.\n");
            System.out.print("a: ");
            double num1 = scanner.nextDouble();
            System.out.print("b: ");
            double num2 = scanner.nextDouble();
            firstEquation(num1, num2);
        }
        else if(choice == 2){
            System.out.print("Solving first-degree equation with 2 variables.\n");
            System.out.print("num11: ");
            double num11 = scanner.nextDouble();
            System.out.print("num12: ");
            double num12 = scanner.nextDouble();
            System.out.print("b1: ");
            double b1 = scanner.nextDouble();
            System.out.print("num21: ");
            double num21 = scanner.nextDouble();
            System.out.print("num22: ");
            double num22 = scanner.nextDouble();
            System.out.print("b2: ");
            double b2 = scanner.nextDouble();
            secondEquation(num11, num12, b1, num21, num22, b2);
        }
        else if(choice == 3){
            System.out.print("Solving second-degree equation with 1 variable.\n");
            System.out.print("a: ");
            double num1 = scanner.nextDouble();
            System.out.print("b: ");
            double num2 = scanner.nextDouble();
            System.out.print("c: ");
            double num3 = scanner.nextDouble();
            secondDegree(num1, num2, num3);
        }
    }
}
