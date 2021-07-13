package Bank.Exception;

public class InvalidCardNumberException extends BankOnlineException{
    public InvalidCardNumberException() {

    }

    public InvalidCardNumberException(String Message) {
        super(Message);
    }

}
