package base_syntax;
public class Task2 {
    static void QuickSort(int[] arr, int low, int high){
        if (arr.length == 0) return;
        if (low >= high) return;

        int middle = low + (high - low) / 2;
        int opora = arr[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < opora){
                i++;
            }
            while (arr[j] > opora){
                j--;
            }
            if (i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j){
            QuickSort(arr, low, j);
        }
        if (high > i){
            QuickSort(arr, i, high);
        } 
    }
    public static void main(String[] args) {
        int[] arr = { 12, -13, 24, 43, 3, 7, 20, 0, -23, 11, 0, -1};
        int low = 0;
        int high = arr.length - 1;
        
        QuickSort(arr, low, high);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
