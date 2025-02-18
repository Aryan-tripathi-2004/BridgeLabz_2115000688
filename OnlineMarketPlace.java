interface Category { }
interface BookCategory extends Category { }
interface ClothingCategory extends Category { }
interface GadgetCategory extends Category { }

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public T getCategory() { return category; }
}

class Catalog {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}

public class OnlineMarketPlace {
    public static void main(String[] args) {
        BookCategory fiction = new BookCategory() {};
        ClothingCategory mens = new ClothingCategory() {};
        GadgetCategory electronics = new GadgetCategory() {};

        Product<BookCategory> book = new Product<>("Java Programming", 29.99, fiction);
        Product<ClothingCategory> shirt = new Product<>("Cotton T-Shirt", 19.99, mens);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 499.99, electronics);

        System.out.println("Before discount: " + book.getName() + " - $" + book.getPrice());
        Catalog.applyDiscount(book, 20);
        System.out.println("After 20% discount: " + book.getName() + " - $" + book.getPrice());

        System.out.println("\nBefore discount: " + shirt.getName() + " - $" + shirt.getPrice());
        Catalog.applyDiscount(shirt, 30);
        System.out.println("After 30% discount: " + shirt.getName() + " - $" + shirt.getPrice());
    }
} 