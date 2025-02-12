import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Movie added at the beginning.");
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Movie added at the end.");
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);

        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;

        System.out.println("Movie added at position " + position);
    }

    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie with title '" + title + "' not found.");
            return;
        }

        if (temp == head) {
            head = temp.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie '" + title + "' removed.");
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + temp.title + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found directed by " + director);
    }

    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating);
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for '" + title + "'");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie with title '" + title + "' not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies List (Forward Order):");
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies List (Reverse Order):");
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            String title, director;
            int year, position;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = scanner.nextDouble();
                    movieList.addAtBeginning(title, director, year, rating);
                    break;
            
                case 2:
                    System.out.print("Enter Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = scanner.nextDouble();
                    movieList.addAtEnd(title, director, year, rating);
                    break;
            
                case 3:
                    System.out.print("Enter Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = scanner.nextDouble();
                    System.out.print("Enter Position: ");
                    position = scanner.nextInt();
                    movieList.addAtPosition(title, director, year, rating, position);
                    break;
            
                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    title = scanner.nextLine();
                    movieList.removeByTitle(title);
                    break;
            
                case 5:
                    System.out.print("Enter Director's Name: ");
                    director = scanner.nextLine();
                    movieList.searchByDirector(director);
                    break;
            
                case 6:
                    System.out.print("Enter Rating to Search: ");
                    rating = scanner.nextDouble();
                    movieList.searchByRating(rating);
                    break;
            
                case 7:
                    System.out.print("Enter Movie Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = scanner.nextDouble();
                    movieList.updateRating(title, rating);
                    break;
            
                case 8:
                    movieList.displayForward();
                    break;
            
                case 9:
                    movieList.displayReverse();
                    break;
            
                case 10:
                    System.exit(0);
                    System.out.println("Exiting the program.");
                    
            
                default:
                    System.out.println("Invalid choice! Try again.");
            }        

        }while(true); 

    }
}
