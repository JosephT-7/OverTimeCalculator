import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    static float payRate,otHours;

    public static void main(String[] args) {

        System.out.println("Welcome to the OTcalc");

        payRate = verifyRate(scanner);
        otHours = verifyHours(scanner);

        System.out.println("Your pay rate is $" + payRate);
        System.out.println("You worked: " + otHours + " OT hours");

        calculations(payRate,otHours);

    }

    static float verifyRate(Scanner scanner) { //validates proper rate input
        float number;
        do {
            System.out.println("Enter your pay rate");
            while (!scanner.hasNextFloat()) {
                System.out.println("Invalid input");
                scanner.next();
            }
            number = scanner.nextFloat();
        } while (number <= 0 || number > 100);
        return number;
    }

    static float verifyHours(Scanner scanner) { //validates proper hourly input
        float number;
        do {
            System.out.println("How many hours of OT?");
            while (!scanner.hasNextFloat()) {
                System.out.println("Invalid input");
                scanner.next();
            }
            number = scanner.nextFloat();
        } while (number <= 0 || number > 24);
        return number;
    }

    static void calculations(float payRate, float otHours){ //calculates pay rate
        float regPay,halfRate,otPay,totalPay;

        regPay = payRate * 40;
        halfRate = payRate / 2;
        otPay = halfRate * otHours;
        totalPay = regPay + otPay;

        System.out.println("Regular pay is: $" + regPay);
        System.out.println("Time and a half rate is: $" + halfRate);
        System.out.println("OT pay is: $" + otPay);
        System.out.println("Your total pay is: $" + totalPay);
    }

    //This was the old input verification handler

   /*
    static float inputHandler(Scanner scanner) { //validates proper input
        float number = 0;
        boolean validInputs = false;
        while (!validInputs) {
            try {
                number = scanner.nextFloat();
                validInputs = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("You entered: " + number);
        return number;
    }
*/
}
