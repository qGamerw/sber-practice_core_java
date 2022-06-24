package Exceptions;

public class TransferBlockedCardException extends BankOnlineException{
    
    public TransferBlockedCardException (){}

    public TransferBlockedCardException (String massange){
        super(massange);
    }
}
