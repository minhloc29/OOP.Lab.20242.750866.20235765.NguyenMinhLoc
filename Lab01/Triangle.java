//6.3
import java.util.Scanner;
public class Triangle {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of the triangle: ");
        int n = keyboard.nextInt();
        int space;
        for (int i = 1; i <= n; i++){
            space = n - i;
            for (int j = 1; j <= space; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
