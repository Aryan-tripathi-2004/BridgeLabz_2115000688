import java.util.*;

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; 
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; 
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; 
    }
}

class ECommerceSystem {
    public static void printFinalPrice(Product product) {
        double discount = product.calculateDiscount();
        double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
        double finalPrice = product.getPrice() + tax - discount;

        System.out.println("Product: " + product.getName() +
                            ", Price: $" + product.getPrice() + 
                            ", Discount: " + discount + 
                            ", Tax: " + tax +
                            ", Final Price: $" + finalPrice);

        if (product instanceof Taxable) {
            System.out.println(((Taxable) product).getTaxDetails());
        }
    }
}


public class EcommercePlatform {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        Product laptop = new Electronics("E001", "Laptop", 1000);
        products.add(laptop);
        Product tshirt = new Clothing("C001", "T-Shirt", 50);
        products.add(tshirt);
        Product apple = new Groceries("G001", "Apple", 10);
        products.add(apple);

        for (Product product : products) {
            ECommerceSystem.printFinalPrice(product);
            System.out.println("--------------------");
        }

    }
}
