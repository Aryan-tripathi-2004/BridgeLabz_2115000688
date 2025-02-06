import java.util.*;

class Library{
    private ArrayList<Book> libraryBooks;

    public Library(){
        libraryBooks = new ArrayList<Book>();
    }

    public void AddBook(Book book){
        if(!libraryBooks.contains(book)) libraryBooks.add(book);
        else System.out.println("Book already exists in the library");
    }

    public void DisplayBooks(){
        for(Book book : libraryBooks){
            book.display();
        }
    }
}

class Book{
    private static String ISBN;
    private static int totalBooks;
    private String title;
    private String author;


    public Book(){
        title = "Anonymus Book";
        author = "Anonymus Author";
        ISBN = "0000000000000";
        totalBooks++;
    }

    public Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        totalBooks++;
    }

    public void display(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println();
    }

    public static void displayTotalNumberOfBooks(){
        System.out.println("Total Books: " + totalBooks);
        System.out.println();
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        Library library1 = new Library();
        Library library2 = new Library();

        Book book1 = new Book("The Alchemist", "Paulo Coelho", "978-0062315007");
        Book book2 = new Book("The Da Vinci Code", "Dan Brown", "978-0307474278");
        Book book3 = new Book("The Kite Runner", "Khaled Hosseini", "978-1594631931");
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");

        library1.AddBook(book1);
        library1.AddBook(book2);
        library2.AddBook(book3);
        library2.AddBook(book4);

        System.out.println("Library 1 Books: ");
        library1.DisplayBooks();
        System.out.println("Library 2 Books: ");
        library2.DisplayBooks();

        Book.displayTotalNumberOfBooks();

    }
}
