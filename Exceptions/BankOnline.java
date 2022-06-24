package Exceptions;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BankOnline {

    private final String regex = "[0-9]+";
    private String cardNumber;
    private Double money;
    
    public BankOnline () {}

    public BankOnline (String cardNumber, Double money){
        this.money = money;
        this.cardNumber = deleteSpaceCardNumber(cardNumber);
    }

    public void send(String cardNumber, Double money) {
        cardNumber = deleteSpaceCardNumber(cardNumber);
        try{
            if (cardNumber == null){
                throw new ArgumentNullException("Field card number is incorrect: empty field");
            } else if (money == null){
                throw new ArgumentNullException("Field money is incorrect: empty field");
            } else if (! cardNumber.matches(regex)){
                throw new InvalidNumberCardException("Card number is incorrect: only numbers");
            } else if (cardNumber.length() != 16){
                throw new InvalidNumberCardException("Card number is incorrect: length 16");
            } else if (money <= 0){
                throw new NegativeTransferAmountException("Money is incorrect: negative value");
            } else if (money > 50_000){
                throw new OutOfLimitTransferException("Exceeding the limit of 50,000");
            } else if ((this.money - money) < 0){
                throw new NegativeTransferAmountException("Insufficient funds");
            } else if (CheckLockCardNumber(cardNumber)){
                throw new TransferBlockedCardException("Card number is lock");
            } else if (cardNumber.equals(this.cardNumber)){
                throw new InvalidNumberCardException("Card number is incorrect: send to yourself");
            }

            System.out.println("Операция прошла успешно");

            } catch (ArgumentNullException eArgumentNullException){
                eArgumentNullException.printStackTrace();
            } catch (InvalidNumberCardException eInvalidNumberCardException) {
                eInvalidNumberCardException.printStackTrace();
            } catch (NegativeTransferAmountException eNegativeTransferAmountException){
                eNegativeTransferAmountException.printStackTrace();
            } catch (OutOfLimitTransferException eLimitTransferException) {
                eLimitTransferException.printStackTrace(); 
            } catch (TransferBlockedCardException eTransferBlockedCardException){
                eTransferBlockedCardException.printStackTrace();
            } 
    }

    private String deleteSpaceCardNumber(String cardNumber) {
       try{
        if (cardNumber == null){
            throw new ArgumentNullException("Field card number is incorrect: empty field");
        }
        cardNumber = cardNumber.replaceAll("\\s+","");
       } catch (ArgumentNullException eArgumentNullException){
            eArgumentNullException.printStackTrace();
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
}
