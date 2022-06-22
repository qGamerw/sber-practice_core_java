package OOP_1;

public class MatrixCheck {
    public static void main(String[] args) {
        double[][] a = {{1,1},{1,1}};
        double[][] b = {{1,1,1}, {1,1,1}};
        Matrix matrix = new Matrix(a);
        Matrix matrix2 = new Matrix(b);
        Matrix matrix3 = new Matrix(b);
        Matrix matrix4 = new Matrix();

        matrix.Print();
        System.out.println();
        matrix2.Print();

        System.out.println();
        matrix2.MultiplierToNumber(2.0);
        matrix2.Print();

        System.out.println();
        matrix3.arr = Matrix.MatrixAddition(matrix2.arr, matrix3.arr);
        System.out.println();
        matrix3.Print();

        System.out.println();
        matrix4.matrixMultiplication(matrix.arr, matrix2.arr);
        matrix4.Print();
        
        System.out.println(matrix4.line + " " + matrix4.row);
    }
}
