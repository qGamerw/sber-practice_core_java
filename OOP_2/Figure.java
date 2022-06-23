package OOP_2;

public abstract class Figure{
    
    protected Paint paint;
    protected String nameFigure;

    public Figure(Paint paint, String nameFigure){
       this.paint = paint;
       this.nameFigure = nameFigure;
    }

    protected String colorСhoice(Color color){
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

    public abstract double area();
    public abstract double perimeter();
    public abstract String toString();
}
