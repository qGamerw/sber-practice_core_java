package base_syntax;
public class Task7 {
    static int[] fibonacci (int count){
        int[] fib = new int[count];
        fib[0] = 1;
        fib[1] = 1;
        
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }
    public static void main(String[] args) {
        int count = 11;
        int[] fib = new int [count + 1];
        
        fib = fibonacci(count);
        
        for (int i = 0; i < fib.length; i++) {
            System.out.print(fib[i] + " ");
        }
        
    }
    
}
