package base_syntax;
public class Task4 {
    public static void main(String[] args) {
        int max = 0; 
        int summ = 0;
        int count = 10;
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100);
            summ += arr[i];
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.print("Mass: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Max: " + max + " " + "\nCount: " + count + "\nAve: " + (summ/count));
    }    
}
