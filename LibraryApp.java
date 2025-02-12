import java.util.Scanner;

class Book {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library {
    private Book head = null, tail = null;
    private int count = 0;

    public void addBookAtEnd(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void removeBook(int bookId) {
        if (head == null) return;

        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            count--;
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev;

        count--;
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " [ID: " + temp.bookId + "] Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Book: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        System.out.println("Total Books in Library: " + count);
    }
}

public class LibraryApp {
    private static final Scanner scanner = new Scanner(System.in);

    private static Book takeBookInput() {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        System.out.print("Is Available (true/false): ");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine();
        return new Book(title, author, genre, bookId, isAvailable);
    }

    public static void main(String[] args) {
        Library library = new Library();
        int choice;

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book at End");
            System.out.println("2. Display Books (Forward)");
            System.out.println("3. Display Books (Reverse)");
            System.out.println("4. Remove Book");
            System.out.println("5. Search by Title");
            System.out.println("6. Update Availability");
            System.out.println("7. Count Books");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.addBookAtEnd(takeBookInput());
                    break;
                case 2:
                    library.displayForward();
                    break;
                case 3:
                    library.displayReverse();
                    break;
                case 4:
                    System.out.print("Enter Book ID to Remove: ");
                    library.removeBook(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Book Title: ");
                    library.searchByTitle(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    library.updateAvailability(id, scanner.nextBoolean());
                    break;
                case 7:
                    library.countBooks();
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
