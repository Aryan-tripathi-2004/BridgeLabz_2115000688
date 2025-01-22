import java.util.*;

class Question8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
    
        System.out.print("Enter your Name: ");
        String name = sc.next();
       
        System.out.print("Enter your fromCity: ");
        String fromCity = sc.next();
        System.out.print("Enter your viaCity: ");
        String viaCity = sc.next();
        System.out.print("Enter your toCity: ");
        String toCity = sc.next();
 
        System.out.print("Enter your distanceFromToVia: ");
        double distanceFromToVia = sc.nextDouble();
 
        System.out.print("Enter your timeFromToVia(in Hrs): ");
        int timeFromToVia = sc.nextInt() * 60;
 
        System.out.print("Enter your distanceViaToFinalCity: ");
        double distanceViaToFinalCity = sc.nextDouble();
 
        System.out.print("Enter your timeViaToFinalCity(in Hrs): ");
        int timeViaToFinalCity = sc.nextInt() * 60;
 
       
       double totalDistance = distanceFromToVia + distanceViaToFinalCity;
       int totalTime = timeFromToVia + timeViaToFinalCity;
 
 
       System.out.println("The Total Distance travelled by " + name + " from " + 
                          fromCity + " to " + toCity + " via " + viaCity +
                          " is " + totalDistance + " km and " +
                          "the Total Time taken is " + totalTime + " minutes");
    }
 }
 