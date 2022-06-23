package OOP_2;

public class PaintExample {
    public static void main(String[] args) {
        Paint paint = new Paint(1,1);
        Circle circle = new Circle(paint,"circle", 2,Color.RED);
        System.out.println(circle);
        circle.draw();
        circle.draw(Color.BLACK);
        System.out.println();

        Rectangle rectangle = new Rectangle(paint, "rectangle", 1, 2, Color.BLUE);
        System.out.println(rectangle);

        Square square = new Square(paint, "square", 2, Color.BLACK);
        System.out.println(square);

        Triangle triangle = new Triangle(paint, "triangle", 3, 4, 5, Color.GREY);
        System.out.println(triangle);
        System.out.println();

        System.out.println("---------------");
        FigureUtil.area(circle);
        FigureUtil.perimeter(circle);
        FigureUtil.draw(circle);
        FigureUtil.draw(rectangle, Color.BLUE);
    }
}

