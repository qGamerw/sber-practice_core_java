package OOP_2;

public class Triangle extends Figure implements Drawable{
    private int side;
    private int side2;
    private int side3;
    private String color;

    public Triangle(Paint paint, String nameFigure, int side, int side2, int side3, Color color){
        super(paint, nameFigure);
        this.side = side;
        this.side2 = side2;
        this.side3 = side3;
        this.color = colorСhoice(color);
    }

    @Override
    public double area(){
        double semiPerimeter =  perimeter() / 2;
        return Math. sqrt(semiPerimeter * (semiPerimeter - side) * (semiPerimeter - side2) * (semiPerimeter - side3)); 
    }

    @Override
    public double perimeter(){
        return (this.side + this.side2 + this.side3);
    }

    @Override
    public void draw(){
        System.out.println(String.format("Рисукм %s -> стороны: %s, %s и %s, цвет: %s, координата: %s", nameFigure, side, side2, side3, color, paint));
    }

    @Override
    public void draw(Color color){
        this.color = colorСhoice(color);
        System.out.println(String.format("Рисукм %s -> стороны: %s, %s и %s, цвет: %s, координата: %s", nameFigure, side, side2, side3, color, paint));
    }

    @Override
    public String toString(){
        return String.format("%s -> стороны: %s, %s и %s, цвет: %s, area: %s, perimeter: %s, координата: %s", nameFigure, side, side2, side3, color, area(), perimeter(), paint);
    }
}
