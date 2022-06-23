package OOP_2;

public class Rectangle extends Figure implements Drawable{
    
    private int width;
    private int height;
    private String color;

    public Rectangle(Paint paint, String nameFigure, int width, int height, Color color){
        super(paint, nameFigure);
        this.width = width;
        this.height = height;
        this.color = colorСhoice(color);

    }

    @Override
    public double area(){
        return this.width * this.height; 
    }

    @Override
    public double perimeter(){
        return (this.height + this.width) * 2; 
    }

    @Override
    public void draw(){
        System.out.println(String.format("Рисуем %s -> стороны: %s и %s, цвет: %s, координата: %s", nameFigure, width, height, color, paint));
    }

    @Override
    public void draw(Color color){
        this.color = colorСhoice(color);
        System.out.println(String.format("Рисуем %s -> стороны: %s и %s, цвет: %s, координата: %s", nameFigure, width, height, color, paint));
    }

    @Override
    public String toString(){
        return String.format("%s -> стороны: %s и %s, цвет: %s, area: %s, perimeter: %s, координата: %s", nameFigure, width, height, color, area(), perimeter(), paint);
    }
}
