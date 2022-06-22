package OOP_1;

public class CircleCheck {
    public static void main(String[] args) {
        Circle circle = new Circle(10, "red");
        System.out.println(circle);
        System.out.println("area: " + circle.area());
        System.out.println("perimeter: " + circle.perimeter());
    }
}
