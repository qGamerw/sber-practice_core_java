package base_syntax;
import java.util.Scanner;
public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        
        String answer = "";
        int attempt = 0;
        
        while(attempt < 3){
            answer  = sc.next();
            if (answer.equals("Троллейбус") || answer.equals("троллейбус")){
                System.out.println("Правильно!");
                break;
            }
            else if (answer.equals("Сдаюсь") || answer.equals("сдаюсь")){
                System.out.println("Правильный ответ: троллейбус");
                break;
            }
            else if (attempt != 2){
                System.out.println("Подумай ещё");
            }
            
            attempt ++;
        }
        sc.close();
    }
}
