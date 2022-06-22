package OOP_1;
class Matrix{
    public int row;
    public int line;
    public double[][] arr;

    public Matrix(){}

    public Matrix(double[][] arr){
        this.row = arr.length;
        this.line = arr[0].length;
        this.arr = arr;
    }

    public void Setter(int row, int line, int value){
        this.arr[row][line] = value;
    }
    
    public double Getter(int row, int line){
        return this.arr[row][line];
    }

    public void MultiplierToNumber(double number){
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.line; j++) {
                this.arr[i][j] *= number;
            }
        }
    }

    public static double[][] MatrixAddition(double[][] arr, double[][] arr2){
        if (arr.length == arr2.length && arr[0].length == arr2[0].length){
            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[0].length; col++) {
                   arr[row][col] += arr2[row][col];
                }
            }
        }
        else{
            System.out.println("Матрицы разного размера");
        }
        return arr;
    }

    public double[][] matrixMultiplication(double[][] arr1, double[][] arr2){
        double[][] arr = new double[arr1.length][arr2[0].length];
        this.arr = arr;
        
        this.row = arr1.length;
        this.line = arr2[0].length;

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                    this.arr[row][col] = multiplyMatricesCell(arr1, arr2, row, col);
            }
        }
        
        return this.arr;
    }
    
    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public void Print(){
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.line; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}