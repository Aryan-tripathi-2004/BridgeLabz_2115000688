public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking(){
        guestName = "John Doe"; 
        roomType = "Single";
        nights =  1;
    }
    public HotelBooking( String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    public HotelBooking(HotelBooking other){
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void display(){
        System.out.println("Guest Name: "+guestName);
        System.out.println("Room Type: "+roomType);
        System.out.println("Nights: "+nights);
    }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Aryan","Double",4);
        HotelBooking booking3 = new HotelBooking(booking2);

        booking1.display();
        System.out.println("=====================================");
        booking2.display();
        System.out.println("=====================================");
        booking3.display();
    }

}
