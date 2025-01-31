class Book{
    private String title;
    private String author;
    private int price;

    public Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void Display(){
        System.out.println("Title of the book: "+title);
        System.out.println("Author of the book: "+author);
        System.out.println("Price of the book: "+price);
    }
}
class BooksDetails{
    public static void main(String args[]){

        Book b1 = new Book("Rich Dad Poor Dad","Harsh",500);
        Book b2 = new Book("Autobiography of Yogi","Krishna",1000);

        System.out.println("===========Book Details==========");
        b1.Display();
        System.out.println("=================================");
        b2.Display();
    }
}