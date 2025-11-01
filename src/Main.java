import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        float payRate,otHours;

        System.out.println("Welcome to the OTcalc");

        System.out.println("Enter your pay rate");
        payRate = inputHandler(inputScanner);
        System.out.println("How many hours of OT?");
        otHours = inputHandler(inputScanner);

        System.out.println("Your pay rate is $" + payRate);
        System.out.println("You worked: " + otHours + " OT hours");

        calculations(payRate,otHours);

    }

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
            }
        }
        System.out.println("You entered: " + number);
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
}
