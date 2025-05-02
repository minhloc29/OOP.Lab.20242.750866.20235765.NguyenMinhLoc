package hust.soict.hedspi.lab01;//6.4
import java.util.Scanner;
public class DayDisplay {
    static int checkLeapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            return 1;
        }
        return 0;
    }

    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = keyboard.nextInt();
        System.out.print("Enter the month: ");
        int month = keyboard.nextInt();
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31 days");
                break;
            
            case 2:
                if(checkLeapYear(year) == 1){
                    System.out.println("29 days");
                }
                else{
                    System.out.println("28 days");
                }
                break;
            default:
                System.out.println("30 days");
                break;
        }
    }
}
