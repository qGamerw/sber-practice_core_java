package base_syntax;
public class Task6 {
    public static void main(String[] args) {
        int row = 3, line = 6;
        String symbol = "*";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
