public class VolumeOfEarth {
    public static void main(String[] args) {
        double radiusInKm = 6378;
        double radiusInMiles = radiusInKm/1.6;

        double volumeInKm = ((double)4/3)* 3.14 * Math.pow(radiusInKm,3);
        double volumeInMiles = ((double)4/3)* 3.14 * Math.pow(radiusInMiles,3);

        System.out.println("The volume of earth in cubic kilometers is "+volumeInKm+" and cubic miles is "+volumeInMiles);
        
    }
}
