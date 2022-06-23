package OOP_2;

public class FigureUtil {

    private FigureUtil(){
        
    }

    private static String colorСhoice(Color color){
        if (color == Color.RED){
            return "красный";
        }
        else if (color == Color.BLUE){
            return "синий";
        }
        else if (color == Color.BLACK){
            return "черный";
        }
        else if (color == Color.GREY){
            return "серый";
        }
        else if (color == Color.PINK){
            return "розовый";
        }
        else if (color == Color.ORANGE){
            return "оранжевый";
        }
        else{
            return "None";
        }
    }

    public static void area(Figure figure){
        System.out.println("Фигура: " + figure.nameFigure + " площадь: " + figure.area());
    }

    public static void perimeter(Figure figure){
        System.out.println("Фигура: " + figure.nameFigure + " периметр: " + figure.perimeter());
    }

    public static void draw (Figure figure){
        System.out.println(String.format("Рисуем %s -> цвет: черный, координата: %s", figure.nameFigure, figure.paint));
    }

    public static void draw(Figure figure, Color color){
        System.out.println(String.format("Рисуем %s -> цвет: %s, координата: %s", figure.nameFigure, colorСhoice(color), figure.paint));
    }
}
