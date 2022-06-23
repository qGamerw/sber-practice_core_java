package Exceptions;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BankOnline {

    private final String regex = "[0-9]+";
    private String cardNumber;
    private double money;
    
    public BankOnline () {}

    public BankOnline (String cardNumber, double money) throws BankOnlineException{
        
        this.cardNumber = checkCardNumber(cardNumber);
        setMoney(money);
    }

    public void send(String cardNumber, double money) throws BankOnlineException{

        if (money > 50_000){
            throw new BankOnlineException("Exceeding the limit of 50,000");
        }
        if (money <= 0){
            throw new BankOnlineException("Money is incorrect");
        }
        if ((this.money - money) < 0){
            throw new BankOnlineException("Insufficient funds");
        }

        checkCardNumber(cardNumber);
        setMoney(this.money - money);
    }

    private String checkCardNumber(String cardNumber) throws BankOnlineException {
       
        cardNumber = cardNumber.replaceAll("\\s+","");
        
        if (cardNumber.length() != 16){
            throw new BankOnlineException("Card number is incorrect: length 16");
        }
        if (cardNumber.equals(null) || cardNumber.equals("")){
            throw new BankOnlineException("Card number is incorrect: empty field");
        }
        if (! cardNumber.matches(regex)){
            throw new BankOnlineException("Card number is incorrect: only numbers");
        }
        if (cardNumber.equals(this.cardNumber)){
            throw new BankOnlineException("Card number is incorrect");
        }
        if (CheckLockCardNumber(cardNumber)){
            throw new BankOnlineException("Card number is lock");
        }

        return cardNumber;
    }

    private boolean CheckLockCardNumber(String cardNumber){
        
        BufferedReader br = null;
        String file = "Exceptions/CardNumberLock.txt";
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            try {
                while ((line = br.readLine()) != null){
                    line = line.replaceAll("\\s+","");
                    if (cardNumber.equals(line)){
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private void setMoney(double money) throws BankOnlineException {
        if (money < 0){
            throw new BankOnlineException("Money is incorrect");
        }
    
        this.money = money;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getMoney() {
        return money;
    }

    public String toString(){
        return "Счет: " + cardNumber + " сумма: " + money;
    }
}
