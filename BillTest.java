import java.util.ArrayList;
import java.util.Scanner;

public class BillTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter tax percentage:");
        double tax = input.nextDouble()/100;

        System.out.println("Enter tip percentage:");
        double tip = input.nextDouble()/100;

        System.out.println("Enter subtotal:");
        double subtotal = input.nextDouble();

        Bill bill = new Bill(subtotal, tax, tip);
        
        int personCount = 1;
        Boolean morePeople = true;
        while (morePeople){
            System.out.println("Enter person #" + personCount + "'s name:");
            String newName = input.next();
            System.out.println("Enter " + newName + "'s subtotal (sum of items purchased):");
            double newTotal = input.nextDouble();
            bill.createCustomer(newName, newTotal);

            Boolean incorrectFormat = true;
            while (incorrectFormat) {
                System.out.println("Enter another customer? (y/n)");
                String answer = input.next();
                if (answer.charAt(0)=='y') {
                    incorrectFormat = false;
                } else if (answer.charAt(0)=='n') {
                    incorrectFormat = false;
                    morePeople = false;
                } else {
                    System.out.println("Incorrect format, please type 'y' or 'n'");
                }
            }
            
        }

        System.out.println("Calculating individual totals...");
        bill.calculateIndividualTotals();
        
        ArrayList<Customer> customers = bill.getCustomers();
        for (int i=0; i<customers.size(); i++){
            Customer c = customers.get(i);
            System.out.println(c.getName() + " owes " + c.getAmountOwed());
        }

        input.close();

    }
}
