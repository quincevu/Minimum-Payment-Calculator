package minimumpaymentcalculator; // I use NetBeans, so this is a required thing. If code does not compile due to this line, please double slash or delete it.
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;
/**
 *
 * @author Quang Vu
 * U87529813
 */
public class MinimumPaymentCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create an input method
        NumberFormat cur = NumberFormat.getCurrencyInstance(); // currency
        NumberFormat per = NumberFormat.getPercentInstance(); // percentage
        DecimalFormat dec = new DecimalFormat("0.###"); // 3 decimal numbers
        double loan, rate, mrate, pay; int month;
        System.out.print("Enter the loan amount: "); loan = input.nextDouble();
        while (loan <=0){
            System.out.print("Invalid value !!\nEnter the loan amount: "); loan = input.nextDouble();
        } // input validation, I use while to prevent trolling test packs that kept doing negative numbers
        System.out.print("Enter the annual percentage rate: "); rate = input.nextDouble();
        while (rate <=0){
            System.out.print("Invalid value !!\nEnter the annual percentage rate: "); rate = input.nextDouble();
        }
        System.out.print("Enter the number of months: "); month = input.nextInt();
        while (month <=0) {
            System.out.print("Invalid value !!\nEnter the number of months: "); month = input.nextInt();
        }
        mrate = rate / 12;
        System.out.print("The monthly interest rate for the loan is " + dec.format(mrate)+"%\n"); // print mrate
        pay = loan*((mrate/100*Math.pow(1+mrate/100,month))/(Math.pow(1+mrate/100,month)-1));
        System.out.print("The minimum amount you would need to pay is " + cur.format(pay)); // print minimun payment
    }
}