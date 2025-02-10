import java.util.*;

abstract class LibraryItem{
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId(){ return itemId; }
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }

    abstract int getLoanDuration();

    public String getItemDetails(){
        return "Item ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author;
    }
}

interface Reservable{
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable{
    private int loanDuration;
    private boolean isReserved;

    public Book(String itemId, String title, String author, int loanDuration){
        super(itemId, title, author);
        this.loanDuration = loanDuration;
        isReserved = false;
    }

    public int getLoanDuration(){ return loanDuration; }

    public void reserveItem(){
        if(isReserved){
            System.out.println("Item already reserved.");
        }
        else{
            isReserved = true;
            System.out.println("Item reserved.");
        }
    }

    public boolean checkAvailability(){
        return !isReserved;
    }
}

class DVD extends LibraryItem implements Reservable{
    private int loanDuration;
    private boolean isReserved;

    public DVD(String itemId, String title, String author, int loanDuration){
        super(itemId, title, author);
        this.loanDuration = loanDuration;
        isReserved = false;
    }

    public int getLoanDuration(){ return loanDuration; }

    public void reserveItem(){
        if(isReserved){
            System.out.println("Item already reserved.");
        }
        else{
            isReserved = true;
            System.out.println("Item reserved.");
        }
    }

    public boolean checkAvailability(){
        return !isReserved;
    }
}

class Magazine extends LibraryItem implements Reservable{
    private int loanDuration = 0;

    public Magazine(String itemId, String title, String author){
        super(itemId, title, author);
    }

    public int getLoanDuration(){ return loanDuration; }

    public void reserveItem(){
        System.out.println("Magazines cannot be reserved.");
    }

    public boolean checkAvailability(){
        return true;
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args) {
        ArrayList<LibraryItem> libraryItems = new ArrayList<LibraryItem>();

        LibraryItem Book1 = new Book("B001", "Book1", "Author1", 14);
        LibraryItem DVD1 = new DVD("D001", "DVD1", "Author2", 7);
        LibraryItem Magazine1 = new Magazine("M001", "Magazine1", "Author3");

        libraryItems.add(Book1);
        libraryItems.add(DVD1);
        libraryItems.add(Magazine1);

        for(LibraryItem item : libraryItems){
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if(item instanceof Reservable){
                Reservable reservableItem = (Reservable)item;
                if(reservableItem.checkAvailability()){
                    reservableItem.reserveItem();
                }
                else{
                    System.out.println("Item not available for reservation.");
                }
            }
            System.out.println();
        }

        ((Reservable)Book1).reserveItem();
    }
}