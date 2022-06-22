package OOP_1;

public class PhoneCheck {
    public static void main(String[] args) {
        Phone phone = new Phone("7-911-444-54-45", "Samsung", 1.3);
        Phone phone2 = new Phone("7-911-444-54-88", "Aple");
        Phone phone3 = new Phone();
        
        System.out.println(phone);
        System.out.println(phone2);
        System.out.println(phone3);
        
        Phone.SendMessage();
        
        Phone.ReceiveCall("Ivan");
        Phone.ReceiveCall("Ivan", "7-911-444-54-77");
        
        System.out.println("Номер: " + phone.getNumber());
        
    }
}
