package OOP_2;

public class Square extends Figure implements Drawable{
    private int side;
    private String color;

    public Square (Paint paint, String nameFigure, int width, Color color){
        super(paint, nameFigure);
        this.side = width;
        this.color = colorСhoice(color);
    }

    @Override
    public double area(){
        return this.side * this.side; 
    }

    @Override
    public double perimeter(){
        return (this.side + this.side) * 2; 
    }

    @Override
    public void draw(){
        System.out.println(String.format("Рисуем %s -> сторона: %s, цвет: %s, координата: %s", nameFigure, side, color, paint));
    }

    @Override
    public void draw(Color color){
        this.color = colorСhoice(color);
        System.out.println(String.format("Рисуем %s -> сторона: %s, цвет: %s, координата: %s", nameFigure, side, color, paint));
    }

    @Override
    public String toString(){
        return String.format("%s -> сторона: %s, цвет: %s, area: %s, perimeter: %s, координата: %s", nameFigure, side, color, area(), perimeter(), paint);
    }
}
