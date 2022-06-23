package OOP_2;

public class Paint {
    private int x;
    private int y;

    public Paint(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + " " + y + ")";
    }
}
