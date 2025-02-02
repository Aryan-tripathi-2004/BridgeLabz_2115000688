public class LibraryBook {
    private String title;
    private String author;
    private int price;
    private boolean isAvailable;

    public LibraryBook(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }
    public void display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
    }
    public void borrow(){
        if(isAvailable){
            isAvailable = false;
            System.out.println("Book borrowed successfully");
        }else{
            System.out.println("Sorry, This book is not available");
        }
    }

    public static void main(String args[]){
        LibraryBook book1 = new LibraryBook("Java","James Gosling",500);
        LibraryBook book2 = new LibraryBook("Python","Guido van Rossum",600);

        book1.display();
        System.out.println("=====================================");
        book2.display();
        System.out.println("=====================================");
        book1.borrow();
        book1.borrow();
    }
}
