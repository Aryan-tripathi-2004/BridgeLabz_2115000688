class Circle{
    private Double radius;

    public Circle(Double radius){
        this.radius = radius;
    }

    public void display(){
        System.out.println("Radius of Circle: "+radius);
        Double area = 3.14 * radius * radius;
        System.out.println("Area of Circle:"+area);
        Double circumference = 2 * 3.14 * radius;
        System.out.println("Circumference of Circle:"+circumference);
    }

}

public class AreaOfCircle {
    public static void main(String args[]){
        Circle C1 = new Circle(5.0);
        Circle C2 = new Circle(10.0);
        Circle C3 = new Circle(15.0);

        System.out.println("===========Circle Details===========");
        C1.display();
        System.out.println("======================================");
        C2.display();
        System.out.println("======================================");
        C3.display();
    }
}
