import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int Principal;
        float annualInterestRate;
        byte Period;

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            Principal = input.nextInt();
            if (Principal >= 1000 && Principal <= 1_000_000)
                break;
            else
                System.out.println("Enter a number between 1000 and 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = input.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30)
                break;
            else
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        while (true) {
            System.out.print("Period (Years): ");
            Period = input.nextByte();
            if (Period > 0 && Period <= 30)
                break;
            else
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }
        int numberOfPayments = Period * MONTHS_IN_YEAR;

        double mortgage = Principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        NumberFormat mortgageFormatted = NumberFormat.getCurrencyInstance();
        String payment = mortgageFormatted.format(mortgage);
        System.out.println("Mortgage: " + payment);

    }
}
