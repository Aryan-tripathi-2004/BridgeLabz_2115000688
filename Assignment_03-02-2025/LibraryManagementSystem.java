class Book {
    private static String libraryName = "City Library";
    
    private final String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book("978-0135166307", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra & Bert Bates");

        Book.displayLibraryName();
        System.out.println();

        book1.displayBookDetails();
        System.out.println();
        book2.displayBookDetails();
    }
}
