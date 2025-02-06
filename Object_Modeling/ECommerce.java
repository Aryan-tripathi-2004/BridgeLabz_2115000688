import java.util.ArrayList;

class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
}

class Order {
    private static int orderCounter = 1;
    private int orderId;
    private ArrayList<Product> products;

    public Order() {
        this.orderId = orderCounter++;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products in Order:");
        for (Product product : products) {
            System.out.println(" - " + product.getProductName() + " | Price: " + product.getPrice());
        }
        System.out.println("Total Price: " + calculateTotal());
    }
}

class Customer {
    private String customerName;
    private Order order; 

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void placeOrder(Order order) {
        if (this.order == null) { 
            this.order = order;
            System.out.println(customerName + " placed an order");
        } else {
            System.out.println(customerName + " has already placed an order and cannot place another.");
        }
    }

    public void displayOrder() {
        System.out.println("Customer: " + customerName);
        if (order != null) {
            order.displayOrderDetails();
        } else {
            System.out.println("No order placed.");
        }
    }
}

public class ECommerce {
    public static void main(String[] args) {
        
        Product product1 = new Product("Laptop", 800);
        Product product2 = new Product("Smartphone", 500);
        Product product3 = new Product("Headphones", 50);
    
        Customer customer = new Customer("Alice");

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        customer.placeOrder(order);

        customer.displayOrder();
    }
}
