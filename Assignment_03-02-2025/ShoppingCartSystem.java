class Product {
    private static double discount = 10.0;
    private static int totalProducts = 0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productID = ++totalProducts;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Final Price: $" + (price - (price * discount / 100)));
            System.out.println();
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1000.0, 1);
        Product p2 = new Product("Smartphone", 500.0, 2);

        p1.displayProductDetails();
        p2.displayProductDetails();

        Product.updateDiscount(15.0);

        System.out.println("After updating discount:\n");
        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}

