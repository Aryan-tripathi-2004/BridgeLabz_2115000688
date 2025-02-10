
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discountApplied = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discountApplied;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        discountApplied = (getPrice() * getQuantity()) * (discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: $" + discountApplied;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge = 2.0; 
    private double discountApplied = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + extraCharge) - discountApplied;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        discountApplied = (getPrice() * getQuantity()) * (discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: $" + discountApplied;
    }
}

class OrderSystem {
    public static void processOrder(FoodItem item) {
        System.out.println("\nProcessing: " + item.getItemDetails());
        System.out.println("Total Price Before Discount: $" + item.calculateTotalPrice());

        if (item instanceof Discountable) {
            Discountable discountItem = (Discountable) item;
            discountItem.applyDiscount(10); 
            System.out.println(discountItem.getDiscountDetails());
            System.out.println("Final Price After Discount: $" + item.calculateTotalPrice());
        }
    }
}


public class OnlineFoodSystem {
    public static void main(String[] args) {
        FoodItem vegBurger = new VegItem("Veg Burger", 5.0, 2);
        FoodItem chickenPizza = new NonVegItem("Chicken Pizza", 8.0, 1);

        OrderSystem.processOrder(vegBurger);
        OrderSystem.processOrder(chickenPizza);
    }
}
