package OOP_2;

public class Circle extends Figure implements Drawable{
    
    private static final double PI = 3.14;
    private int radius;
    private String color;

    public Circle(Paint paint, String nameFigure, int radius, Color color){
        super(paint, nameFigure);
        this.radius = radius;
        this.color = colorСhoice(color);
    }

    @Override
    public double area(){
        return 2 * PI * this.radius; 
    }
    
    @Override
    public double perimeter(){
        return this.radius * this.radius * PI; 
    }

    @Override
    public void draw(){
        System.out.println(String.format("Рисуем %s -> радиус: %s, цвет: %s, координата: %s", nameFigure, radius, color, paint));
    }

    @Override
    public void draw(Color color){
        this.color = colorСhoice(color);
        System.out.println(String.format("Рисуем %s -> радиус: %s, цвет: %s, координата: %s", nameFigure, radius, color, paint));
    }

    @Override
    public String toString(){
        return String.format("%s -> радиус: %s, цвет: %s, area: %s, perimeter: %s, координата: %s", nameFigure, radius, color, area(), perimeter(), paint);
    }
}
