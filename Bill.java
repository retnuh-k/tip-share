
import java.util.ArrayList;

public class Bill {
    private double subtotal;
    private double total;
    private double tax;
    private double tip;
    private ArrayList<Customer> customers;

    public Bill(double newSubtotal, double newTax, double newTip) {
        subtotal = newSubtotal;
        tax = newTax;
        tip = newTip;
        total = newSubtotal*(1+newTax) + newSubtotal*newTip;
        customers = new ArrayList<Customer>();
    }

    public Bill() {
        subtotal = 0;
        total = 0;
        tax = 0;
        tip = 0;
        customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public Customer createCustomer(String name, double itemTotal){
        Customer customer = new Customer(name, itemTotal);
        customers.add(customer);
        return customer;
    }
    
    public double getTotal() {
        return total;
    }

    public void calculateIndividualTotals() {
        double sharedTotal = 0;
	      for (int i=0; i<customers.size(); i++) {
            Customer c = customers.get(i);
            double cTotal = c.getTotalItemCost() / subtotal * total;
            c.setAmountOwed(cTotal);
	          sharedTotal += cTotal;
        }
        // Add cost of leftover items divided evenly to each customer
        double leftoverCost = (total - sharedTotal) / customers.size();
        for (int i=0; i<customers.size(); i++) {
            Customer c = customers.get(i);
            c.setAmountOwed(c.getAmountOwed() + leftoverCost);
        }
    }
}
