package Exceptions;

public class BankOnlineCheck {
    public static void main(String[] args) {
        
        BankOnline bankOnline = new BankOnline("2222 2222 2222 2227", 1_000_000.00);

        try{
            bankOnline.send("2222 2222 2222 2228", 1_000.00);
        } catch (BankOnlineException eBankOnlineException){
            eBankOnlineException.printStackTrace(); 
        }
        
        System.out.println();

        System.out.println("Проверка работы исключения\n");
        
        // bankOnline.send("2222 2222 2222 2227", 1_000.00);
        // bankOnline.send("2222 2222 2222 222", 1_000.00);
        // bankOnline.send("2222 2222 2222 2222", 1_000.00);
        // bankOnline.send(null, 1_000.00);

        // bankOnline.send("2222 2222 2222 2228", null);
        // bankOnline.send("2222 2222 2222 2228", -1_000.00);
        // bankOnline.send("2222 2222 2222 2228", 60_000.00);

        try{
            bankOnline.send("2222 2222 2222 2228", -60_000.00);

            } catch (BankOnlineException eBankOnlineException){
                eBankOnlineException.printStackTrace(); 
            }
         
        System.out.println("Продолжение работы программы"); 
    }
}
