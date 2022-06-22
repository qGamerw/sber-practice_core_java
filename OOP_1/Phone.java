package OOP_1;
public class Phone{

    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight){
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model){
        this.number = number;
        this.model = model;
    }

    public Phone(){
        
    }

    public static void ReceiveCall(String name, String number){
        System.out.println("Звонит: " + name + ", номер: " + number);
    }

    public static void ReceiveCall(String name){
        System.out.println("Звонит: " + name);
    }

    public static void SendMessage(){
        String[] number = {"7-911-444-54-88", 
                            "7-911-444-54-99", 
                            "7-911-444-54-77", 
                            "7-911-444-54-66"
                        };
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }

    public String getNumber(){
        return this.number;
    }
    
    public String toString(){
        return String.format("Номер: %s, модель: %s, вес: %s", this.number, this.model, this.weight);
    }
}