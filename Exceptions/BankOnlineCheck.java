package Exceptions;

public class BankOnlineCheck {
    public static void main(String[] args) throws BankOnlineException {
        
        BankOnline bankOnline = new BankOnline("2222 2222 2222 2225", 100_000);
        bankOnline.send("2222 2222 2222 2227", 10);
        System.out.println(bankOnline);
    }
}
