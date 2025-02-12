import java.util.Scanner;

class Ticket {
    int ticketID;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;
    private int count = 0;

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        count++;
        System.out.println("Ticket booked successfully!");
    }

    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = last.next, prev = last;
        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    last = null;
                } else if (current == last) {
                    prev.next = last.next;
                    last = prev;
                } else {
                    prev.next = current.next;
                }
                count--;
                System.out.println("Ticket removed successfully!");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket ID not found.");
    }

    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        System.out.println("\nBooked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                               ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                               ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    public void searchTicket(String customerName) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Movie: " + temp.movieName +
                                   ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (!found) System.out.println("No ticket found for " + customerName);
    }

    public void countTickets() {
        System.out.println("Total booked tickets: " + count);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int choice, ticketID;
        String customerName, movieName, seatNumber, bookingTime;

        while (true) {
            System.out.println("\nTicket Reservation System:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket by Customer Name");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    ticketID = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Customer Name: ");
                    customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    seatNumber = scanner.nextLine();
                    System.out.print("Enter Booking Time: ");
                    bookingTime = scanner.nextLine();
                    system.addTicket(ticketID, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    ticketID = scanner.nextInt();
                    system.removeTicket(ticketID);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name: ");
                    customerName = scanner.nextLine();
                    system.searchTicket(customerName);
                    break;
                case 5:
                    system.countTickets();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
