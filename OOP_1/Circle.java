package OOP_1;
class Circle{

    private static final double PI = 3.14;

    private int radius;
    private String color;

    public Circle(int radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double area(){
        return this.radius * this.radius * PI; 
    }
    public double perimeter(){
        return 2 * PI * this.radius; 
    }

    public String toString(){
        return String.format("Радиус: %s, цвет: %s, area: %s, perimeter: %s", this.radius, this.color, area(), perimeter());
    }
}