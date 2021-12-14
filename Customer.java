public class Customer {
    private String name;
    private double totalItemCost;
    private double amountOwed;

    public Customer (String n, double total){
        name = n;
        totalItemCost = total;
        amountOwed = 0;
    }

    public Customer (double itemCost){
        name = "";
        totalItemCost = itemCost;
    }

    public String getName(){
        return name;
    }

    public double getTotalItemCost(){
        return totalItemCost;
    }

    public double getAmountOwed(){
        return amountOwed;
    }

    public String setName(String newName){
        name = newName;
        return name;
    }

    public double setAmountOwed(double amount){
        amountOwed = amount;
        return amountOwed;
    }
}

