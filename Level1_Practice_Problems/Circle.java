public class Circle {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(5.5);

        System.out.println("Default Radius: " + defaultCircle.getRadius());
        System.out.println("Custom Radius: " + customCircle.getRadius());
    }
}
