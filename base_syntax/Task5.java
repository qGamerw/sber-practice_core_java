package base_syntax;
public class Task5 {
    public static void main(String[] args) {
        boolean flag;
        int count = 100;
        
        for (int i = 2; i < count; i++) {
            flag = true;
            
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.print(i + " ");
            }
        }
    }
}
