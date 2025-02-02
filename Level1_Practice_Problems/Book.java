public class Book{
    private String title;
    private String author;
    private int price;

    public Book(){
        title = "Java";
        author = "James Gosling";
        price = 500;    
    }
    public Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("python","Guido van Rossum",600);

        b1.display();
        System.out.println("=====================================");
        b2.display();
    }
}