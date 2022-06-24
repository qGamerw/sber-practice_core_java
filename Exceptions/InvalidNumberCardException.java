package Exceptions;

public class InvalidNumberCardException extends BankOnlineException{
    
    public InvalidNumberCardException () {}

    public InvalidNumberCardException (String massange){
        super(massange);
    }
}
